package cn.happy.server.app.form;

import org.forkjoin.apikit.core.Message;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author Happy on 18-3-29
 */
@Message
public class LoginForm {
    /**
     * 手机号，测试手机号：12345678901
     */
    @NotNull
    @Length(min = 11,max=11)
    private String mobile;
    /**
     * 密码，测试密码：12345678
     */
    @NotNull
    @Length(min=8,max=32)
    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
