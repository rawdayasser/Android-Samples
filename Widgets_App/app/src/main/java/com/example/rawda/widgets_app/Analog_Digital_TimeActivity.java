package com.example.rawda.widgets_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AnalogClock;
import android.widget.DigitalClock;

public class Analog_Digital_TimeActivity extends AppCompatActivity {
    private DigitalClock digitalClock;
    private AnalogClock analogClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analog__digital__time);
        /**
         * Not Required Here...
         */
        digitalClock = findViewById(R.id.digital_clock);
        analogClock = findViewById(R.id.analog_clock);
    }
}
