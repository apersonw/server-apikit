package cn.happy.server.app.db.dao;

import org.forkjoin.jdbckit.core.impi.BaseDaoImpi;
import cn.happy.server.app.db.entity.UserDO;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class UserDao extends BaseDaoImpi<UserDO,UserDO.Key>  {
	public UserDao() {
		super(UserDO.ENTITY_META);
	}

	public UserDO get(int id) {
		return get(new UserDO.Key(id));
	}
}
