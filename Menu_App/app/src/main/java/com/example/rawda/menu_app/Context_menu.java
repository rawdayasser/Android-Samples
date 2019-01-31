package com.example.rawda.menu_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class Context_menu extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);
        listView = findViewById(R.id.list_view);
        data = new ArrayList<>();
        loadData();
        final ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
       getMenuInflater().inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Select The Action");
       }



    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(getApplicationContext(), item.getTitle() + "", Toast.LENGTH_SHORT).show();
        /*switch (item.getItemId()){
            case R.id.call:
                Toast.makeText(this, "Call", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sms:
                Toast.makeText(this, "Send SMS", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
*/
        return true;
     }

    private void loadData(){
        data.add("Rawda");
        data.add("Diaa");
        data.add("Omar");
        data.add("Fatima");
    }
}
