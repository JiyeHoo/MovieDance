package com.jiyehoo.res;

import com.jiyehoo.res.bean.LoginResBean;

/**
 * TODO feature
 *
 * @author aobing
 * @since 2022/2/26 11:53 下午
 */
public interface IHttpCallback {
    void onFailure(int errorCode, String errorMsg);
    void onResponse(LoginResBean resBean);
}
