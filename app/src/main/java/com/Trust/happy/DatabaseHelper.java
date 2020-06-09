package com.Trust.happy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


/**
 * Assists with database queries
 * Allows for: CREATE,RETRIEVE, DELETE,UPDATE functionality
 */
public class DatabaseHelper extends SQLiteOpenHelper
{

    public DatabaseHelper(@Nullable Context context) {
        super(context,"Login.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("Create table user(email text primary key,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table if exists user");
    }

    //Function to create new user record in table
    public boolean insert(String email,String pass)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",pass);
        long ins = db.insert("user",null,contentValues);

        if(ins == -1)return false;
        else return true;
    }

    //Function to check if user email exists already
    public Boolean chkEmail (String email)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("Select * from user where email=?",new String[] {email});

        if(c.getCount()>0)return false;
        else return true;
    }

    //Function to search for user by email and password
    public Boolean emailPassword (String email, String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("Select * from user where email=? and password=?",new String[]{email,password});
        if(c.getCount() > 0)return true;
        else return false;
    }
}
