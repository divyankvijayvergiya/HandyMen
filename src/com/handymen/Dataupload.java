package com.handymen;

import com.toolmen.R;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Dataupload extends Activity {
Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dataupload);
		b=(Button) findViewById(R.id.submit);
		final MediaPlayer buttonsound1=MediaPlayer.create(Dataupload.this, R.raw.button_click1);
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0)  {
		//buttonsound1.start();
				Intent intent=new Intent(Dataupload.this,ToolmenActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
				intent.putExtra("EXIT", true);
				startActivity(intent);
				
			}
		});
        
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onStop()
	 */
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		finish();
	}
	

	
}
