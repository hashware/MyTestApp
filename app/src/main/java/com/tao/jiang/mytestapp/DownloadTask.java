package com.tao.jiang.mytestapp;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Jiang on 2016/7/30.
 */
public class DownloadTask extends AsyncTask<Void, Integer, Boolean> {
    private static final String TAG = "DownloadTask";

    @Override
    protected void onPreExecute() {
        Log.d(TAG, "");
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        return null;
    }
}
