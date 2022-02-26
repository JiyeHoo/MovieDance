package com.jiyehoo.login.manager;

import android.content.Context;
import android.content.Intent;

import com.jiyehoo.login.activity.LoginActivity;
import com.jiyehoo.login.activity.SplashActivity;
import com.jiyehoo.login.api.ILoginManager;
import com.jiyehoo.login.presenter.LoginPresenter;
import com.jiyehoo.res.IHttpCallback;

import java.io.IOException;

/**
 * TODO feature
 *
 * @author aobing
 * @since 2022/1/14 11:39 下午
 */
public class LoginManager implements ILoginManager {
    private static final String TAG = "###LoginManager";

    private static LoginManager instance;

    public static synchronized LoginManager getInstance() {
        if (instance == null) {
            synchronized (LoginManager.class) {
                if (instance == null) {
                    instance = new LoginManager();
                }
            }
        }
        return instance;
    }

    @Override
    public void startLoginActivity(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    @Override
    public void startSplashActivity(Context context) {
        context.startActivity(new Intent(context, SplashActivity.class));
    }

    @Override
    public void login(String user, String pwd, IHttpCallback callBack) {
        LoginPresenter.getInstance().signIn(user, pwd, callBack);
    }


}
