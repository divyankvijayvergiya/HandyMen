package com.handymen;

import java.util.ArrayList;
import java.util.Iterator;

import com.toolmen.R;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Providerlogin extends Activity {
TextView t,e,m;
Button b;
SQLiteDatabase db ;
Datasource datasource;
Gettersetter getter;
EditText u,p;
String s1,s2,s3,s4,s5,s6,s7,s8;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_providerlogin);
		datasource = new Datasource(getApplicationContext());
		final MediaPlayer buttonsound1=MediaPlayer.create(Providerlogin.this, R.raw.button_click1);

		t=(TextView) findViewById(R.id.here);
		e=(TextView) findViewById(R.id.exit);
		m=(TextView) findViewById(R.id.main);
		b=(Button) findViewById(R.id.login);
	    u=(EditText) findViewById(R.id.user);
	    p=(EditText) findViewById(R.id.pass);
	    b.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					//buttonsound1.start();
					
			    final String username= u.getText().toString();
				final String password=p.getText().toString();
					
					 if(matchfromDatabase( username, password))
					    {
					    	Toast t=Toast.makeText(getBaseContext(),"Login successfull",Toast.LENGTH_SHORT);
					    	t.show();
					    	Intent d=new Intent(Providerlogin.this, Displayprofile.class);
					    	s1="UserName:-"+getter.getUsername();
					    	s2="Email:-"+getter.getEmail();
					    	s3="Password:-"+getter.getPassword();
					    	s4="Field:-"+getter.getField();
					    	s5="Charges:-"+getter.getCharges();
					    	s6="Phone No:-"+getter.getPhoneno();
					    	s7="Address:-"+getter.getAddress();
					    	s8="City:-"+getter.getCity();
					    	d.putExtra("a",s1);
					    	d.putExtra("b", s2);
					    	d.putExtra("c", s3);
					    	d.putExtra("d", s4);
					    	d.putExtra("e", s5);
					    	d.putExtra("f", s6);
					        d.putExtra("g", s7);
					    	d.putExtra("i", s8);
					    	startActivity(d);
					    	finish();
					    }
					    else
					    {
					    	Toast t=Toast.makeText(getBaseContext(),"Username or Password are Invalid",Toast.LENGTH_SHORT);
					    	t.show();
					    	
					    }
					
				}

				private boolean matchfromDatabase(String username,
						String password) {
					datasource.openDatabase();
					ArrayList<Gettersetter> dataBeans = datasource.retrieveAllData();
					Iterator<Gettersetter> iterator = dataBeans.iterator();
					int count = 0;
					while (iterator.hasNext()) {
						getter = iterator.next();
						if(username.equals(getter.getUsername()) && password.equals(getter.getPassword())){
							count++;
							break;
						}
					}

					if(count == 0){
						return false;
					}
					else {
						return true;
					}
				}
	    });
		   
			t.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//buttonsound1.start();
				Intent t=new Intent(Providerlogin.this, AddData.class);
				startActivity(t);
				finish();
			}
		});
			e.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					//buttonsound1.start();
					Intent e=new Intent(Providerlogin.this, Dataupload.class);
					startActivity(e);
					finish();
				}
			});
			m.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					//buttonsound1.start();
					Intent m=new Intent(Providerlogin.this, SelectService.class);
					startActivity(m);
					finish();
					
				}
			});
	}
	@Override
	protected void onResume() {
		super.onResume();
		datasource.openDatabase();
	}

	@Override
	protected void onPause() {
		super.onPause();
		datasource.closeDatabase();
	}
	


	
	
	
	
	

	

}
