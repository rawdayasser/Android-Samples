package com.example.rawda.widgets_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomToastActivity extends AppCompatActivity implements View.OnClickListener{
    private Button showButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_toast);
        showButton = findViewById(R.id.show_custom_button);
        showButton.setOnClickListener(this);

    }

    public void showToast(String message){

        View mLayout = getLayoutInflater().inflate(R.layout.activity_custom_toast,null);
        Log.d(getClass().getName(), "before image reset");
        ImageView image = mLayout.findViewById(R.id.toast_image);
        //image.setImageResource(R.drawable.ic_launcher_background);
        TextView text = mLayout.findViewById(R.id.toast_text_view);
        text.setText(message);
        Toast toast = new Toast(getApplicationContext());
        Log.d(getClass().getName(), "before toast duration");
        toast.setDuration(Toast.LENGTH_SHORT);
        Log.d(getClass().getName(), "before gravity");
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setView(mLayout);
        Log.d(getClass().getName(), "before toast.show()");
        toast.show();
        Log.d(getClass().getName(), "before end");
    }

    @Override
    public void onClick(View view) {
        showToast("Custom Toast");
    }
}
