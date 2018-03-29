package cn.happy.server.app.client.api;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.Future;

import org.forkjoin.apikit.client.*;

import cn.happy.server.app.client.form.LoginForm;
import cn.happy.server.app.client.model.UserModel;
import org.forkjoin.apikit.core.Result;

/**
 * Created by Happy on 17-12-14.
 */
public class AccountApi {
	private HttpClientAdapter httpClientAdapter;

	public AccountApi(HttpClientAdapter httpClientAdapter) {
		this.httpClientAdapter = httpClientAdapter;
	}

	/**
	 * 用户登录
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>login</b>
	 * <ul>
	 * <li><b>Form:</b>LoginFormlogin</li>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @see String
	 * @see LoginForm

	 */
	public String loginData(LoginForm loginForm) {
		Result<String> result = login(loginForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			if (ex != null) {
				throw new RuntimeException(ex.getMessage(), ex);
			} else {
				throw new RuntimeException(result.toString());
			}
		}
		return result.getData();
	}

	/**
	 * 用户登录
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>login</b>
	 * <ul>
	 * <li><b>Form:</b>LoginFormlogin</li>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @see String
	 * @see LoginForm

	 */
	public Result<String> login(LoginForm loginForm) {
		Map<String, Object> _uriVariables = new HashMap<>();
		String _url = ApiUtils.expandUriComponent("login", _uriVariables);

		List<Entry<String, Object>> _form = loginForm.encode("", new ArrayList<Entry<String, Object>>());
		return httpClientAdapter.<Result<String>, String> request("POST", _url, _form, _0Type, false);
	}

	/**
	 * 用户登录
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>login</b>
	 * <ul>
	 * <li><b>Form:</b>LoginFormlogin</li>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @see String
	 * @see LoginForm

	 */
	public Future<?> login(LoginForm loginForm, Callback<Result<String>, String> callable) {
		Map<String, Object> _uriVariables = new HashMap<>();
		String _url = ApiUtils.expandUriComponent("login", _uriVariables);

		List<Entry<String, Object>> _form = loginForm.encode("", new ArrayList<Entry<String, Object>>());
		return httpClientAdapter.requestAsync("POST", _url, _form, _0Type, false, callable);
	}

	/**
	 * 查询个人信息
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>account/info</b>
	 * <ul>
	 * <li><b>Form:</b>UserAccountgetUserModel</li>
	 * <li><b>Model:</b> UserModel</li>
	 * <li>需要登录</li>
	 * </ul>
	 * </div>
	 * @see UserModel

	 */
	public UserModel getUserModelData() {
		Result<UserModel> result = getUserModel();
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			if (ex != null) {
				throw new RuntimeException(ex.getMessage(), ex);
			} else {
				throw new RuntimeException(result.toString());
			}
		}
		return result.getData();
	}

	/**
	 * 查询个人信息
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>account/info</b>
	 * <ul>
	 * <li><b>Form:</b>UserAccountgetUserModel</li>
	 * <li><b>Model:</b> UserModel</li>
	 * <li>需要登录</li>
	 * </ul>
	 * </div>
	 * @see UserModel

	 */
	public Result<UserModel> getUserModel() {
		Map<String, Object> _uriVariables = new HashMap<>();
		String _url = ApiUtils.expandUriComponent("account/info", _uriVariables);

		return httpClientAdapter.<Result<UserModel>, UserModel> request("GET", _url, null, _1Type, true);
	}

	/**
	 * 查询个人信息
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>account/info</b>
	 * <ul>
	 * <li><b>Form:</b>UserAccountgetUserModel</li>
	 * <li><b>Model:</b> UserModel</li>
	 * <li>需要登录</li>
	 * </ul>
	 * </div>
	 * @see UserModel

	 */
	public Future<?> getUserModel(Callback<Result<UserModel>, UserModel> callable) {
		Map<String, Object> _uriVariables = new HashMap<>();
		String _url = ApiUtils.expandUriComponent("account/info", _uriVariables);

		return httpClientAdapter.requestAsync("GET", _url, null, _1Type, true, callable);
	}

	private static final ApiType _0Type = ApiUtils.type(Result.class, ApiUtils.type(String.class));
	private static final ApiType _1Type = ApiUtils.type(Result.class, ApiUtils.type(UserModel.class));
}