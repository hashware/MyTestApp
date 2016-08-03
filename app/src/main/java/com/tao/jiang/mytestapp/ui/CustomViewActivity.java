package com.tao.jiang.mytestapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tao.jiang.mytestapp.R;

public class CustomViewActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG = "CustomViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);

        Button button = (Button) findViewById(R.id.btn_1);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick");
        switch (view.getId()) {
            case R.id.btn_1: {
                Intent intent = new Intent(this, HorizontalScrollViewExActivity.class);
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
        }
    }
}
