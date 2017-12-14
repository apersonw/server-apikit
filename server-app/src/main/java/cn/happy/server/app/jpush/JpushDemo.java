package cn.happy.server.app.jpush;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Happy on 17-10-12.
 */
public class JpushDemo {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        JPushClient jpushClient = new JPushClient(
                "af04fd12d0ee70e8a69c50fc",
                "42a1721b5f68406346b473d1",
                null,
                ClientConfig.getInstance());

        PushPayload payload = buildPushObject_all_all_alert();

        try {
            PushResult result = jpushClient.sendPush(payload);
            logger.info("Got result - " + result);

        } catch (APIConnectionException e) {
            // Connection error, should retry later
            logger.error("Connection error, should retry later", e);

        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            logger.error("Should review the error, and fix the request", e);
            logger.info("HTTP Status: " + e.getStatus());
            logger.info("Error Code: " + e.getErrorCode());
            logger.info("Error Message: " + e.getErrorMessage());
        }
    }

    public static PushPayload buildPushObject_all_all_alert() {
        return PushPayload.alertAll("你好啊");
    }
}
