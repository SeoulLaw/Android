package com.example.dkdk6.seoullaw;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tsengvn.typekit.Typekit;

public class Loading_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent loginintent = new Intent(Loading_Activity.this, Login_Activity.class);
                startActivity(loginintent);
                finish();
            }
        }, 2000);
        Typekit.getInstance()
                .addNormal(Typekit.createFromAsset(this, "fonts/middle.ttf"))
                .addBold(Typekit.createFromAsset(this, "fonts/middle.ttf"));
    }
}
