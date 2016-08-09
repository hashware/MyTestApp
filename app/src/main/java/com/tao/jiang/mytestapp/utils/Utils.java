package com.tao.jiang.mytestapp.utils;

import android.app.Activity;
import android.util.Log;

/**
 * Created by Jiang on 2016/8/4.
 */
public class Utils {
    private static final String TAG = "Utils";


    public static int getNavigationBarHeight(Activity activity) {
        int height = 0;
        int resourceId = activity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            height = activity.getResources().getDimensionPixelSize(resourceId);
            Log.d(TAG, "navigation_bar_height:" + height);
        }
        return height;
    }

    public static int getStatusBarHeight(Activity activity) {
        int height = 0;
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            height = activity.getResources().getDimensionPixelSize(resourceId);
            Log.d(TAG, "status_bar_height:" + height);
        }
        return height;
    }
}
