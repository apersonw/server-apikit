package cn.happy.server.app.model;

import cn.happy.server.app.db.entity.UserDO;
import org.forkjoin.apikit.core.Message;
import org.springframework.beans.BeanUtils;

/**
 * @author Happy on 18-3-29
 */
@Message
public class UserModel {
    /**
     * 用户id
     */
    private int id;
    /**
     * 用户账号
     */
    private String name;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 余额，单位分
     */
    private int money;
    /**
     * 用户头像图片KEY
     */
    private String imgKey;
    /**
     * 版本号
     */
    private int version;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 身份证号
     */
    private String idNumber;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 通讯地址
     */
    private String address;
    /**
     * 营业执照照片KEY
     */
    private String licenseImgKey;
    /**
     * 认证，0未认证，1审核中，2已认证
     */
    private Integer authStatus;
    /**
     * 认证类型,true企业,false个人
     */
    private Boolean authType;

    public UserModel(UserDO userDO) {
        BeanUtils.copyProperties(userDO, this);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", money=" + money +
                ", imgKey='" + imgKey + '\'' +
                ", version=" + version +
                ", realName='" + realName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", licenseImgKey='" + licenseImgKey + '\'' +
                ", authStatus=" + authStatus +
                ", authType=" + authType +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getImgKey() {
        return imgKey;
    }

    public void setImgKey(String imgKey) {
        this.imgKey = imgKey;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicenseImgKey() {
        return licenseImgKey;
    }

    public void setLicenseImgKey(String licenseImgKey) {
        this.licenseImgKey = licenseImgKey;
    }

    public Integer getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(Integer authStatus) {
        this.authStatus = authStatus;
    }

    public Boolean getAuthType() {
        return authType;
    }

    public void setAuthType(Boolean authType) {
        this.authType = authType;
    }
}
