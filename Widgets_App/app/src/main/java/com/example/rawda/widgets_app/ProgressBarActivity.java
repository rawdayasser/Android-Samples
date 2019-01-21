package com.example.rawda.widgets_app;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProgressBarActivity extends AppCompatActivity implements View.OnClickListener {
    private Button downloadButton;
    private int progressStatus = 0;
    private long fileSize = 0;
    private Handler handler = new Handler();
    private ProgressDialog progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        downloadButton = findViewById(R.id.download_file);
        progressBar = new ProgressDialog(this);
        downloadButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        progressBar_listener();
    }

    private void progressBar_listener() {
        progressStatus = 0;
        fileSize = 0;
        progressBar.setCancelable(true);
        progressBar.setMessage("File downloading ...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressBar.setProgress(progressStatus);
        progressBar.setMax(100);
        progressBar.show();
        progressBar.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                 // caused runtime error
                //cancel_alertDialog();
            }
        });
        while (progressStatus < 100) {
            progressStatus = calc_Status();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressStatus);
                        }
                    });

                    if (progressStatus >= 100) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                progressBar.dismiss();
                            }
                        }).start();
                    }
                }
            }).start();
        }
    }

    private int calc_Status() {
        if (fileSize < 10000) {
            fileSize++;
        }
        if (fileSize == 1000) return 10;
        else if (fileSize == 2000) return 20;
        else if (fileSize == 3000) return 30;
        else if (fileSize == 4000) return 40;
        else if (fileSize == 5000) return 50;
        else if (fileSize == 6000) return 60;

        //if file size = 10000
        return 100;
    }

    //////////////////////////////
    ///////Not Working///////////
    ////////////////////////////

/*
    private void cancel_alertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        builder.setMessage("Do you want to stop file downloading?")
                .setCancelable(false).setPositiveButton("Yes", new AlertDialog.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                progressBar.dismiss();
            }
        }).setNegativeButton("No", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.setTitle("Warning!");
        alertDialog.show();
    }
*/
}
