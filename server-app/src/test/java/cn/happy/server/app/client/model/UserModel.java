package cn.happy.server.app.client.model;

import org.forkjoin.apikit.core.*;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * @author  Happy on 18-3-29
 */
public class UserModel implements ApiMessage {

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
	private int authStatus;

	/**
	 * 认证类型,true企业,false个人
	 */
	private boolean authType;

	public UserModel() {
	}

	public UserModel(int id, String name, String nickName, String mobile, int money, String imgKey, int version,
			String realName, String idNumber, String email, String address, String licenseImgKey, int authStatus,
			boolean authType) {
		this.id = id;
		this.name = name;
		this.nickName = nickName;
		this.mobile = mobile;
		this.money = money;
		this.imgKey = imgKey;
		this.version = version;
		this.realName = realName;
		this.idNumber = idNumber;
		this.email = email;
		this.address = address;
		this.licenseImgKey = licenseImgKey;
		this.authStatus = authStatus;
		this.authType = authType;
	}

	/**
	 * 用户id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 用户id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 用户账号
	 */
	public String getName() {
		return name;
	}

	/**
	 * 用户账号
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 用户昵称
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * 用户昵称
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * 手机号
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 余额，单位分
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * 余额，单位分
	 */
	public void setMoney(int money) {
		this.money = money;
	}

	/**
	 * 用户头像图片KEY
	 */
	public String getImgKey() {
		return imgKey;
	}

	/**
	 * 用户头像图片KEY
	 */
	public void setImgKey(String imgKey) {
		this.imgKey = imgKey;
	}

	/**
	 * 版本号
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * 版本号
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * 真实姓名
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * 真实姓名
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * 身份证号
	 */
	public String getIdNumber() {
		return idNumber;
	}

	/**
	 * 身份证号
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	/**
	 * 电子邮箱
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 电子邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 通讯地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 通讯地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 营业执照照片KEY
	 */
	public String getLicenseImgKey() {
		return licenseImgKey;
	}

	/**
	 * 营业执照照片KEY
	 */
	public void setLicenseImgKey(String licenseImgKey) {
		this.licenseImgKey = licenseImgKey;
	}

	/**
	 * 认证，0未认证，1审核中，2已认证
	 */
	public int getAuthStatus() {
		return authStatus;
	}

	/**
	 * 认证，0未认证，1审核中，2已认证
	 */
	public void setAuthStatus(int authStatus) {
		this.authStatus = authStatus;
	}

	/**
	 * 认证类型,true企业,false个人
	 */
	public boolean getAuthType() {
		return authType;
	}

	/**
	 * 认证类型,true企业,false个人
	 */
	public void setAuthType(boolean authType) {
		this.authType = authType;
	}

	@Override
	public List<Entry<String, Object>> encode(String $parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<>($parent + "id", id));

		if (name != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "name", name));
		}

		if (nickName != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "nickName", nickName));
		}

		if (mobile != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "mobile", mobile));
		}

		$list.add(new SimpleImmutableEntry<>($parent + "money", money));

		if (imgKey != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "imgKey", imgKey));
		}

		$list.add(new SimpleImmutableEntry<>($parent + "version", version));

		if (realName != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "realName", realName));
		}

		if (idNumber != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "idNumber", idNumber));
		}

		if (email != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "email", email));
		}

		if (address != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "address", address));
		}

		if (licenseImgKey != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "licenseImgKey", licenseImgKey));
		}

		$list.add(new SimpleImmutableEntry<>($parent + "authStatus", authStatus));

		$list.add(new SimpleImmutableEntry<>($parent + "authType", authType));

		return $list;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ",name=" + name + ",nickName=" + nickName + ",mobile=" + mobile + ",money="
				+ money + ",imgKey=" + imgKey + ",version=" + version + ",realName=" + realName + ",idNumber="
				+ idNumber + ",email=" + email + ",address=" + address + ",licenseImgKey=" + licenseImgKey
				+ ",authStatus=" + authStatus + ",authType=" + authType + ", ]";
	}
}