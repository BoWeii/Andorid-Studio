package com.example.a106590021_hw4_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class secondActivity extends AppCompatActivity {
    private static final String LOG_TAG=secondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(LOG_TAG,"-------");
        Log.d(LOG_TAG,"onCreate");
    }

}
