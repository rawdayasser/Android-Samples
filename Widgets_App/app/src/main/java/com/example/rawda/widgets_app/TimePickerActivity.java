package com.example.rawda.widgets_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class TimePickerActivity extends AppCompatActivity implements View.OnClickListener{
    private TimePicker timePicker;
    private TextView currentTime;
    private Button changeTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        timePicker = findViewById(R.id.time_picker);
        currentTime = findViewById(R.id.current_time);
        changeTime = findViewById(R.id.change_time);
        currentTime.setText(getCurrentTime());
        changeTime.setOnClickListener(this);
    }

    private String getCurrentTime() {
        StringBuilder builder = new StringBuilder("");
        builder.append(timePicker.getCurrentHour() + ":").append(timePicker.getCurrentMinute());
        return builder.toString();
    }

    @Override
    public void onClick(View view) {
        currentTime.setText(getCurrentTime());
    }
}
