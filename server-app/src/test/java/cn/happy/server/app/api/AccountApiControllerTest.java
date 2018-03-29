package cn.happy.server.app.api;

import cn.happy.server.app.BaseControllerTest;
import cn.happy.server.app.client.model.UserModel;
import org.junit.Assert;
import org.junit.Test;

public class AccountApiControllerTest extends BaseControllerTest {

    @Test
    public void getUserModel() throws Exception {
        auth();
        UserModel userModel = apiManager.accountApi.getUserModelData();
        Assert.assertNotNull(userModel);
        Assert.assertNotNull(userModel.getMobile());
    }
}
