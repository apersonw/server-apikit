package cn.happy.server.app;

import cn.happy.server.app.client.ApiManager;
import org.forkjoin.apikit.client.AbstractHttpClientAdapter;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@Import({TestsContext.class})
@SpringBootTest(classes = AppApplication.class)
//@ActiveProfiles("remote")
@ActiveProfiles("mock")
@ComponentScan(basePackages = {"cn.happy.fstar.app.util"})
public abstract class BaseControllerTest {
    public static final String PASSWORD = "12345678";
    public static final String MOBILE = "12345678901";
    public static String TOKEN = null;

    @Autowired
    protected ApiManager apiManager;

    @Autowired
    protected AbstractHttpClientAdapter httpClientAdapter;

    public void auth() throws Exception {
        if (null == TOKEN) {
            TOKEN = "";
        }
        httpClientAdapter.setAccountToken(TOKEN);
    }
}