package com.example.rawda.widgets_app;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ImageSliderActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private int[] images = new int[]{R.drawable.youtube, R.drawable.twitter, R.drawable.google_plus, R.drawable.ic_launcher_background};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_slider);
        viewPager = findViewById(R.id.view_pager);
        ImageAdapter adapter = new ImageAdapter(images, this);
        viewPager.setAdapter(adapter);
    }
}
