package com.balkhiz.mrng;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Balkhiz on 21-Mar-18.
 */

 public class DataBaseHelper2G  extends SQLiteOpenHelper {

 public static final String DATABASE_NAME = "data.db";
 public static final String TABLE_NAME = "dataTable";
 public static final String COLUMN_NAME = "notes";
 public static String notes;
 private ArrayList<String> list;

 public DataBaseHelper2G(Context context) {
  super( context, DATABASE_NAME, null, 1);
 }

 @Override
 public void onCreate(SQLiteDatabase sqLiteDatabase) {

  sqLiteDatabase.execSQL( "create table " + TABLE_NAME + "(notes STRING PRIMARY KEY)" );

 }

 @Override
 public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
  sqLiteDatabase.execSQL( "DROP TABLE IF EXISTS " + TABLE_NAME );
  onCreate( sqLiteDatabase );
 }
 public boolean  insertData(String notes) {
  long result = -1;
  SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
  ContentValues contentValues = new ContentValues();
  contentValues.put( COLUMN_NAME, notes );
  try {
   result = sqLiteDatabase.insert( TABLE_NAME, null, contentValues );
  }
  catch (Exception e){
   e.printStackTrace();
  }
  if (result == -1)
   return false;
  else
   return true;
 }
}

