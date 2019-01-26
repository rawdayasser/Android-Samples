package com.example.rawda.database_apps;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class SQLite_Activity extends AppCompatActivity {
    private DatabaseHandler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_);
        handler = new DatabaseHandler(this);
        Log.d(SQLite_Activity.class.getSimpleName(), "Inserting ...");
        handler.addContact(new Contact(1, "Rawda", "123455"));
        handler.addContact(new Contact(2, "Omar", "678910"));
        handler.addContact(new Contact(3, "Diaa", "101112"));
        handler.addContact(new Contact(4, "Fatima", "131415"));
        Log.d(SQLite_Activity.class.getSimpleName(), "Reading ...");
        ArrayList<Contact> contacts = handler.selectAllContacts();
        for (Contact c : contacts){
            String log = c.get_id() + " " + c.get_name() + " " + c.get_phoneNumber();
            Log.d(SQLite_Activity.class.getSimpleName() + "select all\n", log);
        }

    }
}
