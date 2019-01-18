package com.example.rawda.widgets_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CustomRadioButton extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_radio_button);
        radioGroup = findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        RadioButton radioButton = findViewById(i);
        Toast.makeText(this, radioButton.getText() + " is Checked", Toast.LENGTH_LONG).show();
    }
}
