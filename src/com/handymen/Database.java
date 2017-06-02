package com.handymen;




import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Database extends SQLiteOpenHelper{

	
	private static String DATABASE_NAME="HandyData";
	static  String TABLE_NAME="mdb";
	private static final int version=1;
	private static Context context=null;
	public static final String ID = "id";
	public static final String USER = "username";
	public static final String EMAIL = "email";
	public static final String PASS = "password";
	public static final String FIELD = "field";

    public static final String CHARGES = "charges";
	public static final String PHONE_NO = "phoneno";	
	public static final String ADDRESS = "address";
	public static final String CITY = "city";
	public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
			+ TABLE_NAME + "( " + ID	+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ USER + " VARCHAR NOT NULL, " 
			+ EMAIL + " VARCHAR NOT NULL, "
			+ PASS + " VARCHAR NOT NULL, " 
			+ FIELD + " VARCHAR NOT NULL, " 
			+ CHARGES + " VARCHAR NOT NULL, " 
			+ PHONE_NO + " VARCHAR NOT NULL, " 
			+ ADDRESS + " VARCHAR NOT NULL, " 
			+ CITY +" VARCHAR NOT NULL);"; 
	public Database(Context context) {
		super(context, DATABASE_NAME, null, version);
		Database.context=context;
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE);
		
	}


	/*@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"(ID INTEGER AUTOINCREMENT,USER VARCHAR NOT NULL,EMAIL VARCHAR NOT NULL,PASS VARCHAR NOT NULL,FIELD VARCHAR NOT NULL,CHARGES VARCHAR NOT NULL,PHONE_NO VARCHAR NOT NULL,ADDRESS VARCHAR NOT NULL,CITY VARCHAR NOT NULL)");	
		}*/

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public Boolean addContact(ContentValues value)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		long l=db.insert(TABLE_NAME, null, value);
		if(l>0)
			return true;
		else
			return false;
	}


public ArrayList<String[]> viewAlldetails1()
	{
		ArrayList<String[]> details=new ArrayList<String[]>();
		try{
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor result=db.rawQuery("select * from "+TABLE_NAME+" WHERE field='Carpenter' OR field='carpenter'",null);
	
		//Toast.makeText(context, i+"", Toast.LENGTH_SHORT).show();
		while(!result.isLast())
		{
			result.moveToNext();
			details.add(new String[]{result.getString(0),result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8)});
		}
		}
		catch(Exception e)
		{
			Toast.makeText(Database.context, "Currently no Handy available", Toast.LENGTH_LONG).show();
		}
		return details;
	}

public ArrayList<String[]> viewAlldetails2()
{
	ArrayList<String[]> details=new ArrayList<String[]>();
	try{
	SQLiteDatabase db=this.getReadableDatabase();
	Cursor result=db.rawQuery("select * from "+TABLE_NAME+" WHERE field='Electrician' OR field='electrician'",null);

	//Toast.makeText(context, i+"", Toast.LENGTH_SHORT).show();
	while(!result.isLast())
	{
		result.moveToNext();
		details.add(new String[]{result.getString(0),result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8)});
	}
	}
	catch(Exception e)
	{
		Toast.makeText(Database.context, "Currently no Handy available", Toast.LENGTH_LONG).show();
	}
	return details;
}
public ArrayList<String[]> viewAlldetails3()
{
	ArrayList<String[]> details=new ArrayList<String[]>();
	try{
	SQLiteDatabase db=this.getReadableDatabase();
	Cursor result=db.rawQuery("select * from "+TABLE_NAME+" WHERE field='Plumber' OR field='plumber'",null);

	//Toast.makeText(context, i+"", Toast.LENGTH_SHORT).show();
	while(!result.isLast())
	{
		result.moveToNext();
		details.add(new String[]{result.getString(0),result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8)});
	}
	}
	catch(Exception e)
	{
		Toast.makeText(Database.context, "Currently no Handy available", Toast.LENGTH_LONG).show();
	}
	return details;
}
public ArrayList<String[]> viewAlldetails4()
{
	ArrayList<String[]> details=new ArrayList<String[]>();
	try{
	SQLiteDatabase db=this.getReadableDatabase();
	Cursor result=db.rawQuery("select * from "+TABLE_NAME+" WHERE field='Painter' OR field='painter'",null);

	//Toast.makeText(context, i+"", Toast.LENGTH_SHORT).show();
	while(!result.isLast())
	{
		result.moveToNext();
		details.add(new String[]{result.getString(0),result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8)});
	}
	}
	catch(Exception e)
	{
		Toast.makeText(Database.context, "Currently no Handy available", Toast.LENGTH_LONG).show();
	}
	return details;
}
public ArrayList<String[]> viewAlldetails5()
{
	ArrayList<String[]> details=new ArrayList<String[]>();
	try{
	SQLiteDatabase db=this.getReadableDatabase();
	Cursor result=db.rawQuery("select * from "+TABLE_NAME+" WHERE field='Blacksmith' OR field='blacksmith'",null);

	//Toast.makeText(context, i+"", Toast.LENGTH_SHORT).show();
	while(!result.isLast())
	{
		result.moveToNext();
		details.add(new String[]{result.getString(0),result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8)});
	}
	}
	catch(Exception e)
	{
		Toast.makeText(Database.context, "Currently no Handy available", Toast.LENGTH_LONG).show();
	}
	return details;
}
}