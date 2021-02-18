package com.example.a106590021_hw2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String countNumber;
    private int count = 0;
    private TextView showCount;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCount=(TextView) findViewById(R.id.textView);
        if (savedInstanceState!=null)
        {
            Button zero = findViewById(R.id.zero);
            Button mCount = findViewById(R.id.count);
            count=savedInstanceState.getInt (countNumber);
            showCount.setText(Integer.toString(count));
            if (count!=0)
            {
                zero.setBackgroundColor(Color.parseColor("#FF00FF"));
                if (count % 2 == 0)
                    mCount.setBackgroundColor(Color.parseColor("#1B24D8"));
                else
                    mCount.setBackgroundColor(Color.parseColor("#04FC18"));
            }
        }
    }
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(countNumber, count);
        super.onSaveInstanceState(savedInstanceState);

    }
    public void zero(View view) {
        count=0;
        Button zero = findViewById(R.id.zero);
        showCount.setText(Integer.toString(count));
        zero.setBackgroundColor(Color.parseColor("#FF00FF"));

    }

    public void count(View view) {
        count++;
        Button zero = findViewById(R.id.zero);

        if (showCount != null)
            showCount.setText(Integer.toString(count));
        if (count % 2 == 0)
            view.setBackgroundColor(Color.parseColor("#1B24D8"));
        else
            view.setBackgroundColor(Color.parseColor("#04FC18"));
        zero.setBackgroundColor(Color.parseColor("#FF00FF"));
    }

    public void toast(View view) {
        Toast toast = Toast.makeText(this, "hellow toast",
                Toast.LENGTH_SHORT);
        toast.show();
    }
}
