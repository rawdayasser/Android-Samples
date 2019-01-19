package com.example.rawda.widgets_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class ImageSwitcherActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageSwitcher switcher;
    private Button next;
    private Button prev;
    private int[] images = {R.drawable.google_plus, R.drawable.twitter, R.drawable.youtube};
    private int count = 0;
    private int size = images.length;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher);
        switcher = findViewById(R.id.image_switcher);
        next = findViewById(R.id.next_button);
        prev = findViewById(R.id.prev_button);
        next.setOnClickListener(this);
        prev.setOnClickListener(this);
        // This will create the views for ImageSwitcher to flip
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setImageResource(images[0]);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return imageView;
            }
        });
        Animation animOut = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        Animation animIn = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        switcher.setOutAnimation(animOut);
        switcher.setInAnimation(animIn);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.next_button) {
            count++;
            if (count == size) {
                count = 0;
            }
        }else if (view.getId() == R.id.prev_button){
            count--;
            if (count == -1){
                count = size - 1;
            }
        }
        switcher.setImageResource(images[count]);
    }
}
