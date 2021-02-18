package com.example.a106590021_hw6_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox chococlate;
    private CheckBox sprinkles;
    private CheckBox crushed;
    private CheckBox cherries;
    private CheckBox orio;
   // private CheckedTextView all;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chococlate=findViewById(R.id.Chocolate);
        sprinkles=findViewById(R.id.Sprinkles);
        crushed=findViewById(R.id.Crushed);
        cherries=findViewById(R.id.Cherries);
        orio=findViewById(R.id.Orio);
      //  all=findViewById(R.id.checkedTextView);
    }

    public void show(View view) {
        String a="",b="",c="",d="",e="";
        if(chococlate.isChecked())
            a=chococlate.getText().toString();
         if(sprinkles.isChecked())
            b=sprinkles.getText().toString();
         if(crushed.isChecked())
            c=crushed.getText().toString();
        if(cherries.isChecked())
            d=cherries.getText().toString();
         if(orio.isChecked())
            e=orio.getText().toString();

        Toast toast=Toast.makeText(this,"Toppings:"+a+b+c+d+e,Toast.LENGTH_SHORT);
        toast.show();
    }
}
