package com.tao.jiang.mytestapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.widget.EditText;

import com.tao.jiang.mytestapp.R;

public class EditTextActivity extends AppCompatActivity {

    private EditText et_1;
    private static final String TAG = "EditTextActivity";

    private InputFilter inputFilter = new InputFilter() {
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            Log.d(TAG, "source: " + source.toString());
            Log.d(TAG, "start: " + start);
            Log.d(TAG, "end: " + end);
            if (source.equals(" ")) {
                return "";
            }

            //空白符号
            String s = source.toString();
            s = s.replaceAll("\\s+", " ");
            int index = s.indexOf(" ");
            Log.d(TAG, "index: " + index);
            if (index >= 0) {
                Log.d(TAG, "have space");
                return "";
            }

            if (end == 2) {
                int type = Character.getType(source.charAt(0));
                int type1 = Character.getType(source.charAt(1));
                //中文符 （）等
                if (type == Character.START_PUNCTUATION && type1 == Character.END_PUNCTUATION) {
                    return null;
                }
                //中文 ……
                if (type == Character.OTHER_PUNCTUATION && type1 == Character.OTHER_PUNCTUATION) {
                    return null;
                }
                //中文符 ——
                if (type == Character.DASH_PUNCTUATION && type1 == Character.DASH_PUNCTUATION) {
                    return null;
                }
            }

            //多个字符符合
            if (end > 1) {
                Log.d(TAG, "end > 1");
                for (int i = start; i < end; i++) {
                    int type = Character.getType(source.charAt(i));
                    Log.e(TAG, "type: " + type);
                    if (type == Character.SURROGATE
                            || type == Character.DASH_PUNCTUATION
                            || type == Character.START_PUNCTUATION
                            || type == Character.END_PUNCTUATION
                            || type == Character.CONNECTOR_PUNCTUATION
                            || type == Character.OTHER_PUNCTUATION
                            || type == Character.MATH_SYMBOL
                            || type == Character.MODIFIER_SYMBOL
                            || type == Character.OTHER_SYMBOL) {
                        return "";
                    }
                }
            }

            for (int i = start; i < end; i++) {
                int type = Character.getType(source.charAt(i));
                Log.e(TAG, "type: " + type);
                if (type == Character.SURROGATE
                        || type == Character.OTHER_SYMBOL) {
                    return "";
                }
            }

            return null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);


        et_1 = (EditText) findViewById(R.id.et_1);
        et_1.setFilters(new InputFilter[]{inputFilter});
    }
}
