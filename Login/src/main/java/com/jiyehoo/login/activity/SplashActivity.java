package com.jiyehoo.login.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.jiyehoo.login.R;
import com.jiyehoo.login.manager.LoginManager;
import com.seagazer.animlogoview.AnimLogoView;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "###SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fullScreen();
        setContentView(R.layout.activity_splash);

        AnimLogoView animLogoView = findViewById(R.id.anim_logo);
        animLogoView.addOffsetAnimListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d(TAG, "Offset anim end");
            }
        });
        animLogoView.addGradientAnimListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d(TAG, "Gradient anim end");
                LoginManager.getInstance().startLoginActivity(SplashActivity.this);
                finish();
            }
        });
        animLogoView.startAnimation();


    }

    private void fullScreen() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    }
}