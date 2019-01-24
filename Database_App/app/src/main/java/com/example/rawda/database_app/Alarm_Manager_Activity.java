package com.example.rawda.database_app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Alarm_Manager_Activity extends AppCompatActivity implements View.OnClickListener{
    private Button startAlarm;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager_);
        startAlarm = findViewById(R.id.button);
        editText = findViewById(R.id.edit_text);
        startAlarm.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int i = Integer.parseInt(editText.getText().toString());
        Intent intent = new Intent(this, MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,  234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + i * 1000, pendingIntent);
        Toast.makeText(this, "Alarm is set in " + i + " seconds", Toast.LENGTH_LONG).show();
    }
}
