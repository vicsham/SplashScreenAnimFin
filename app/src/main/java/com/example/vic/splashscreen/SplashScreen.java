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
import android.widget.TextView;

public class SplashScreen extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        /*
        final TextView textView=(TextView) findViewById(R.id.textView);
        textView.setTextColor(Color.RED);
        textView.setTextSize((float) 20.00);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setVisibility(View.INVISIBLE);
            }
        },1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setVisibility(View.VISIBLE);
            }
        },2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setVisibility(View.INVISIBLE);
            }
        },3000);

        */
        showTfno();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(SplashScreen.this,SplashScreen2.class);
                startActivity(intent);



               // textView.setVisibility(View.VISIBLE);

            }
        },12000);
    }

    void showTfno(){
        ImageView nuestroTfno = (ImageView) findViewById(R.id.iVtfno);
        ImageView part945 = (ImageView) findViewById(R.id.iV945);
        part945.setVisibility(View.INVISIBLE);
        ImageView part24 = (ImageView) findViewById(R.id.iV24);
        part24.setVisibility(View.INVISIBLE);
        ImageView part53 = (ImageView) findViewById(R.id.iV53);
        part53.setVisibility(View.INVISIBLE);
        ImageView part12 = (ImageView) findViewById(R.id.iV12);
        part12.setVisibility(View.INVISIBLE);
        Animation movenuestro = AnimationUtils.loadAnimation(this, R.anim.movetfno);
        Animation move945 = AnimationUtils.loadAnimation(this, R.anim.move945);
        Animation move24 = AnimationUtils.loadAnimation(this, R.anim.move24);
        Animation move53 = AnimationUtils.loadAnimation(this, R.anim.move53);
        Animation move12 = AnimationUtils.loadAnimation(this, R.anim.move12);

        TextView textPref =(TextView)findViewById(R.id.textPref);
        textPref.setVisibility(View.INVISIBLE);
        TextView textOne =(TextView)findViewById(R.id.textOne);
        textOne.setVisibility(View.INVISIBLE);
        TextView textTwo =(TextView)findViewById(R.id.textTwo);
        textTwo.setVisibility(View.INVISIBLE);
        TextView textThree =(TextView)findViewById(R.id.textThree);
        textThree.setVisibility(View.INVISIBLE);

        nuestroTfno.startAnimation(movenuestro);
        /*
        part945.setVisibility(View.VISIBLE);
        part945.startAnimation(move945);
        part24.setVisibility(View.VISIBLE);
        part24.startAnimation(move24);
        part53.setVisibility(View.VISIBLE);
         part53.startAnimation(move53);
        part12.setVisibility(View.VISIBLE);
        part12.startAnimation(move12);
        */

        textPref.setVisibility(View.INVISIBLE);
        textPref.setShadowLayer(5, 5, 5, Color.BLUE);
        textPref.startAnimation(move945);
        textOne.setVisibility(View.INVISIBLE);
        textOne.setShadowLayer(5, 5, 5, Color.BLUE);
        textOne.startAnimation(move24);
        textTwo.setVisibility(View.INVISIBLE);
        textTwo.startAnimation(move53);
        textTwo.setShadowLayer(5, 5, 5, Color.BLUE);
        textThree.setVisibility(View.INVISIBLE);
        textThree.startAnimation(move12);
        textThree.setShadowLayer(5,5,5, Color.BLUE);

    }
}
