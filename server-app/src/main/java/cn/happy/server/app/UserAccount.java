package cn.happy.server.app;

import cn.happy.server.app.db.entity.UserDO;

import java.util.Date;

public class UserAccount {
    private UserDO userDO;

    public UserAccount(UserDO userDO) {
        this.userDO = userDO;
    }

    public int getId() {
        return userDO.getId();
    }

    public String getName() {
        return userDO.getName();
    }

    public String getNickName() {
        return userDO.getNickName();
    }

    public String getMobile() {
        return userDO.getMobile();
    }

    public String getUuid() {
        return userDO.getUuid();
    }

    public String getPassword() {
        return userDO.getPassword();
    }

    public Date getCreateTime() {
        return userDO.getCreateTime();
    }

    public Date getUpdateTime() {
        return userDO.getUpdateTime();
    }
}
