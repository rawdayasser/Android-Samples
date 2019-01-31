package com.example.rawda.menu_app;

import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Class> activities;
    private MyMainAdapter adapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);
        activities = new ArrayList<>();
        initializeActivities();
        adapter = new MyMainAdapter(this, activities);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    private void initializeActivities(){
        activities.add(Options_menu.class);
        activities.add(Context_menu.class);
        activities.add(Popup_menu.class);
        printActivityLog();
    }
    private void printActivityLog(){
        for (Class c : activities){
            Log.d("Activity ", c.getSimpleName());
        }
    }
}
