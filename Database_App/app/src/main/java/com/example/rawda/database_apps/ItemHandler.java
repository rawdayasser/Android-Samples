package com.example.rawda.database_apps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class ItemHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "items";
    private static final int DATABASE_VERSION = 1;
    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "name";
    private static final String TABLE_NAME = "items";

    public ItemHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + "( "+ID_COLUMN + " integer primary key, "
                + NAME_COLUMN + " text);");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addItem(String item) {
        ContentValues values = new ContentValues();
        values.put(NAME_COLUMN, item);
        this.getWritableDatabase().insert(TABLE_NAME, null, values);
        this.close();
    }

    public ArrayList<String> getAllItems() {
        ArrayList<String> item_names = new ArrayList<>();
        Cursor cursor = this.getReadableDatabase().rawQuery("select * from " + TABLE_NAME, null);
        if (cursor.moveToNext()) {
            do {
                item_names.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return item_names;
    }
}
