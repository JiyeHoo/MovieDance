package com.jiyehoo.moviedance;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tencent.mmkv.MMKV;

/**
 * TODO feature
 *
 * @author aobing
 * @since 2022/2/16 10:29 下午
 */
public class MainApplication extends AppCompatActivity {

    private static final String TAG = "###MainApplication";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        String rootDir = MMKV.initialize(this);
//        Log.d(TAG, "mmkv root: " + rootDir);
    }
}
