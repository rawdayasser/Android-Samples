package com.example.rawda.widgets_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class SwitchActivity extends AppCompatActivity implements View.OnClickListener {
    private Switch switch1, switch2;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        switch1 = findViewById(R.id.switch1);
        switch2 = findViewById(R.id.switch2);
        submit = findViewById(R.id.switch_submit_button);

        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        boolean checked1 = switch1.isChecked();
        boolean checked2 = switch2.isChecked();
        String chk1 = (checked1?"on":"off");
        String chk2 = (checked2?"on": "off");

        StringBuilder message = new StringBuilder();
        message.append("Switch 1: ").append(chk1)
                .append("\nSwitch 2: ").append(chk2);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}


