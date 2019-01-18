package com.example.rawda.widgets_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity implements View.OnClickListener {
    private Button add_Button;
    private EditText number1_EditText;
    private EditText number2_EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        add_Button = findViewById(R.id.add_button);
        number1_EditText = findViewById(R.id.number1_editText);
        number2_EditText = findViewById(R.id.number2_editText);
        add_Button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.add_button){
            Toast toast = Toast.makeText(this,  (Integer.parseInt(number1_EditText.getText().toString()) +
                    Integer.parseInt(number2_EditText.getText().toString())) + "", Toast.LENGTH_LONG);
           // toast.setMargin(50, 50);
            toast.show();
        }
    }
}
