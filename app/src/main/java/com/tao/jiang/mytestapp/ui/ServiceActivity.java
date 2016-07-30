package com.tao.jiang.mytestapp.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tao.jiang.mytestapp.MyService;
import com.tao.jiang.mytestapp.R;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private MyService.MyBinder myBinder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myBinder = (MyService.MyBinder) iBinder;
            myBinder.func1();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);


        Button button = (Button) findViewById(R.id.btn_1);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.btn_2);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.btn_3);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.btn_4);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1: {
                Intent intent = new Intent(this, MyService.class);
                startService(intent);
                break;
            }
            case R.id.btn_2: {
                Intent intent = new Intent(this, MyService.class);
                stopService(intent);
                break;
            }
            case R.id.btn_3: {
                Intent intent = new Intent(this, MyService.class);
                bindService(intent, connection, BIND_AUTO_CREATE);
                break;
            }
            case R.id.btn_4: {
                Intent intent = new Intent(this, MyService.class);
                unbindService(connection);
                break;
            }
        }
    }
}
