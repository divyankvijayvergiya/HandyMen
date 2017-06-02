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

public class Painter extends Activity {
Button b4;
Database db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_painter);
		b4=(Button) findViewById(R.id.button4);
		final MediaPlayer buttonsound1=MediaPlayer.create(Painter.this, R.raw.button_click1);
		b4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//buttonsound1.start();
				Intent b44=new Intent(Painter.this,List.class);
				startActivity(b44);
				finish();
				

			}
		});
db=new Database(getApplicationContext());
		
		ArrayList<String[]> arr=new ArrayList<String[]>(db.viewAlldetails4());
		ArrayList<String> name=new ArrayList<String>();
		int size=arr.size()-1;
		while(size>=0)
		{
			name.add("\n"+"**"+"Name-"+arr.get(size)[1]+"\n"+" "+"Charges-"+arr.get(size)[5]+"\n"+" "+"City-"+arr.get(size)[8]+"\n"+" "+"Phone No.-"+arr.get(size)[6]+"\n");
			size--;
		}
		ArrayAdapter<String> list=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, name);
		ListView li=(ListView)findViewById(R.id.listView4);
		li.setAdapter(list);
		
	}
	
	
}

