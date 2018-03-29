package cn.happy.server.app.client.form;

import org.forkjoin.apikit.core.*;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * @author  Happy on 18-3-29
 */
public class LoginForm implements ApiMessage {

	/**
	 * 手机号，测试手机号：12345678901
	 */
	private String mobile;

	/**
	 * 密码，测试密码：12345678
	 */
	private String password;

	public LoginForm() {
	}

	public LoginForm(String mobile, String password) {
		this.mobile = mobile;
		this.password = password;
	}

	/**
	 * 手机号，测试手机号：12345678901
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 手机号，测试手机号：12345678901
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 密码，测试密码：12345678
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 密码，测试密码：12345678
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public List<Entry<String, Object>> encode(String $parent, List<Entry<String, Object>> $list) {

		if (mobile != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "mobile", mobile));
		}

		if (password != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "password", password));
		}

		return $list;
	}

	@Override
	public String toString() {
		return "LoginForm [mobile=" + mobile + ",password=" + password + ", ]";
	}
}