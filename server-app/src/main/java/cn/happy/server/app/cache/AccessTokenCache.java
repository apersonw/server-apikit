package cn.happy.server.app.cache;

import cn.happy.server.app.db.dao.AccessTokenDao;
import cn.happy.server.app.db.entity.AccessTokenDO;
import cn.happy.server.app.db.entity.meta.AccessTokenMeta;
import org.forkjoin.jdbckit.cache.EntityCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author zuoge85@gmail.com on 2017/6/8.
 */
@Component
public class AccessTokenCache extends EntityCache<AccessTokenDO.Key, AccessTokenDO> {
    @Autowired
    private AccessTokenDao accessTokenDao;

    public AccessTokenCache() {
        super(AccessTokenDO.class, AccessTokenMeta.instance);
    }

    @PostConstruct
    public void init() {
        super.init(accessTokenDao);
    }
}
