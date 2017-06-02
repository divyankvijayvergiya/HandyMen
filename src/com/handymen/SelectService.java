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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SelectService extends Activity implements OnClickListener{
	RadioButton r,r1,r2;
	RadioGroup ra;

Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selectservice);
		r1=(RadioButton) findViewById(R.id.user);
		r2=(RadioButton) findViewById(R.id.prov);
		ra = (RadioGroup) findViewById(R.id.radioGroup1);
		b=(Button) findViewById(R.id.ok);
		b.setOnClickListener(this);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		TextView t=(TextView) findViewById(R.id.exit2);
		
		final MediaPlayer buttonsound1=MediaPlayer.create(SelectService.this, R.raw.button_click1);
		b.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
			//	buttonsound1.start();
				int CheckedRadiobuttonId=ra.getCheckedRadioButtonId();
				r=(RadioButton) findViewById(CheckedRadiobuttonId);
				if(r1.isChecked())
				{
					Intent u=new Intent(SelectService.this,List.class);
					startActivity(u);
				}
				else
				{
					if(r2.isChecked())
					{
					Intent p=new Intent(SelectService.this,Providerlogin.class);
					startActivity(p);
				}
				}
			}
			
				
			
		} );
	
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}


}
