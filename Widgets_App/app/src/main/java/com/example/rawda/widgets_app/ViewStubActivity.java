package com.example.rawda.widgets_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class ViewStubActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewStub viewStub;
    private Button show, hide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stub);
        viewStub = findViewById(R.id.view_stub);
        show = findViewById(R.id.show);
        hide = findViewById(R.id.hide);
        
        Animation animation = AnimationUtils.makeInAnimation(this, true); // Not working!
        viewStub.setAnimation(animation); // Not working!
        show.setOnClickListener(this);
        hide.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.show){
            viewStub.setVisibility(View.VISIBLE);
        }else if(id == R.id.hide){
            viewStub.setVisibility(View.GONE);
        }
    }
}
