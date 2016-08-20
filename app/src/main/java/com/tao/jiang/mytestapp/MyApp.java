package com.tao.jiang.mytestapp;

import android.app.Application;

import com.tao.jiang.mytestapp.utils.Logger;

/**
 * Created by Jiang on 2016/8/19.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Logger.DEBUG = true;
    }
}
