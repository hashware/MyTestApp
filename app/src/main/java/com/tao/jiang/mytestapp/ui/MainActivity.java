package com.tao.jiang.mytestapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tao.jiang.mytestapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity = this;
        context = this;


        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.btn_1);
        button.setOnClickListener(this);
    }


}
