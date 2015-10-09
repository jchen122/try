package com.example.jiaweichen.login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jiaweichen on 10/7/15.
 */
public class DBHelper extends SQLiteOpenHelper{
    public DBHelper(Context context) {
        super(context, "mydb", null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE="create table mytable(id integer primary key,name text,password text)";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
