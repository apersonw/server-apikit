package cn.happy.server.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(
        scanBasePackages = {
                "cn.happy.server.app.service",
                "cn.happy.server.app.init",
                "cn.happy.server.app.api",
                "cn.happy.server.app.cache",
        }
)
@ServletComponentScan(basePackages = {
        "cn.happy.server.app.druid",
})
@Import({
        DataSourceConfig.class, AppApiContext.class, RedisConfig.class
})
@ImportResource("classpath*:cn/happy/server/app/db/DaoContext.xml")
public class AppApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }
}