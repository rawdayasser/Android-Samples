package com.example.rawda.database_apps;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Preferences extends AppCompatActivity implements View.OnClickListener {
    private Button showInfo;
    private Button storeInfo;
    private TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        showInfo = findViewById(R.id.show_info);
        storeInfo = findViewById(R.id.store_info);
        data = findViewById(R.id.data);
        showInfo.setOnClickListener(this);
        storeInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.store_info:
                Intent intent = new Intent(this, PrefActivity.class);
                startActivity(intent);
                break;
            case R.id.show_info:
                showData();
                break;
        }
    }

    private void showData() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        StringBuilder message = new StringBuilder();
        String username = sharedPreferences.getString("username", "Default Username");
        String password = sharedPreferences.getString("password", "Default Password");
        boolean checkbox = sharedPreferences.getBoolean("keep_me_login ", false);
        message.append("\nusername "  + username).append("\nPassword " + password).append("\nkeep me log in" + checkbox);
        data.setText(message);
    }
}
