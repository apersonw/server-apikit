package cn.happy.server.app.api;

import cn.happy.server.app.UserAccount;
import cn.happy.server.app.form.LoginForm;
import cn.happy.server.app.model.UserModel;
import cn.happy.server.app.service.AccountService;
import org.forkjoin.apikit.core.Account;
import org.forkjoin.apikit.core.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by Happy on 17-12-14.
 */
@Api
@RestController
@RequestMapping(value = "v1")
public class AccountApiController {
    @Autowired
    private AccountService accountService;

    /**
     * 用户登录
     */
    @Account(false)
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@Valid LoginForm loginForm) {
        return accountService
                .createTokenByMobileAndPassword(loginForm.getMobile(), loginForm.getPassword())
                .getToken();
    }

    /**
     * 查询个人信息
     */
    @RequestMapping(value = "account/info", method = RequestMethod.GET)
    public UserModel getUserModel(
            UserAccount userAccount
    ) {
        return accountService
                .getUserModelByUserId(userAccount.getId());
    }
}
