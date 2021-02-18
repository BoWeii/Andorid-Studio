package com.example.a106590021_hw7_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void donut(View view) {
        Intent intent1=new Intent(this,Activity1.class);
        startActivity(intent1);
    }

    public void froyo(View view) {
        Intent intent2=new Intent(this,Activity2.class);
        startActivity(intent2);
    }

    public void icecream(View view) {
        Intent intent3=new Intent(this,Activity3.class);
        startActivity(intent3);
    }
}
