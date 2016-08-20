package com.tao.jiang.mytestapp.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tao.jiang.mytestapp.R;
import com.tao.jiang.mytestapp.widget.MyListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyListViewActivity extends Activity implements MyListView.OnLoadMore {
    private static final String TAG = "MyListViewActivity";
    private Context context;
    private Activity activity;
    private LayoutInflater inflater;
    private Handler handler;
    private static List<Map<String, String>> listPlaces = new ArrayList<>();
    private static MyAdapter myAdapter;
    private static final String MAP_KEY_PLACE = "place";
    private static final String MAP_KEY_NAME = "name";
    MyListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;
        activity = this;
        inflater = getLayoutInflater();

        setContentView(R.layout.activity_my_list_view);

        getPlaces();
        myAdapter = new MyAdapter(inflater, context);
        myListView = (MyListView) findViewById(R.id.mlv_1);
        myListView.setAdapter(myAdapter);
        myListView.setLoadMoreListen(this);
    }

    private void getPlaces() {

        Map<String, String> map;
        listPlaces.clear();

        for (int i = 0; i < 5; i++) {
            map = new HashMap<>();
            map.put(MAP_KEY_PLACE, "p" + i);
            map.put(MAP_KEY_NAME, "n" + i);
            listPlaces.add(map);
        }


    }

    private void addPlaces() {

        Map<String, String> map;

        for (int i = 0; i < 5; i++) {
            map = new HashMap<>();
            map.put(MAP_KEY_PLACE, "ap" + i);
            map.put(MAP_KEY_NAME, "an" + i);
            listPlaces.add(map);
        }


    }

    @Override
    public void loadMore() {
        addPlaces();
        myAdapter.notifyDataSetChanged();
    }

    private class ViewHolderItem {
        public TextView place;
        public TextView name;
    }

    private class MyAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        private Context context;

        public MyAdapter(LayoutInflater inflater, Context context) {
            super();
            this.inflater = inflater;
            this.context = context;
        }

        @Override
        public int getCount() {
            return listPlaces.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolderItem holder;
            if (convertView == null) {
                holder = new ViewHolderItem();
                convertView = inflater.inflate(R.layout.layout_my_listview_item, null);
                holder.place = (TextView) convertView.findViewById(R.id.tv_1);
                holder.name = (TextView) convertView.findViewById(R.id.tv_2);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolderItem) convertView.getTag();
            }

            if (listPlaces.size() == 0) {
                return convertView;
            }


            String place = listPlaces.get(position).get("place").toString();
            String name = listPlaces.get(position).get("name").toString();
            holder.place.setText(place);
            holder.name.setText(name);

            return convertView;
        }
    }
}
