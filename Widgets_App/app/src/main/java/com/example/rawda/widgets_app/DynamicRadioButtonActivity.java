package com.example.rawda.widgets_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class DynamicRadioButtonActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    private RelativeLayout relativeLayout;
    private RadioGroup radioGroup;
    private RadioButton radioButton1, radioButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_radio_button);
        radioButton1 = new RadioButton(this);
        radioButton2 = new RadioButton(this);
        radioButton1.setText("Male");
        radioButton2.setText("Female");
        radioButton1.setPadding(3, 3, 3, 3);
        radioButton2.setPadding(3, 3, 3, 3);
        relativeLayout = findViewById(R.id.relative_layout);
        radioGroup = new RadioGroup(this);
        radioGroup.setOrientation(RadioGroup.HORIZONTAL);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.leftMargin = 100;
        layoutParams.rightMargin = 100;
        layoutParams.topMargin = 100;
        radioGroup.setLayoutParams(layoutParams);
        radioGroup.addView(radioButton1);
        radioGroup.addView(radioButton2);
        relativeLayout.addView(radioGroup);
        radioGroup.setOnCheckedChangeListener(this);

    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        RadioButton radioButton = findViewById(i);
        Toast.makeText(this, radioButton.getText(), Toast.LENGTH_LONG).show();
    }
}

