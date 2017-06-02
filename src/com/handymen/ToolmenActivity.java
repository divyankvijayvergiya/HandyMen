package com.handymen;



import java.util.Timer;
import java.util.TimerTask;

import com.toolmen.R;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class ToolmenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if(getIntent().getBooleanExtra("EXIT",false))
		{
			finish();}

TimerTask tt=new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent i=new Intent(ToolmenActivity.this,SelectService.class);
				startActivity(i);
				
			}
		};
		Timer t=new Timer();
		t.schedule(tt, 2000);
	
        		
	
	
        

	

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		if(getIntent().getBooleanExtra("EXIT",false))
		{
			finish();}
		
		return super.onCreateOptionsMenu(menu);
	}*/

	

	

}}