
package com.example.rawda.widgets_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioGroup radioGroup;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        radioGroup = findViewById(R.id.radio_group);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = radioGroup.getCheckedRadioButtonId();
        StringBuilder message = new StringBuilder("");
        RadioButton  radioButton;
        if (id != -1) {
            radioButton = findViewById(id);
            message.append(radioButton.getText());
        }
        else {
            message.append("Nothing Selected");
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
