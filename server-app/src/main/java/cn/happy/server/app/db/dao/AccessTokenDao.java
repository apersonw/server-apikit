package cn.happy.server.app.db.dao;

import org.forkjoin.jdbckit.core.impi.BaseDaoImpi;
import cn.happy.server.app.db.entity.AccessTokenDO;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class AccessTokenDao extends BaseDaoImpi<AccessTokenDO,AccessTokenDO.Key>  {
	public AccessTokenDao() {
		super(AccessTokenDO.ENTITY_META);
	}

	public AccessTokenDO get(int id) {
		return get(new AccessTokenDO.Key(id));
	}
}
