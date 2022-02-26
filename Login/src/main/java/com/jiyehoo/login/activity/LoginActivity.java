package com.jiyehoo.login.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyehoo.login.R;
import com.jiyehoo.login.manager.LoginManager;
import com.jiyehoo.res.IHttpCallback;
import com.jiyehoo.res.MyLog;
import com.jiyehoo.res.bean.LoginResBean;

import java.io.IOException;
import java.util.Calendar;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "###LoginActivity";

    private ImageView mIvBackground;
    private TextView mTvWelcome;
    private EditText mEtUser, mEtPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fullScreen();

        setContentView(R.layout.activity_login);

        initView();
        autoPic();
    }

    private void fullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void initView() {
        mIvBackground = findViewById(R.id.iv_background);
        mTvWelcome = findViewById(R.id.tv_welcome);
        mEtUser = findViewById(R.id.et_login_user);
        mEtPwd = findViewById(R.id.et_login_pwd);

        findViewById(R.id.btn_sign_in).setOnClickListener(this);
        findViewById(R.id.btn_register).setOnClickListener(this);


    }

    /**
     * 时间背景
     */
    private void autoPic() {
        int hours = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        mIvBackground.setImageResource(
                hours < 12 ? R.drawable.good_morning_img : R.drawable.good_night_img
        );

        mTvWelcome.setText(
                hours < 12 ? " Morning" : " Night"
        );
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_sign_in) {
            // 登录
            MyLog.d(TAG, "开始登录");
            signIn();
        } else if (v.getId() == R.id.btn_register) {
            // 注册
            register();
        }
    }

    private void register() {

    }

    private void signIn() {
        LoginManager.getInstance().login(getUser(), getPwd(), new IHttpCallback() {
            @Override
            public void onFailure(int errorCode, String errorMsg) {
                runOnUiThread(() ->
                        Toast.makeText(
                                LoginActivity.this,
                                "登录失败," + errorMsg + "," + errorMsg,
                                Toast.LENGTH_LONG
                        ).show());
            }

            @Override
            public void onResponse(LoginResBean resBean) {
                runOnUiThread(() -> {
                    if (resBean.isData()) {
                        Toast.makeText(
                                LoginActivity.this,
                                "登录成功,",
                                Toast.LENGTH_LONG
                        ).show();
                    }

                });
            }
        });
    }

    private String getUser() {
        if (null == mEtUser) return "";
        return mEtUser.getText().toString();
    }

    private String getPwd() {
        if (null == mEtPwd) return "";
        return mEtPwd.getText().toString();
    }

}