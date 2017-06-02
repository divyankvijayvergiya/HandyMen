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

public class Carpenter extends Activity {
Button b1;
Database db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_carpenter);
	b1=(Button) findViewById(R.id.submit);
	final MediaPlayer buttonsound1=MediaPlayer.create(Carpenter.this, R.raw.button_click1);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//buttonsound1.start();
				Intent b11=new Intent(Carpenter.this,List.class);
				startActivity(b11);
				finish();
				

			}
		});
db=new Database(getApplicationContext());
		
		ArrayList<String[]> arr=new ArrayList<String[]>(db.viewAlldetails1());
		ArrayList<String> name=new ArrayList<String>();
		int size=arr.size()-1;
		while(size>=0)
		{
			name.add("\n"+"**"+"Name-"+arr.get(size)[1]+"\n"+" "+"Charges-"+arr.get(size)[5]+"\n"+" "+"City-"+arr.get(size)[8]+"\n"+" "+"Phone No.-"+arr.get(size)[6]+"\n");
			size--;
		}
		ArrayAdapter<String> list=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, name);
		ListView li=(ListView)findViewById(R.id.listView1);
		li.setAdapter(list);
		
	}
	
	

}
