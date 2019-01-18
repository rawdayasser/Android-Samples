package com.example.rawda.widgets_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity implements View.OnClickListener {
    private CheckBox coffee, tea, hotChocolate;
    private Button order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        coffee = findViewById(R.id.coffee_check_box);
        tea = findViewById(R.id.tea_check_box);
        order = findViewById(R.id.order_button);

        order.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int total = 0;
        StringBuilder message = new StringBuilder();
        if (tea.isChecked()) {
            message.append("\nTea ").append("7");
            total += 7;
        }
        if (coffee.isChecked()) {
            message.append("\nCoffee ").append("10");
            total += 10;
        }
        if (coffee.isChecked()) {
            message.append("\nHot chocolate ").append("12");
            total += 12;
        }
        message.append("\ntotal ").append(total);

        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }
}
