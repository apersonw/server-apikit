package  cn.happy.server.app.db.entity;

import java.beans.Transient;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


import org.forkjoin.jdbckit.core.UniqueInfo;


import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import org.forkjoin.jdbckit.core.EntityObject;
import org.forkjoin.jdbckit.core.KeyObject;
import org.forkjoin.jdbckit.core.EntityMeta;
import org.forkjoin.jdbckit.core.identifier.*;

import cn.happy.server.app.db.entity.meta.UserMeta;

public class UserDO extends EntityObject<UserDO, UserDO.Key>{

    /**用户id*/
    private int id;
    /**用户账号*/
    private String name;
    /**用户昵称*/
    private String nickName;
    /**手机号*/
    private String mobile;
    /**uuid*/
    private String uuid;
    /**用户密码HASH*/
    private String password;
    /**余额，单位分*/
    private int money;
    /**用户头像图片KEY*/
    private String imgKey;
    /**版本号*/
    private int version;
    private java.util.Date createTime;
    private java.util.Date updateTime;
    /**真实姓名*/
    private String realName;
    /**身份证号*/
    private String idNumber;
    /**电子邮箱*/
    private String email;
    /**通讯地址*/
    private String address;

    public static class Key implements KeyObject<UserDO, UserDO.Key>{
        private int id;

        public Key() {
        }

        public Key(int id) {
            this.id = id;
        }

        @JsonIgnore
        @Transient
        @Override
        public Object[] getQueryParams() {
            return new Object[]{
                getId()
            };
        }

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toStringKey(){
            return String.valueOf(getId());

        }

        @Override
        public UserMeta getEntityMeta() {
            return ENTITY_META;
        }

        @Override
        public String toString() {
            return "User[id:"+ id+ "]";
        }
    }

    @Override
    public Key getKey() {
        return new Key() {

            public int getId() {
                return id;
            }

            @Override
            public String toString() {
                return "User[id:"+ id+ "]";
            }
        };
    }




    public UserDO() {
    }

    public UserDO(String name,String nickName,String mobile,String uuid,String password,int money,String imgKey,int version,java.util.Date createTime,java.util.Date updateTime,String realName,String idNumber,String email,String address) {
        this.name = name;
        this.nickName = nickName;
        this.mobile = mobile;
        this.uuid = uuid;
        this.password = password;
        this.money = money;
        this.imgKey = imgKey;
        this.version = version;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.realName = realName;
        this.idNumber = idNumber;
        this.email = email;
        this.address = address;
    }


    public UserDO newInstance(){
        return new UserDO();
    }

    public void setKey(Object key){
        this.id = ((Number)key).intValue();
    }

    /**
     * 用户id
     **/
    public int getId() {
        return id;
    }

    /**
     * 用户id
     **/
    public void setId(int id) {
        this.id = id;
        changeProperty("id",id);
    }

    /**
     * 用户账号
     **/
    public String getName() {
        return name;
    }

    /**
     * 用户账号
     **/
    public void setName(String name) {
        this.name = name;
        changeProperty("name",name);
    }

    /**
     * 用户昵称
     **/
    public String getNickName() {
        return nickName;
    }

    /**
     * 用户昵称
     **/
    public void setNickName(String nickName) {
        this.nickName = nickName;
        changeProperty("nickName",nickName);
    }

    /**
     * 手机号
     **/
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号
     **/
    public void setMobile(String mobile) {
        this.mobile = mobile;
        changeProperty("mobile",mobile);
    }

    /**
     * uuid
     **/
    public String getUuid() {
        return uuid;
    }

    /**
     * uuid
     **/
    public void setUuid(String uuid) {
        this.uuid = uuid;
        changeProperty("uuid",uuid);
    }

    /**
     * 用户密码HASH
     **/
    public String getPassword() {
        return password;
    }

    /**
     * 用户密码HASH
     **/
    public void setPassword(String password) {
        this.password = password;
        changeProperty("password",password);
    }

    /**
     * 余额，单位分
     **/
    public int getMoney() {
        return money;
    }

    /**
     * 余额，单位分
     **/
    public void setMoney(int money) {
        this.money = money;
        changeProperty("money",money);
    }

    /**
     * 用户头像图片KEY
     **/
    public String getImgKey() {
        return imgKey;
    }

    /**
     * 用户头像图片KEY
     **/
    public void setImgKey(String imgKey) {
        this.imgKey = imgKey;
        changeProperty("imgKey",imgKey);
    }

    /**
     * 版本号
     **/
    public int getVersion() {
        return version;
    }

    /**
     * 版本号
     **/
    public void setVersion(int version) {
        this.version = version;
        changeProperty("version",version);
    }

    public java.util.Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
        changeProperty("createTime",createTime);
    }

    public java.util.Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
        changeProperty("updateTime",updateTime);
    }

    /**
     * 真实姓名
     **/
    public String getRealName() {
        return realName;
    }

    /**
     * 真实姓名
     **/
    public void setRealName(String realName) {
        this.realName = realName;
        changeProperty("realName",realName);
    }

    /**
     * 身份证号
     **/
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * 身份证号
     **/
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
        changeProperty("idNumber",idNumber);
    }

    /**
     * 电子邮箱
     **/
    public String getEmail() {
        return email;
    }

    /**
     * 电子邮箱
     **/
    public void setEmail(String email) {
        this.email = email;
        changeProperty("email",email);
    }

    /**
     * 通讯地址
     **/
    public String getAddress() {
        return address;
    }

    /**
     * 通讯地址
     **/
    public void setAddress(String address) {
        this.address = address;
        changeProperty("address",address);
    }

    @Override
    public Object get(Field dbName){
        switch(dbName.getNativeValue()){
        case "id":
            return id;
        case "name":
            return name;
        case "nickName":
            return nickName;
        case "mobile":
            return mobile;
        case "uuid":
            return uuid;
        case "password":
            return password;
        case "money":
            return money;
        case "imgKey":
            return imgKey;
        case "version":
            return version;
        case "create_time":
            return createTime;
        case "update_time":
            return updateTime;
        case "real_name":
            return realName;
        case "id_number":
            return idNumber;
        case "email":
            return email;
        case "address":
            return address;
        default :
            return null;
        }
    }


    @Override
    public boolean set(Field dbName, Object obj) {
        switch(dbName.getNativeValue()){
        case "id":
            id = (int)obj;
            return true;
        case "name":
            name = (String)obj;
            return true;
        case "nickName":
            nickName = (String)obj;
            return true;
        case "mobile":
            mobile = (String)obj;
            return true;
        case "uuid":
            uuid = (String)obj;
            return true;
        case "password":
            password = (String)obj;
            return true;
        case "money":
            money = (int)obj;
            return true;
        case "imgKey":
            imgKey = (String)obj;
            return true;
        case "version":
            version = (int)obj;
            return true;
        case "create_time":
            createTime = (java.util.Date)obj;
            return true;
        case "update_time":
            updateTime = (java.util.Date)obj;
            return true;
        case "real_name":
            realName = (String)obj;
            return true;
        case "id_number":
            idNumber = (String)obj;
            return true;
        case "email":
            email = (String)obj;
            return true;
        case "address":
            address = (String)obj;
            return true;
        default :
            return false;
        }
    }

    @Override
    public String toString() {
        return "User[id:"+ id+",name:"+ (name == null ?"null":name.substring(0, Math.min(name.length(), 64)))+",nickName:"+ (nickName == null ?"null":nickName.substring(0, Math.min(nickName.length(), 64)))+",mobile:"+ (mobile == null ?"null":mobile.substring(0, Math.min(mobile.length(), 64)))+",uuid:"+ (uuid == null ?"null":uuid.substring(0, Math.min(uuid.length(), 64)))+",password:"+ (password == null ?"null":password.substring(0, Math.min(password.length(), 64)))+",money:"+ money+",imgKey:"+ (imgKey == null ?"null":imgKey.substring(0, Math.min(imgKey.length(), 64)))+",version:"+ version+",createTime:"+ createTime+",updateTime:"+ updateTime+",realName:"+ (realName == null ?"null":realName.substring(0, Math.min(realName.length(), 64)))+",idNumber:"+ (idNumber == null ?"null":idNumber.substring(0, Math.min(idNumber.length(), 64)))+",email:"+ (email == null ?"null":email.substring(0, Math.min(email.length(), 64)))+",address:"+ (address == null ?"null":address.substring(0, Math.min(address.length(), 64)))+ "]";
    }

    @Override
    @JsonIgnore
    @Transient
    public UserMeta getEntityMeta() {
        return ENTITY_META;
    }


    public static final UserMeta ENTITY_META = UserMeta.instance;
}
