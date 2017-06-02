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
import android.widget.EditText;
import android.widget.TextView;

public class Displayprofile extends Activity {
TextView t2,t3,t4,t5,t6,t7,t8,t9;

Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_displayprofile);
		final MediaPlayer buttonsound1=MediaPlayer.create(Displayprofile.this, R.raw.button_click1);
		
		t2=(TextView) findViewById(R.id.main);
		t3=(TextView) findViewById(R.id.exit);
		t4=(TextView) findViewById(R.id.txLoc);
		t5=(TextView) findViewById(R.id.textView5);
		t6=(TextView) findViewById(R.id.textView6);
		t7=(TextView) findViewById(R.id.textView7);
		t8=(TextView) findViewById(R.id.textView8);
		t9=(TextView) findViewById(R.id.textView9);
		b=(Button) findViewById(R.id.logout);
		
		t2.setText(getIntent().getExtras().getString("a" ));
		t3.setText(getIntent().getExtras().getString("b" ));
		t4.setText(getIntent().getExtras().getString("c" ));
		t5.setText(getIntent().getExtras().getString("d"));
		t6.setText(getIntent().getExtras().getString("e"));
		t7.setText(getIntent().getExtras().getString("f"));
		t8.setText(getIntent().getExtras().getString("g"));
		t9.setText(getIntent().getExtras().getString("i"));
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				buttonsound1.start();
				Intent i=new Intent(Displayprofile.this,Providerlogin.class);
				startActivity(i);
				finish();
			}
		});
		
	}

	
}
