package com.example.finalproject;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "entries.db";
    private static final String TABLE_NAME = "entrys";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_DAY = "day";
    private static final String COLUMN_TIME = "time";
    private static final String COLUMN_LOCATION = "location";
    private static final String COLUMN_MOOD = "mood";
    private static final String COLUMN_THOUGHTS = "thoughts";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DAY + " TEXT, " +
                COLUMN_TIME + " TEXT, " +
                COLUMN_LOCATION + " TEXT, " +
                COLUMN_MOOD + " TEXT, " +
                COLUMN_THOUGHTS + " TEXT )";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String day, String time, String location, String mood, String thoughts) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_DAY, day);
        contentValues.put(COLUMN_TIME, time);
        contentValues.put(COLUMN_LOCATION, location);
        contentValues.put(COLUMN_MOOD, mood);
        contentValues.put(COLUMN_THOUGHTS, thoughts);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1; // returns true if data is inserted successfully
    }

    public List<JournalData> getAllEntries() {
        List<JournalData> entriesList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String day = cursor.getString(cursor.getColumnIndex(COLUMN_DAY));
                @SuppressLint("Range") String time = cursor.getString(cursor.getColumnIndex(COLUMN_TIME));
                @SuppressLint("Range") String location = cursor.getString(cursor.getColumnIndex(COLUMN_LOCATION));
                @SuppressLint("Range") String mood = cursor.getString(cursor.getColumnIndex(COLUMN_MOOD));
                @SuppressLint("Range") String thoughts = cursor.getString(cursor.getColumnIndex(COLUMN_THOUGHTS));

                JournalData journalData = new JournalData(day, time, location, mood, thoughts);
                entriesList.add(journalData);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return entriesList;
    }
}