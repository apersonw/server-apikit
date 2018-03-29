package cn.happy.server.app;


import cn.happy.server.app.service.AccountService;
import org.apache.commons.lang3.StringUtils;
import org.forkjoin.apikit.spring.AccountHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAccountHandlerInterceptor extends AccountHandlerInterceptor<UserAccount> {
    @Autowired
    private AccountService accountService;
    @Value("${management.context-path}")
    private String managementContextPath;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (StringUtils.isNotEmpty(managementContextPath)) {
            if (request.getRequestURI().startsWith(managementContextPath)) {
                return true;
            }
        }
        if (request.getRequestURI().startsWith("/error")) {
            return true;
        }
        if (request.getRequestURI().startsWith("/swagger-resources")) {
            return true;
        }
        if (request.getRequestURI().startsWith("/ws")) {
            return true;
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    protected UserAccount getAccountObject(HttpServletRequest request) throws Exception {
        String accessToken = request.getHeader(ACCOUNT_TOKEN_HEADER_NAME);
        return accountService.getByToken(accessToken);
    }

}
