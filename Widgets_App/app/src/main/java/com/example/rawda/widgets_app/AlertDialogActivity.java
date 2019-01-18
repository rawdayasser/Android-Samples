package com.example.rawda.widgets_app;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        button = findViewById(R.id.close);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.close_app_question).setCancelable(false).setPositiveButton("OK", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               finish();
               Toast.makeText(getApplicationContext(), "You chose OK...",Toast.LENGTH_LONG).show();
            }
        }).setNegativeButton("Cancel", new AlertDialog.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "You chose Cancel...",Toast.LENGTH_LONG).show();

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.setTitle("Alert Dialog Example");
        alertDialog.show();

    }
}
