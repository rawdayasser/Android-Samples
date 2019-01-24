package com.example.rawda.activityandintents_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        String value1 = extras.getString("Value 1");
        String value2 = extras.getString("Value 2");
        showToast("Value 1 " + value1 + "\nValue 2 " + value2);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);
    }
    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
