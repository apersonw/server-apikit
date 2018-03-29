package cn.happy.server.app.cache;

import cn.happy.server.app.db.dao.UserDao;
import cn.happy.server.app.db.entity.UserDO;
import cn.happy.server.app.db.entity.meta.UserMeta;
import org.forkjoin.jdbckit.cache.EntityCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author zuoge85@gmail.com on 2017/6/8.
 */
@Component
public class UserCache extends EntityCache<UserDO.Key, UserDO> {
    @Autowired
    private UserDao userDao;

    public UserCache() {
        super(UserDO.class, UserMeta.instance);
    }

    @PostConstruct
    public void init() {
        super.init(userDao);
    }
}
