package com.example.a106590021_hw8_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

     int mScore=3;
     ImageView image;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image=findViewById(R.id.imageView);
        image.setImageLevel(mScore);
    }

    public void minus(View view) {
        if(mScore>0)
        {
            mScore--;
        }
        image.setImageLevel(mScore);
    }

    public void add(View view) {
        if (mScore < 6) {
            mScore++;

        }
        image.setImageLevel(mScore);
    }

}
