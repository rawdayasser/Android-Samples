package com.example.rawda.widgets_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

public class SeekBarActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    private SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);
        seekBar = findViewById(R.id.seek_bar);
        seekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        showToast("progress = " + i);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        showToast("Seek bar Touch Started...");
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        showToast("Seek bar Touch stopped!");
    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
