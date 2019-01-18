package com.example.rawda.widgets_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ToggleButtonActivity extends AppCompatActivity implements View.OnClickListener {
    private ToggleButton toggle1, toggle2;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);
        toggle1 = findViewById(R.id.toggle_button1);
        toggle2 = findViewById(R.id.toggle_button2);
        submit = findViewById(R.id.toggle_submit_button);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        StringBuilder message = new StringBuilder();
        message.append("Toggle Button 1: ").append(toggle1.getText());
        message.append("\nToggle Button 2: ").append(toggle2.getText());
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
