package com.tao.jiang.mytestapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tao.jiang.mytestapp.R;
import com.tao.jiang.mytestapp.utils.Utils;

import java.io.Serializable;

public class MainActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Activity activity;
    private Context context;
    private Button btn_1;

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick");
        switch (view.getId()) {
            case R.id.btn_1: {
                Intent intent = new Intent(this, DownloadActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_2: {
                Intent intent = new Intent(this, ServiceActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_3: {
                Intent intent = new Intent(this, CustomViewActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_4: {
                Intent intent = new Intent(this, PopupActivity.class);
                startActivity(intent);
                break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity = this;
        context = this;

        View rootView = ((ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content)).getChildAt(0);

        Log.d(TAG, "rootView: " + rootView);
        Utils.getNavigationBarHeight(activity);
        Utils.getStatusBarHeight(activity);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        //就是setContentView中设置的view
        rootView = ((ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content)).getChildAt(0);
        Log.d(TAG, "rootView: " + rootView);


        Log.d(TAG, "getWindow().getDecorView().getId(): " + getWindow().getDecorView().getId());
        Log.d(TAG, "getWindow().getDecorView().getRootView().getId(): " + getWindow().getDecorView().getRootView().getId());
        Log.d(TAG, "((ViewGroup)getWindow().getDecorView().findViewById(android.R.id.content)).getChildAt(0).getId(): " + ((ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content)).getChildAt(0));
        Log.d(TAG, "R.layout.activity_main: " + R.layout.activity_main);


        Button button = (Button) rootView.findViewById(R.id.btn_1);
        button.setOnClickListener(this);

        button = (Button) findViewById(R.id.btn_2);
        button.setOnClickListener(this);

        button = (Button) findViewById(R.id.btn_3);
        button.setOnClickListener(this);

        button = (Button) findViewById(R.id.btn_4);
        button.setOnClickListener(this);
    }


    class User implements Serializable {

    }

}
