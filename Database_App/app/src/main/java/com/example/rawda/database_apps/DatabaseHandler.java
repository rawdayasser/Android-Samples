package com.example.rawda.database_apps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "my_sqlite_database";
    private static final String TABLE_NAME = "contacts";
    private static final String ID_COLUMMN = "id";
    private static final String NAME_COLUMN = "name";
    private static final String PHONE_NUMBER_COLUMN = "phone_number";

    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseHandler(@Nullable Context context, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, errorHandler);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_contact = "create table " + TABLE_NAME + " (" + ID_COLUMMN + " integer primary key, "
                + NAME_COLUMN + " text, " + PHONE_NUMBER_COLUMN + " text);";
        sqLiteDatabase.execSQL(create_contact);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public String getDatabaseName() {
        return DATABASE_NAME;
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
    }

    public void addContact(Contact contact) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID_COLUMMN, contact.get_id());
        values.put(NAME_COLUMN, contact.get_name());
        values.put(PHONE_NUMBER_COLUMN, contact.get_phoneNumber());
        database.insert(TABLE_NAME, null, values);
        database.close();
    }

    public void deleteContact(Contact contact) {
        getWritableDatabase().delete(DATABASE_NAME, ID_COLUMMN + " =?", new String[]{contact.get_id() + ""});

    }

    public void updateContact(Contact contact) {
        ContentValues values = new ContentValues();
        values.put(ID_COLUMMN, contact.get_id());
        values.put(NAME_COLUMN, contact.get_name());
        values.put(PHONE_NUMBER_COLUMN, contact.get_phoneNumber());
        getWritableDatabase().update(TABLE_NAME, values, ID_COLUMMN + " =?", new String[]{contact.get_id() + ""});
    }

    public ArrayList<Contact> selectAllContacts() {
        ArrayList<Contact> contacts = new ArrayList<>();
        Cursor cursor = getWritableDatabase().rawQuery("select * from " + TABLE_NAME, null);
        if (cursor.moveToNext()) {
            do {
                Contact contact = new Contact();
                contact.set_id(Integer.parseInt(cursor.getString(0)));
                contact.set_name(cursor.getString(1));
                contact.set_phoneNumber(cursor.getString(2));
                contacts.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return contacts;
    }

    public Contact selectContact(int id) {
        String query = "select * from " + TABLE_NAME + " where " + ID_COLUMMN + " = " + id;
        Cursor cursor = getWritableDatabase().rawQuery(query, null);
        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));
        return contact;
    }

    public int getContactNumber() {
        Cursor cursor = getWritableDatabase().rawQuery("select * from " + TABLE_NAME, null);
        cursor.close();
        return cursor.getCount();
    }
}
