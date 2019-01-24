package com.example.rawda.database_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private MediaPlayer mediaPlayer;
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        mediaPlayer = MediaPlayer.create(context, R.raw.song);
        mediaPlayer.start();
        Toast.makeText(context, "Alarm started...", Toast.LENGTH_LONG).show();
    }

}
