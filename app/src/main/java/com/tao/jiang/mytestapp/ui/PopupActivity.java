package com.tao.jiang.mytestapp.ui;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tao.jiang.mytestapp.R;
import com.tao.jiang.mytestapp.utils.WindowUtils;

public class PopupActivity extends AppCompatActivity {
    private Handler mHandler = null;
    private static final String TAG = "PopupActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        mHandler = new Handler();

        Button button = (Button) findViewById(R.id.btn_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        WindowUtils.showPopupWindow(PopupActivity.this);
//                        new Thread(new Runnable() {
//                            @Override
//                            public void run() {
//                                try {
//                                    Thread.sleep(3000);
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//                                WindowUtils.hidePopupWindow();
//                            }
//                        }).start();
                    }
                }, 1000 * 2);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "====================onResume");
    }
}
