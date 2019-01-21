package com.example.rawda.widgets_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class DatePickerActivity extends AppCompatActivity implements View.OnClickListener{
    private DatePicker datePicker;
    private TextView currentDate_textView;
    private Button changeDate_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        datePicker = findViewById(R.id.date_picker);
        currentDate_textView = findViewById(R.id.current_date_text_view);
        changeDate_button = findViewById(R.id.change_date_button);

        currentDate_textView.setText("Date " +getCurrentDate());
        changeDate_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        currentDate_textView.setText("Date " + getCurrentDate());
    }

    private String getCurrentDate() {
        StringBuilder date = new StringBuilder("");
        date.append((datePicker.getMonth() + 1 )+ "/").
                append(datePicker.getDayOfMonth() + "/").append(datePicker.getYear() + "/");

        return date.toString();
    }

}
