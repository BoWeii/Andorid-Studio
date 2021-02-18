package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    TextView show;
    public static final String EXTRA_num ="321";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent2=getIntent();
        String message=intent2.getStringExtra(MainActivity.EXTRA_MESSAGE);
        show=findViewById(R.id.textView);
        show.setText(message);

    }
}
