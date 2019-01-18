package com.example.rawda.javatpoint1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PortraitActivity extends AppCompatActivity implements View.OnClickListener{
    private Button landscapeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portrait);
        landscapeBtn = findViewById(R.id.go_to_landscape);
        landscapeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.go_to_landscape){
            Intent i = new Intent(this, LandScapeActivity.class);
            startActivity(i);
        }
    }
}
