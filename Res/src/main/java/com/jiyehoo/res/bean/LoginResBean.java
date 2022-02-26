package com.jiyehoo.res.bean;

import androidx.annotation.NonNull;

/**
 * TODO feature
 *
 * @author aobing
 * @since 2022/2/27 12:12 上午
 */
public class LoginResBean {
    private boolean data;
    private int errcode;
    private String errmsg;

    public boolean isData() {
        return data;
    }

    public void setData(boolean data) {
        this.data = data;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @NonNull
    @Override
    public String toString() {
        return "LoginCallBack{" +
                "data=" + data +
                ", errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
