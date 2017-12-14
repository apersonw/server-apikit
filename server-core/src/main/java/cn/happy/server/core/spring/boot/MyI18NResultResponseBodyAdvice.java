package cn.happy.server.core.spring.boot;

import org.forkjoin.apikit.spring.I18NResultResponseBodyAdvice;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(basePackages = "cn.happy.server.app.api")
public class MyI18NResultResponseBodyAdvice extends I18NResultResponseBodyAdvice {
}
