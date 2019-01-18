package com.example.rawda.widgets_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button addButton;
    private Button customToastButton;
    private Button toggleButton;
    private Button switchButton;
    private Button checkboxButton;
    private Button customCheckboxButton;
    private Button radioButton;
    private Button dynamicRadioButton;
    private Button customRadioButton;
    private Button alertDialogButton;
    private Button spannerButton;
    private Button autoCompleteTextViewButton;
    private Button listViewButton;
    private Button customListViewButton;
    private Button ratingBarButton;
    private Button webViewButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = findViewById(R.id.buttons_go);
        customToastButton = findViewById(R.id.custom_toast_go);
        toggleButton = findViewById(R.id.toggle_button_go);
        switchButton = findViewById(R.id.switch_button_go);
        checkboxButton = findViewById(R.id.checkbox_button_go);
        customCheckboxButton = findViewById(R.id.custom_checkbox_button_go);
        radioButton = findViewById(R.id.radio_button_go);
        dynamicRadioButton = findViewById(R.id.dynamic_radio_button_go);
        customRadioButton = findViewById(R.id.custom_radio_button_go);
        alertDialogButton = findViewById(R.id.alert_dialog_go);
        spannerButton = findViewById(R.id.spinner_go);
        autoCompleteTextViewButton = findViewById(R.id.autocompletetextview_go);
        listViewButton = findViewById(R.id.listview_go);
        customListViewButton = findViewById(R.id.custom_listview_go);
        ratingBarButton = findViewById(R.id.rating_bar_go);
        webViewButton = findViewById(R.id.web_view_go);

        addButton.setOnClickListener(this);
        customToastButton.setOnClickListener(this);
        toggleButton.setOnClickListener(this);
        switchButton.setOnClickListener(this);
        checkboxButton.setOnClickListener(this);
        customCheckboxButton.setOnClickListener(this);
        radioButton.setOnClickListener(this);
        dynamicRadioButton.setOnClickListener(this);
        customRadioButton.setOnClickListener(this);
        alertDialogButton.setOnClickListener(this);
        spannerButton.setOnClickListener(this);
        autoCompleteTextViewButton.setOnClickListener(this);
        listViewButton.setOnClickListener(this);
        customListViewButton.setOnClickListener(this);
        ratingBarButton.setOnClickListener(this);
        webViewButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        int id = view.getId();

        switch (id){
            case R.id.buttons_go:
                intent = new Intent(this, ButtonActivity.class);
                startActivity(intent);
                break;
            case R.id.custom_toast_go:
                intent = new Intent(this, CustomToastActivity.class);
                startActivity(intent);
                break;
            case R.id.toggle_button_go:
                intent = new Intent(this, ToggleButtonActivity.class);
                startActivity(intent);
                break;
            case R.id.switch_button_go:
                intent = new Intent(this, SwitchActivity.class);
                startActivity(intent);
                break;
            case R.id.checkbox_button_go:
                intent = new Intent(this, CheckBoxActivity.class);
                startActivity(intent);
                break;
            case R.id.custom_checkbox_button_go:
                intent = new Intent(this, CustomCheckBox.class);
                startActivity(intent);
                break;
            case R.id.radio_button_go:
                intent = new Intent(this, RadioButtonActivity.class);
                startActivity(intent);
                break;
            case R.id.dynamic_radio_button_go:
                intent = new Intent(this, DynamicRadioButtonActivity.class);
                startActivity(intent);
                break;
            case R.id.custom_radio_button_go:
                intent = new Intent(this, CustomRadioButton.class);
                startActivity(intent);
                break;
            case R.id.alert_dialog_go:
                intent = new Intent(this, AlertDialogActivity.class);
                startActivity(intent);
                break;
            case R.id.spinner_go:
                intent = new Intent(this, SpinnerActivity.class);
                startActivity(intent);
                break;
            case R.id.autocompletetextview_go:
                intent = new Intent(this, AutoCompleteTextViewActivity.class);
                startActivity(intent);
                break;
            case R.id.listview_go:
                intent = new Intent(this, ListViewActivity.class);
                startActivity(intent);
                break;
            case R.id.custom_listview_go:
                intent = new Intent(this, CustomListViewActivity.class);
                startActivity(intent);
                break;
            case R.id.rating_bar_go:
                intent = new Intent(this, RatingBarActivity.class);
                startActivity(intent);
                break;
            case R.id.web_view_go:
                intent = new Intent(this, WebViewActivity.class);
                startActivity(intent);
                break;


        }
    }
}
