package cn.happy.server.core.spring.boot;

import org.springframework.beans.factory.annotation.Value;
import redis.embedded.RedisServer;
import redis.embedded.RedisServerBuilder;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

public class EmbededRedis {
    @Value("${spring.redis.embeded}")
    private boolean embeded;

    @Value("${spring.redis.port}")
    private int redisPort;

    private RedisServer redisServer;

    @PostConstruct
    public void start() throws IOException {
        if (embeded) {
            redisServer = new RedisServerBuilder()
                    .setting("bind 127.0.0.1")
                    .setting("maxmemory 1024MB")
                    .port(redisPort)
                    .build();
            redisServer.start();
        }
    }

    @PreDestroy
    public void stopRedis() {
        redisServer.stop();
    }
}
