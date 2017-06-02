package com.handymen;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Datasource {
public static final String LOGTAG = "Dj";
	
	private SQLiteDatabase db;
	private SQLiteOpenHelper helper;
	private String ColumnNames[] = {
			Database.ID,
            Database.USER,
			Database.EMAIL,
			Database.PASS,
			Database.FIELD,
			Database.CHARGES,
			Database.PHONE_NO,
			Database.ADDRESS,
			Database.CITY
        	};
	
	
	public Datasource(Context context) {
		helper = new Database(context);
	}

	public void openDatabase() {
		Log.i(LOGTAG, "Database open");
		db = helper.getWritableDatabase();
	}

	public void closeDatabase() {
		Log.i(LOGTAG, "Database close");
		db.close();
	}

	public Gettersetter insertData(Gettersetter getter) {

		ContentValues values = new ContentValues();
		values.put(Database.USER, getter.getUsername());
		values.put(Database.EMAIL, getter.getEmail());
		values.put(Database.PASS, getter.getPassword());
		values.put(Database.FIELD, getter.getField());
		values.put(Database.CHARGES, getter.getCharges());
		values.put(Database.PHONE_NO, getter.getPhoneno());
		values.put(Database.ADDRESS, getter.getAddress());
		values.put(Database.CITY, getter.getCity());
	
		long r = db.insert(Database.TABLE_NAME, null, values);
		getter.setID(r);

		Log.i(LOGTAG, "Data inserted into database with id "+ r);

		return getter;
	}
	
	public ArrayList<Gettersetter> retrieveAllData(){
		ArrayList<Gettersetter> dataBeans = new ArrayList<Gettersetter>();
		
		Cursor cursor =db.query(Database.TABLE_NAME, ColumnNames, null, null, null, null, null); 
		cursor.moveToFirst();
		
		if(cursor.getCount() > 0){
			while(cursor.moveToNext()){
				Gettersetter getter = Gettersetter.getInstance();
				getter.setID(cursor.getLong(cursor.getColumnIndex(Database.ID)));
				getter.setUsername(cursor.getString(cursor.getColumnIndex(Database.USER)));
				getter.setEmail(cursor.getString(cursor.getColumnIndex(Database.EMAIL)));
				getter.setPassword(cursor.getString(cursor.getColumnIndex(Database.PASS)));
				getter.setField(cursor.getString(cursor.getColumnIndex(Database.FIELD)));
				getter.setCharges(cursor.getString(cursor.getColumnIndex(Database.CHARGES)));
				getter.setPhoneno(cursor.getString(cursor.getColumnIndex(Database.PHONE_NO)));
				getter.setAddress(cursor.getString(cursor.getColumnIndex(Database.ADDRESS)));
				getter.setCity(cursor.getString(cursor.getColumnIndex(Database.CITY)));
				
				dataBeans.add(getter);
			}
		}
		
		return dataBeans;
	}

}


