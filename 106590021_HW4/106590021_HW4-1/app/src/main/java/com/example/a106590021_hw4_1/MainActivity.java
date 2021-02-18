package com.example.a106590021_hw4_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int count=0;
    private String countNumber;
    private TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show=(TextView)findViewById(R.id.textView);
        if(savedInstanceState!=null)
        {
            count=savedInstanceState.getInt (countNumber);
            show.setText(Integer.toString(count));
        }
    }
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(countNumber, count);
        super.onSaveInstanceState(savedInstanceState);

    }

    public void countUp(View view) {
        count++;
        if (show != null)
            show.setText(Integer.toString(count));
    }
}
