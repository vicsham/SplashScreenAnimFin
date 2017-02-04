package com.example.vic.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.widget.Toast;




import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class SplashScreen3 extends Activity  implements
        BaseSliderView.OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener{
    private SliderLayout imageSlider;
    private int numImages1=0;
    private int numImages2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen3);








        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(SplashScreen3.this,SplashScreen.class);
                startActivity(intent);


            }
        },36200);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                sliderShow();

            }
        },1);


    }

    void sliderShow(){

        imageSlider = (SliderLayout)findViewById(R.id.slider); // initialize the id of SliderLayout



// creating HashMap
        HashMap<String, String> image_maps = new HashMap<String, String>();
        image_maps.put("Hannibal",
                "http://gasteiz-tronic.com/index_htm_files/1502@2x.jpg");
        image_maps.put("Big Bang Theory",
                "http://gasteiz-tronic.com/index_htm_files/1868@2x.jpg");
        image_maps.put("House of Cards",
                "http://gasteiz-tronic.com/index_htm_files/1866@2x.jpg");
        image_maps.put("Game of Thrones",
                "http://gasteiz-tronic.com/index_htm_files/1897.jpg");

        image_maps.put("Game of Thrones",
                "http://gasteiz-tronic.com/index_htm_files/1706.jpg");

        for (String name : image_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            numImages1=image_maps.size();
            textSliderView
                    .description(name)
                    .image(image_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra",name);

            imageSlider.addSlider(textSliderView);


        }

// OR

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
      /*
        file_maps.put("Рисунок1", R.drawable.cat1);
        file_maps.put("Рисунок2", R.drawable.cat2);
        file_maps.put("Рисунок3", R.drawable.cat3);
        file_maps.put("Рисунок4", R.drawable.cat_bottom);
        file_maps.put("Рисунок5", R.drawable.cat_hungry);
*/
        file_maps.put("Рисунок1", R.drawable.owl1);
        file_maps.put("Рисунок2", R.drawable.owl2);
        file_maps.put("Рисунок3", R.drawable.owl3);
        file_maps.put("Рисунок4", R.drawable.owl4);
        file_maps.put("Рисунок5", R.drawable.owl5);



        for (String name : file_maps.keySet()) {
            // TextSliderView textSliderView = new TextSliderView(this);
            DefaultSliderView textSliderView= new DefaultSliderView(this);
            numImages2=numImages1+file_maps.size();
            String num="Total "+numImages2;
            // initialize a SliderLayout
            textSliderView
                    .description(num)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);


            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra",name);

            imageSlider.addSlider(textSliderView);


        }

        imageSlider.setPresetTransformer(SliderLayout.Transformer.FlipHorizontal); //zdes smena typa animacii
        imageSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);// napravlenie animacii
        imageSlider.setCustomAnimation(new DescriptionAnimation());
        imageSlider.setDuration(4000);                      //vremya vsego cycla
        imageSlider.addOnPageChangeListener(this);



    }

    @Override
    protected void onStop() {
// To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider
// before activity or fragment is destroyed
        imageSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {

        if (position==numImages2-1){  //ostanovka po kontsu slidera

            imageSlider.stopAutoCycle();
            //       imageSlider.removeAllSliders();
            numImages2=0;
        }
        Log.e("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}


}
