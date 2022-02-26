package com.jiyehoo.login.api;

import android.content.Context;

import com.jiyehoo.res.IHttpCallback;

import java.io.IOException;

/**
 * TODO feature
 *
 * @author aobing
 * @since 2022/1/14 11:39 下午
 */
public interface ILoginManager {

    void startLoginActivity(Context context);

    void startSplashActivity(Context context);

    void login(String user, String pwd, IHttpCallback callBack) throws IOException;

}
