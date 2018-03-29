package cn.happy.server.app.service;

import cn.happy.server.app.UserAccount;
import cn.happy.server.app.cache.AccessTokenCache;
import cn.happy.server.app.cache.UserCache;
import cn.happy.server.app.db.dao.AccessTokenDao;
import cn.happy.server.app.db.dao.UserDao;
import cn.happy.server.app.db.entity.AccessTokenDO;
import cn.happy.server.app.db.entity.UserDO;
import cn.happy.server.app.db.entity.meta.AccessTokenMeta;
import cn.happy.server.app.db.entity.meta.UserMeta;
import cn.happy.server.app.model.UserModel;
import cn.happy.server.core.utils.UUIDUtils;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.forkjoin.apikit.spring.I18nValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Happy on 18-3-29
 */
@Service
public class AccountService {
    private static final int SIZE = 2000;
    @Autowired
    private AccessTokenCache accessTokenCache;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserCache userCache;
    @Autowired
    private AccessTokenDao accessTokenDao;
    /**
     * 密码盐
     */
    @Value("${account.passwordSalt}")
    private String passwordSalt;
    private Cache<String, UserAccount> accountCache;

    @PostConstruct
    public void init() {
        accountCache = CacheBuilder.newBuilder()
                .weakKeys()
                .weakValues()
                .maximumSize(SIZE)
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .build();
    }

    /**
     * 创建Token(ByMobileAndPassword)
     */
    @Transactional
    public AccessTokenDO createTokenByMobileAndPassword(String mobile, String password) {
        UserDO user = userCache.getByUnique(UserMeta.UNIQUE_MOBILE, mobile);
        if (user == null || !StringUtils.equals(user.getPassword(), newHashPassword(password))) {
            throw I18nValidationException.of("nameOrPassword", "error", "nameOrPassword");
        }
        //删除过去登录的所有token
        accessTokenDao
                .find(AccessTokenMeta.USER_ID, user.getId())
                .forEach(r -> accessTokenCache.del(r));
        //创建token
        AccessTokenDO tokenDO = new AccessTokenDO();
        tokenDO.setUserId(user.getId());
        tokenDO.setToken(UUIDUtils.randomUUIDToBase64());
        Date createTime = new Date();
        tokenDO.setCreateTime(createTime);
        accessTokenCache.insert(tokenDO);
        //记录用户登录时间
        user.setUpdateTime(createTime);
        userDao.update(user);
        return tokenDO;
    }

    /**
     * 查询用户信息(ById)
     */
    public UserModel getUserModelByUserId(int userId) {
        UserDO userDO = userDao.get(userId);
        if (null == userDao.get(userId)) {
            throw I18nValidationException.of("user", "noFound", "user");
        }
        return new UserModel(userDO);
    }

    /**
     * 2次hash，可以把第一次hash放到客户端
     */
    private String newHashPassword(String password) {
        return newHashPassword(passwordSalt, password);
    }

    private static String newHashPassword(String passwordSalt, String password) {
        password = DigestUtils.sha256Hex(password);
        return Base64Utils.encodeToUrlSafeString(DigestUtils.sha256(password + passwordSalt));
    }

    public static void main(String[] args) {
        System.out.println(newHashPassword("haUY19", "12345678"));
    }

    public UserAccount getByToken(String accessToken) throws ExecutionException {
        if (accessToken == null) {
            return null;
        }

        try {
            UserAccount userAccount = accountCache.get(accessToken, () -> {
                AccessTokenDO tokenDO = accessTokenCache.getByUnique(AccessTokenMeta.UNIQUE_TOKEN, accessToken);

                if (tokenDO == null) {
                    throw I18nValidationException.of("accessToken", "noFound", "accessToken");
                }

                UserDO userDO = userCache.get(new UserDO.Key((int) tokenDO.getUserId()));
                if (userDO == null) {
                    throw I18nValidationException.of("user", "noFound", "user");
                }
                return new UserAccount(userDO);
            });
            return userAccount;
        } catch (Exception ex) {
            if (ex.getCause() instanceof I18nValidationException) {
                deleteToken(accessToken);
                return null;
            } else {
                throw ex;
            }
        }
    }

    private void deleteToken(String accessToken) {
        accountCache.invalidate(accessToken);
        accessTokenCache.delByUnique(AccessTokenMeta.UNIQUE_TOKEN, accessToken);
    }
}
