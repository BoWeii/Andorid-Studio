package com.example.a106590021_hw4_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public EditText WET,LET,STET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void shareText(View view) {
        STET=(EditText)findViewById(R.id.share_edittext);
        String txt=STET.getText().toString();
        String mimeType="text/plain";
        ShareCompat.IntentBuilder
                            .from(this)
                            .setType(mimeType)
                            .setChooserTitle("share this text with:")
                            .setText(txt)
                            .startChooser();
    }


    public void openLocation(View view) {
        LET=(EditText)findViewById(R.id.location_edittext);
        String loc=LET.getText().toString();
        Uri addressUri=Uri.parse("geo:0"+loc);
        Intent intent=new Intent(Intent.ACTION_VIEW,addressUri);
        if(intent.resolveActivity(getPackageManager())!=null)
        {
            startActivity(intent);
        }
        else
        {
            Log.d("ImplicitIntents","Can't handle this intent!");
        }
    }

    public void openWebsite(View view) {
        WET=(EditText)findViewById(R.id.website_edittext);
        String url=WET.getText().toString();
        Uri webpage=Uri.parse(url);
        Intent intent=new Intent(Intent.ACTION_VIEW,webpage);
        if(intent.resolveActivity(getPackageManager())!=null)
        {
            startActivity(intent);
        }
        else
        {
            Log.d("ImpliciIntents","Can't handle this intent!");
        }
    }

    public void photo(View view) {
    Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
    if(intent.resolveActivity(getPackageManager())!=null)
    {
        startActivity(intent);
    }
    }
}
