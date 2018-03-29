package cn.happy.server.app.client;

import org.forkjoin.apikit.client.HttpClientAdapter;

import cn.happy.server.app.client.api.AccountApi;

/**
 * api 管理器，单例，使用之前需要初始化
 * @author zuoge85 on 15/6/15.
 */
public class ApiManager {
	private static ApiManager instance;

	/**
	 * 初始化
	 */
	public static void init(HttpClientAdapter httpClientAdapter) {
		instance = new ApiManager(httpClientAdapter);
	}

	public static ApiManager getInstance() {
		return instance;
	}

	private HttpClientAdapter httpClientAdapter;

	/**
	 * Created by Happy on 17-12-14.
	 */
	public final AccountApi accountApi;

	public ApiManager(HttpClientAdapter httpClientAdapter) {
		this.httpClientAdapter = httpClientAdapter;

		accountApi = new AccountApi(httpClientAdapter);
	}
}
