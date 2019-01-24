package com.example.rawda.activityandintents_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ActivityLifeCycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        displayToast("onCreate() method");
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayToast("onStart() method");

    }

    @Override
    protected void onResume() {
        super.onResume();
        displayToast("onResume() method");
    }

    @Override
    protected void onPause() {
        super.onPause();
        displayToast("onPause() method");
    }

    @Override
    protected void onStop() {
        super.onStop();
        displayToast("onStop() method");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        displayToast("onDestroy() method");
    }

    private void displayToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
