package com.jiyehoo.login.model;

/**
 * TODO feature
 *
 * @author aobing
 * @since 2022/2/26 11:43 下午
 */
public class RegisterReq {

    private String accountId;
    private String confirmPassword;
    private String pass;
    private String password;

    public RegisterReq (String accountId, String confirmPassword, String pass, String password) {
        this.accountId = accountId;
        this.confirmPassword = confirmPassword;
        this.pass = pass;
        this.password = password;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
