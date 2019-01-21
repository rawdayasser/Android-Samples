package com.example.rawda.widgets_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private ListView listView;
    private ArrayList<String> buttonText;
    private ArrayList<Class> activity;
    //private SearchView searchView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.main_list_view);
        //searchView = findViewById(R.id.search_view);
        editText = findViewById(R.id.main_edit_text);
        activity = new ArrayList<>();
        buttonText = new ArrayList<>();
        loadActivity();
        loadButtonText();
        final MainArrayAdapter adapter = new MainArrayAdapter(this, buttonText, activity);
       // final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, buttonText);
        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(true);
        //searchView.setIconifiedByDefault(false);
        //searchView.setSubmitButtonEnabled(true);
        adapter.notifyDataSetChanged();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
           //     Toast.makeText(getApplicationContext(), "before Text Changed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
              //  adapter.getFilter().filter(editable);
               // Toast.makeText(getApplicationContext(), "After Text Changed", Toast.LENGTH_SHORT).show();
            }
        });
       /* searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                //   adapter.afterFilter();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });*/
    }
    private void loadButtonText(){
        for (int i = 0; i < activity.size(); i++) {
            buttonText.add(activity.get(i).getSimpleName());
            Log.d(MainActivity.class.getSimpleName(), activity.get(i).getSimpleName());
        }
    }
    private void loadActivity(){
        activity.add(AlertDialogActivity.class);
        activity.add(Analog_Digital_TimeActivity.class);
        activity.add(AutoCompleteTextViewActivity.class);
        activity.add(ButtonActivity.class);
        activity.add(CheckBoxActivity.class);
        activity.add(CustomCheckBoxActivity.class);
        activity.add(CustomListViewActivity.class);
        activity.add(CustomRadioButton.class);
        activity.add(CustomToastActivity.class);
        activity.add(DatePickerActivity.class);
        activity.add(AlertDialogActivity.class);
        activity.add(DynamicRadioButtonActivity.class);
        activity.add(CustomToastActivity.class);
        activity.add(DatePickerActivity.class);
        activity.add(HorizontalScrollViewActivity.class);
        activity.add(ImageSwitcherActivity.class);
        activity.add(ImageSliderActivity.class);
        activity.add(ListViewActivity.class);
        activity.add(ProgressBarActivity.class);
        activity.add(RadioButtonActivity.class);
        activity.add(RatingBarActivity.class);
        activity.add(SeekBarActivity.class);
        activity.add(SpinnerActivity.class);
        activity.add(SwitchActivity.class);
        activity.add(TabLayout1_Activity.class);
        activity.add(TimePickerActivity.class);
        activity.add(ToggleButtonActivity.class);
        activity.add(ViewStubActivity.class);
        activity.add(WebViewActivity.class);
        activity.add(TabLayout1_Activity.class);
        activity.add(TabLayout2_Activity.class);
    }
}

/*
        buttonText.add(AlertDialogActivity.class.getSimpleName());
        buttonText.add(Analog_Digital_TimeActivity.class.getSimpleName());
        buttonText.add(AutoCompleteTextViewActivity.class.getSimpleName());
        buttonText.add(ButtonActivity.class.getSimpleName());
        buttonText.add(CheckBoxActivity.class.getSimpleName());
        buttonText.add(CustomCheckBoxActivity.class.getSimpleName());
        buttonText.add(CustomListViewActivity.class.getSimpleName());
        buttonText.add(CustomRadioButton.class.getSimpleName());
        buttonText.add(CustomToastActivity.class.getSimpleName());
        buttonText.add(DatePickerActivity.class.getSimpleName());
        buttonText.add(AlertDialogActivity.class.getSimpleName());
        buttonText.add(DynamicRadioButtonActivity.class.getSimpleName());
        buttonText.add(CustomToastActivity.class.getSimpleName());
        buttonText.add(DatePickerActivity.class.getSimpleName());
        buttonText.add(HorizontalScrollViewActivity.class.getSimpleName());
        buttonText.add(ImageSwitcherActivity.class.getSimpleName());
        buttonText.add(ImageSliderActivity.class.getSimpleName());
        buttonText.add(ListViewActivity.class.getSimpleName());
        buttonText.add(ProgressBarActivity.class.getSimpleName());
        buttonText.add(RadioButtonActivity.class.getSimpleName());
        buttonText.add(RatingBarActivity.class.getSimpleName());
        buttonText.add(SeekBarActivity.class.getSimpleName());
        buttonText.add(SpinnerActivity.class.getSimpleName());
        buttonText.add(SwitchActivity.class.getSimpleName());
        buttonText.add(TabLayout1_Activity.class.getSimpleName());
        buttonText.add(TimePickerActivity.class.getSimpleName());
        buttonText.add(ToggleButtonActivity.class.getSimpleName());
        buttonText.add(ViewStubActivity.class.getSimpleName());
        buttonText.add(WebViewActivity.class.getSimpleName());
        */