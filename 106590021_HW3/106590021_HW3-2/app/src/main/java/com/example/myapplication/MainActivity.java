package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private int count=0;
    TextView show;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show=findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        Intent intent=new Intent(this,secondActivity.class);
        String message=show.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }

    public void countUp(View view) {
        count++;
        if(show!=null)
            show.setText(Integer.toString(count));
    }

}
