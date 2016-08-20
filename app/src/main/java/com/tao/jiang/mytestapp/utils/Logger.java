package com.tao.jiang.mytestapp.utils;

import android.util.Log;

/**
 * Created by Jiang on 2016/8/19.
 */
public class Logger {
    public static boolean DEBUG = false;

    public static void d(String TAG, String msg) {
        if (DEBUG)
            Log.d(TAG, msg);
    }
}
