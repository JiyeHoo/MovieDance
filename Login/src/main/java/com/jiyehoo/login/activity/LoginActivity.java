package com.jiyehoo.login.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyehoo.login.R;
import com.jiyehoo.res.MyLog;

import java.util.Calendar;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "###LoginActivity";

    private ImageView mIvBackground;
    private TextView mTvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fullScreen();
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
}