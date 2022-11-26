package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper  extends SQLiteOpenHelper {
    public static final String DBname="login.db";
    public DBHelper(Context context) {
        super(context, "login.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table users(Username TEXT primary key, password TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("drop table if exists users");
    }
    public boolean insertData(String Username, String password){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("Username",Username);
        values.put("password",password);
        long results= db.insert("users",null,values);
        if (results==1) return false;
        else
            return true;


    }
    public boolean checkusername(String Username){

        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor= db.rawQuery("select * from users where Username=?",new String[] {Username});
        if(cursor.getCount()>0)
            return  true;
        else
            return false;
    }
    public boolean checkusernamepassword(String user, String Username){

        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor= db.rawQuery("select * from users where Username=?",new String[] {Username});
        if(cursor.getCount()>0)
            return  true;
        else
            return false;
    }
}
