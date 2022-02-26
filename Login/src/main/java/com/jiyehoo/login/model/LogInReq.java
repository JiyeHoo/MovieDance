package com.jiyehoo.login.model;

/**
 * TODO feature
 *
 * @author aobing
 * @since 2022/2/26 11:46 下午
 */
public class LogInReq {

    private String accountId;
    private String password;

    public LogInReq(String accountId, String password) {
        this.accountId = accountId;
        this.password = password;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
