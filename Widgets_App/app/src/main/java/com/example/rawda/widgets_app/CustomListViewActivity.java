package com.example.rawda.widgets_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CustomListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private MyListAdapter adapter;
    private int[] images = {R.drawable.google_plus, R.drawable.youtube, R.drawable.twitter};
    private String[] titles = {"Title1", "Title12", "Title3"};
    private String[] subtitles = {"subtitle1", "subtitle2", "subtitle3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        listView = findViewById(R.id.listview);
        adapter = new MyListAdapter(this, images, titles, subtitles);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "You Entered row # " + i, Toast.LENGTH_SHORT).show();
    }
}

