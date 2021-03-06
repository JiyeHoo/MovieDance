package com.jiyehoo.res;

import android.util.Log;

/**
 * @author JiyeHoo
 * @description: Log 工具，isLogOpen 控制整个 App 是否打印日志
 * @date :2021/5/16 下午6:55
 */
public class MyLog {
    private final static boolean isLogOpen = true;
    public MyLog(){}

    public static void i(String TAG, String msg) {
        if (isLogOpen) {
            Log.i(TAG, msg);
        }
    }

    public static void d(String TAG, String msg) {
        if (isLogOpen) {
            Log.d(TAG, msg);
        }
    }

    public static void w(String TAG, String msg) {
        if (isLogOpen) {
            Log.w(TAG, msg);
        }
    }

    public static void e(String TAG, String msg) {
        if (isLogOpen) {
            Log.e(TAG, msg);
        }
    }
}
