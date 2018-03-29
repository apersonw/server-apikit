package cn.happy.server.app;

import cn.happy.server.core.spring.boot.EmbededMysql;
import org.forkjoin.db.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.io.File;

@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(pattern = ".*", type = FilterType.REGEX))
@Import(DataSourceConfig.class)
@Configuration
public class AppApiDaoBuilder implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(AppApiDaoBuilder.class);
        springApplication.setWebEnvironment(false);
        springApplication.run(args);
    }

    @Bean
    public EmbededMysql EmbededMysql() {
        return new EmbededMysql();
    }

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... strings) throws Exception {
        File root = new File("server-app");
        //如果找不到路径，可以在此处添加
        if (!root.exists()) {
            root = new File("server/server-app");
        }
        Builder builder = new Builder(
                root, dataSource, "cn.happy.server.app.db"
        );
        builder.build();
    }
}
