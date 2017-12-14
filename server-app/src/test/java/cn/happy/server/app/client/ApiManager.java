package cn.happy.server.app.client;

import org.forkjoin.apikit.client.HttpClientAdapter;

/**
 * api 管理器，单例，使用之前需要初始化
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

	public ApiManager(HttpClientAdapter httpClientAdapter) {
		this.httpClientAdapter = httpClientAdapter;

	}
}
