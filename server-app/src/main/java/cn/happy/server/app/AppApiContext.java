package cn.happy.server.app;

import cn.happy.server.core.spring.boot.BootContext;
import org.forkjoin.apikit.spring.AccountHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import java.util.Locale;

@Configuration
public class AppApiContext extends BootContext {

    public AppApiContext() {
    }

    @Override
    public AccountHandlerInterceptor accountHandlerInterceptor() {
        return new UserAccountHandlerInterceptor();
    }

    @Override
    public Class getAccountClass() {
        return UserAccount.class;
    }

    /**
     * 语言此处强制解析为中文
     * @return
     */
    @Bean
    public FixedLocaleResolver localeResolver() {
        return new FixedLocaleResolver(Locale.SIMPLIFIED_CHINESE);
    }

}
