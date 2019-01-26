package com.example.rawda.database_apps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Class> classes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);
        initialize_classes();
        final MainAdapter adapter = new MainAdapter(this, classes);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initialize_classes() {
        classes = new ArrayList<>();
        classes.add(Services.class);
        classes.add(Alarm_Manager_Activity.class);
        classes.add(Preferences.class);
        classes.add(Internal_Storage.class);
        classes.add(External_Storage.class);
        classes.add(SQLite_Activity.class);
        classes.add(SQLite_Spinner.class);
    }
}
