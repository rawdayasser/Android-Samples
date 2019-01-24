package com.example.rawda.activityandintents_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Share_App_Data_Activity extends AppCompatActivity implements View.OnClickListener{
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_app_data);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.setType("text/plain");
        String url = "https://play.google.com/store/apps/details?id=my.example.javatpoint";
        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Insert Subject Here...");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, url);
        startActivity(Intent.createChooser(intent, "Share Via"));
    }
}
