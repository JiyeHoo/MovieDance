package com.jiyehoo.login.manager;

import android.content.Context;
import android.content.Intent;

import com.jiyehoo.login.activity.LoginActivity;
import com.jiyehoo.login.activity.SplashActivity;
import com.jiyehoo.login.api.ILoginManager;

/**
 * TODO feature
 *
 * @author aobing
 * @since 2022/1/14 11:39 下午
 */
public class LoginManager implements ILoginManager {

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


}
