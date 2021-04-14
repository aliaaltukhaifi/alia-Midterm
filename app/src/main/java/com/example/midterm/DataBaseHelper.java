package com.example.midterm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;


public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "db";
    public static final String TABLE_NAME = "Database";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_phone= "PhoneNumber";
    public static final String COLUMN_email= "Email";


    public DataBaseHelper(@Nullable Context context) {


        super(context, DATABASE_NAME, null, 1
        ); }


    @Override
    public void onCreate(SQLiteDatabase datab) {
        datab.execSQL(

                "CREATE TABLE " +TABLE_NAME +"(" +
                        COLUMN_ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME + " TEXT NOT NULL," +
                        COLUMN_phone + " INTEGER NOT NULL, " +
                        COLUMN_email + " INTEGER NOT NULL)"
        );
    }


    //(add)
    public void AddEmployee(String id, String name, String email , int phonenumber) {

        SQLiteDatabase datab = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(COLUMN_ID, id);
        val.put(COLUMN_NAME, name);
        val.put(COLUMN_phone, phonenumber);
        val.put(COLUMN_email, email);
        datab.insert(TABLE_NAME, null, val);
    }


    //(view)
    public Cursor ViewEmployees() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor dax = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return dax;

    }


    //(delete)
    public Integer DeleteEmployees(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[]{id});

    }

    @Override
    /* Every time the database is updated */

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void DeleteUsers(String id) {
        String[] args = {id};
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + "= ?", args);
    }


}
