package com.example.rawda.javatpoint1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LandScapeActivity extends AppCompatActivity implements View.OnClickListener{
    private Button portraitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_scape);
        portraitBtn = findViewById(R.id.portrait);
        portraitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        int id = view.getId();
        Log.d("id1", id + "");
        if (id == R.id.portrait){
            intent = new Intent(LandScapeActivity.this, PortraitActivity.class);
            startActivity(intent);
        }
    }
}
