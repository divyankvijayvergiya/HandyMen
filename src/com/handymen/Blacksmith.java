package com.handymen;

import java.util.ArrayList;

import com.toolmen.R;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Blacksmith extends Activity {
	Button b5;
	Database db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_blacksmith);
	b5=(Button) findViewById(R.id.button5);
	final MediaPlayer buttonsound1=MediaPlayer.create(Blacksmith.this, R.raw.button_click1);
		b5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//buttonsound1.start();
				Intent b55=new Intent(Blacksmith.this,List.class);
				startActivity(b55);
				finish();
				
			}
		});
        db=new Database(getApplicationContext());
		
		ArrayList<String[]> arr=new ArrayList<String[]>(db.viewAlldetails5());
		ArrayList<String> name=new ArrayList<String>();
		int size=arr.size()-1;
		while(size>=0)
		{
			name.add("\n"+"** "+"Name-"+arr.get(size)[1]+"\n"+" "+"Charges-"+arr.get(size)[5]+"\n"+" "+"City-"+arr.get(size)[8]+"\n"+" "+"Phone No.-"+arr.get(size)[6]+"\n");
			size--;
		}
		ArrayAdapter<String> list=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, name);
		ListView li=(ListView)findViewById(R.id.listView5);
		li.setAdapter(list);
		
	}}

	

	
	

	
