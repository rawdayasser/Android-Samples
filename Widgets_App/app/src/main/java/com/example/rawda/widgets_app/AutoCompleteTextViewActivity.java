package com.example.rawda.widgets_app;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoCompleteTextViewActivity extends AppCompatActivity {
    private AutoCompleteTextView completeTextView;
    private String[] programmingLanguages = {"Java", "PHP", "Kotlin", "Javascript", "C++", "C#", "C", "Python"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);
        completeTextView = findViewById(R.id.autocompletetextview);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.select_dialog_item, programmingLanguages);
        completeTextView.setThreshold(1);
        completeTextView.setAdapter(arrayAdapter);
        completeTextView.setTextColor(Color.GREEN);
    }
}
