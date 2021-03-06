package cn.happy.server.app;

import cn.happy.server.core.spring.boot.EmbededMysql;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Configuration
@EnableTransactionManagement
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceConfig {
    public DataSourceConfig() {
    }

    private List<String> initSqls;

    @Autowired
    private EmbededMysql embededMysql;

    @Bean(name = "dataSource", destroyMethod = "close", initMethod = "init")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    @Order
    public DataSource dataSource() throws SQLException {
        DruidDataSource source = new DruidDataSource();
        source.setFilters("stat");

        source.setTimeBetweenEvictionRunsMillis(60000);
        source.setMinEvictableIdleTimeMillis(300000);

        source.setTestWhileIdle(true);
        source.setTestOnBorrow(false);
        source.setTestOnReturn(false);

        source.setPoolPreparedStatements(true);
        source.setMaxOpenPreparedStatements(200);
        source.setConnectionInitSqls(initSqls);
        return source;
    }

    public List<String> getInitSqls() {
        return initSqls;
    }

    public void setInitSqls(List<String> initSqls) {
        this.initSqls = initSqls;
    }
}
