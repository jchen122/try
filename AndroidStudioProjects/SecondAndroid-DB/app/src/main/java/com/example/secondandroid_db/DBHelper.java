package com.example.secondandroid_db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
	
	public static final String DATABASE_NAME="mydb";
	public static final String TABLE_NAME="mytable";
	public static final String NAME="name";
	public static final String PHONE="phone";
	public static final String SUBJECT="subject";
	public static final String ID="id";
	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, 1);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_TABLE="create table mytable (id integer primary key,name text,phone text,subject text)";
		db.execSQL(CREATE_TABLE);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
