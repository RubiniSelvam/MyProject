package com.example.kamionproject1;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	
	

	private  static final String DATABASE_NAME="RUBI";
	private  static final String DATABASE_TABLE="kamion_truck";
	private  static final String KEY_ROW_ID="_id";
	private  static final String KEY_PHONENUMBER="Phonenumber";
	private  static final String KEY_EMAIL_ID="Username";
	private  static final String KEY_PASSWORD="Password";
	private  static final int DATABASE_VERSION=1;
	
	/*private static final String DATABASE_CREATE = "CREATE TABLE " + DATABASE_TABLE
			+ "(" + KEY_ROW_ID + " INTEGER ," + KEY_PHONENUMBER + " INTEGER PRIMARY KEY ," + KEY_EMAIL_ID + " TEXT,"
			+ KEY_PASSWORD + " TEXT" + ")";*/

private static final String DATABASE_CREATE = "CREATE TABLE " + DATABASE_TABLE
+ "(" + KEY_ROW_ID + " INTEGER ," + KEY_PHONENUMBER + " INTEGER PRIMARY KEY ," + " TEXT,"+ KEY_EMAIL_ID + " TEXT,"
+ KEY_PASSWORD + " TEXT" + ")";

                                       

/*private static final String DATABASE_CREATE = "CREATE TABLE " + DATABASE_TABLE
+ "(" + KEY_ROW_ID + " INTEGER PRIMARY KEY," + KEY_PHONENUMBER + " TEXT,"+ KEY_EMAIL_ID + " TEXT,"
+ KEY_PASSWORD + " TEXT" + ")";*/

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
	db.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS");
		onCreate(db);
		
	}
	

}
