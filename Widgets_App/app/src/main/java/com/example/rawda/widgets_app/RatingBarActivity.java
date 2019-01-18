package com.example.rawda.widgets_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingBarActivity extends AppCompatActivity implements View.OnClickListener{
    private RatingBar ratingBar;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);
        ratingBar = findViewById(R.id.rating_bar);
        submit = findViewById(R.id.button);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Rating " + ratingBar.getRating(), Toast.LENGTH_LONG).show();
    }
}
