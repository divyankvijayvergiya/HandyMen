package com.handymen;

import com.toolmen.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class List extends Activity {
	//private static final Object Carpenter = null;
	Button ex;
	SQLiteDatabase db;
	TextView tv;
	ArrayAdapter<CharSequence>adapter;
	Spinner spn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		/*c=(Button) findViewById(R.id.submit);
		final MediaPlayer buttonsound1=MediaPlayer.create(List.this, R.raw.button_click1);
		spn=(Spinner) findViewById(R.id.ChService);
		e=(Button) findViewById(R.id.electriadd);
		pl=(Button) findViewById(R.id.button3);
		pa=(Button) findViewById(R.id.button4);
		b=(Button) findViewById(R.id.button5);*/
		ex=(Button) findViewById(R.id.buttonexit);
		
		ex.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View arg0) {
				
				Intent i=new Intent(List.this,Dataupload.class);
				startActivity(i);
				
			}
		});

/*b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//buttonsound1.start();
				Intent b=new Intent(List.this,Blacksmith.class);
				startActivity(b);
				
			}
		});

 */
	spn=(Spinner) findViewById(R.id.ChService);
adapter=ArrayAdapter.createFromResource(this, R.array.myArray, android.R.layout.simple_spinner_dropdown_item);
spn.setAdapter(adapter);

spn.setOnItemSelectedListener(new OnItemSelectedListener() {
    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
        if (position == 1){
            Intent intent = new Intent(List.this, Carpenter.class);
            List.this.startActivity(intent);
        }
        if(position==2)
        {
        	Intent intent = new Intent(List.this, Electrician.class);
            List.this.startActivity(intent);
        }
        
        if(position==3)
        {
        	Intent intent = new Intent(List.this, Plumber.class);
            List.this.startActivity(intent);
        }
        if(position==4)
        {
        	Intent intent = new Intent(List.this, Painter.class);
            List.this.startActivity(intent);
        }
        if(position==5)
        {
        	Intent intent=new Intent(List.this,Blacksmith.class);
        	List.this.startActivity(intent);
        }
    }

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}

});


	/*public void exit(View v)
	{
		Intent i=new Intent(List.this,Dataupload.class);
		startActivity(i);
	}*/
	
	}
	}
	
	
		