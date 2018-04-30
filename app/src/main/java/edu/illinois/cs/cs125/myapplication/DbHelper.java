package edu.illinois.cs.cs125.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "TodoDB";
    public static final String TABLE = "ItemsTodo";
    public static final String COLUMN = "Items";
    private static final int VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = String.format("CREATE TABLE %s (ID INTEGER PRIMATY KEY AUTOINCREMENT, %s TEXT NOT NULL);", TABLE, COLUMN);
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = String.format("DELETE TABLE IF EXISTS %s", TABLE);
        db.execSQL(query);
        onCreate(db);
    }

    public void insertNewItem(String item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN, item);
        db.insertWithOnConflict(TABLE, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }

    public void deleteItem(String item) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE, COLUMN + " = ?", new String[]{item});
        db.close();
    }

    public ArrayList<String> getTodoList() {
        ArrayList<String> todoList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query(TABLE, new String[]{COLUMN}, null, null, null, null, null);
        while (c.moveToNext()) {
            int index = c.getColumnIndex(COLUMN);
            todoList.add(c.getString(index));
        }
        c.close();
        db.close();
        return todoList;
    }







}