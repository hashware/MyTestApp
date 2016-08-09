package com.tao.jiang.mytestapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.tao.jiang.mytestapp.R;

public class ListView1Activity extends AppCompatActivity {
private ListView lv_test1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view1);

        lv_test1 = (ListView) findViewById(R.id.lv_test1);
    }
}
