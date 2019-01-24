package com.example.rawda.activityandintents_app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private MyMainAdapter adapter;
    private ArrayList<Class> buttons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttons = new ArrayList<>();
        initializeButtons();
        adapter = new MyMainAdapter(this, buttons);
        listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    private void initializeButtons(){
        buttons.add(ActivityLifeCycle.class);
        buttons.add(Implicit_Intent.class);
        buttons.add(FirstActivity.class);
        buttons.add(Share_App_Data_Activity.class);
        buttons.add(Fragment_Activity.class);
    }
}
