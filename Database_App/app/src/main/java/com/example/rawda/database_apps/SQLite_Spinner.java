package com.example.rawda.database_apps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SQLite_Spinner extends AppCompatActivity implements View.OnClickListener {
    private Button addBtn;
    private EditText addEditText;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_spinner);
        addBtn = findViewById(R.id.add_button);
        addEditText = findViewById(R.id.add_edit_text);
        spinner = findViewById(R.id.spinner);
        loadSpinnerData();
        addBtn.setOnClickListener(this);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapterView.getContext(), "You selected" + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.add_button) {
            ItemHandler handler = new ItemHandler(this);
            handler.addItem(addEditText.getText().toString());
            loadSpinnerData();
        }
    }

    private void loadSpinnerData() {
        ArrayList<String> labels = new ItemHandler(this).getAllItems();
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, labels);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
