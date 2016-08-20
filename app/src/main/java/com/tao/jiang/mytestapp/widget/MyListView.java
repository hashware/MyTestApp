package com.tao.jiang.mytestapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.ListView;

import com.tao.jiang.mytestapp.utils.Logger;

/**
 * Created by Jiang on 2016/8/19.
 */
public class MyListView extends ListView implements AbsListView.OnScrollListener {
    private static final String TAG = "MyListView";
    private int last;
    private int total;
    private OnLoadMore onLoadMore;

    public MyListView(Context context) {
        super(context);
        init();
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.setOnScrollListener(this);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        Logger.d(TAG, "scrollState: " + scrollState);
        Logger.d(TAG, "last: " + last);
        Logger.d(TAG, "total: " + total);
        if (last == total && scrollState == SCROLL_STATE_IDLE) {
            try {
                Logger.d(TAG, "onLoadMore.loadMore()");
                onLoadMore.loadMore();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        Logger.d(TAG, "firstVisibleItem: " + firstVisibleItem);
        Logger.d(TAG, "visibleItemCount: " + visibleItemCount);
        Logger.d(TAG, "totalItemCount: " + totalItemCount);
        last = firstVisibleItem + visibleItemCount;
        total = totalItemCount;
    }

    public void setLoadMoreListen(OnLoadMore onLoadMore) {
        this.onLoadMore = onLoadMore;
    }

    public interface OnLoadMore {
        void loadMore();
    }
}
