package com.example.rawda.database_apps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Services extends AppCompatActivity implements View.OnClickListener {
    private Button startService;
    private Button stopService;
    private Button nextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        startService = findViewById(R.id.start_service);
        stopService = findViewById(R.id.stop_service);
        nextPage = findViewById(R.id.next_page);
        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
        nextPage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        int id = view.getId();
        switch (id){
            case R.id.start_service:
                intent = new Intent(this, MyService.class);
                startService(intent);
                break;
            case R.id.stop_service:
                intent = new Intent(this, MyService.class);
                stopService(intent);
                break;
            case R.id.next_page:
                intent = new Intent(this, NextPage.class);
                startActivity(intent);
                break;

        }
    }
}
