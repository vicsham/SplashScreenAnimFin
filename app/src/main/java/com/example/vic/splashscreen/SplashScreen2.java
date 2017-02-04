package com.example.vic.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

public class SplashScreen2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);

        TextClock clock=(TextClock) findViewById(R.id.textClock);

        //  clock.setFormat24Hour();
        //  clock.setTextColor(Color.RED);
        // clock.setTextSize(200);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(SplashScreen2.this,SplashScreen3.class);
                startActivity(intent);


            }
        },10000);
    }


}
