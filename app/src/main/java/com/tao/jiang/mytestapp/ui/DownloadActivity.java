package com.tao.jiang.mytestapp.ui;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tao.jiang.mytestapp.R;

public class DownloadActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "DownloadActivity";
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        Button button = (Button) findViewById(R.id.btn_1);
        button.setOnClickListener(this);


        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1: {
                new DownloadTask().execute();
                break;
            }
        }
    }

    class DownloadTask extends AsyncTask<Void, Integer, Boolean> {
        @Override
        protected void onPreExecute() {
            Log.d(TAG, "onPreExecute");
            progressDialog.show();
            progressDialog.setProgress(0);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            progressDialog.dismiss();
            Log.d(TAG, "onPostExecute " + aBoolean);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressDialog.setMessage("" + values[0]);

        }

        @Override
        protected void onCancelled() {
            Log.d(TAG, "onCancelled");
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            int per = 0;
            while (true) {
                per += 1;
//                publishProgress(per);
                progressDialog.incrementProgressBy(1);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (per >= 100) {
                    break;
                }
            }
            return true;
        }
    }
}
