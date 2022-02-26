package com.jiyehoo.login.presenter;


import android.text.TextUtils;

import com.google.gson.Gson;
import com.jiyehoo.login.api.ILoginPresenter;
import com.jiyehoo.login.model.LogInReq;
import com.jiyehoo.res.ErrorCode;
import com.jiyehoo.res.bean.LoginResBean;
import com.jiyehoo.res.HttpUtils;
import com.jiyehoo.res.IHttpCallback;
import com.jiyehoo.res.MyLog;
import com.jiyehoo.res.URLUtils;

/**
 * TODO feature
 *
 * @author aobing
 * @since 2022/2/26 10:46 下午
 */
public class LoginPresenter implements ILoginPresenter {

    private static final String TAG = "###LoginPresenter";

    private static LoginPresenter instance;

    public static synchronized LoginPresenter getInstance() {
        if (instance == null) {
            synchronized (LoginPresenter.class) {
                if (instance == null) {
                    instance = new LoginPresenter();
                }
            }
        }
        return instance;
    }

    public void signIn(String user, String pwd, IHttpCallback callback) {
        if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pwd)) {
            MyLog.d(TAG, "[signIn] user or pwd isEmpty");
            callback.onFailure(ErrorCode.LOGIN_USER_OR_PWD_NULL, "User or Pwd is NULL");
        }

        LogInReq logInReq = new LogInReq(user, pwd);

//        String logInReqJson = new Gson().toJson(logInReq);

        String logInReqJson = "{\"accountId\": \"12\",\"password\": \"123\"}";

        String res;
        try {
            res = HttpUtils.post(URLUtils.getLoginUrl(), logInReqJson);
        } catch (Exception e) {
            callback.onFailure(ErrorCode.LOGIN_JSON_PARSE_ERROR, "parse response error");
            e.printStackTrace();
            return;
        }

        if (TextUtils.isEmpty(res)) {
            callback.onFailure(ErrorCode.LOGIN_RES_NULL, "Login post is NULL");
            return;
        }

        try {
            LoginResBean resBean = new Gson().fromJson(res, LoginResBean.class);
            callback.onResponse(resBean);
        } catch (Exception e) {
            callback.onFailure(ErrorCode.LOGIN_JSON_PARSE_ERROR, "parse LoginResBean error");
            e.printStackTrace();
        }

    }





}
