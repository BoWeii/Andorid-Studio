package com.example.android.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Intent intent = getIntent();
        int pic = intent.getIntExtra("pic",0);
        String lyric=intent.getStringExtra("lyric");
        ImageView img=findViewById(R.id.imageView);
        TextView text=findViewById(R.id.textView);
        text.setText(lyric);
        img.setImageResource(pic);

    }
}
