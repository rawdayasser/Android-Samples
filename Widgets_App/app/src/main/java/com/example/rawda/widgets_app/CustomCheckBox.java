package com.example.rawda.widgets_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class CustomCheckBox extends AppCompatActivity implements View.OnClickListener{
    private Button submit;
    private CheckBox checkBox1, checkBox2, checkBox3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_check_box);
        submit = findViewById(R.id.submit_button);
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);

        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        StringBuilder message = new StringBuilder("");
        if (checkBox1.isChecked())
            message.append("CheckBox 1 checked\n");
        if (checkBox2.isChecked())
            message.append("CheckBox 2 checked\n");
        if (checkBox3.isChecked())
            message.append("CheckBox 3 checked");
        if (message.toString().equals("")||message.equals(null))message.append(R.string.nothing_selected);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}

