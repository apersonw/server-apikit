package cn.happy.server.app.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

/**
 * Created by Happy on 17-9-25.
 * 初始化数据库
 */
@Component
@Order(1)
public class ApplicationStartup implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        InetAddress addr = InetAddress.getLocalHost();
        String hostName = addr.getHostName(); //获取本机计算机名称
    }
}
