package com.handymen;

import com.toolmen.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class UserView extends Activity {
TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_view);
		t1=(TextView) findViewById(R.id.textView1);
		t2=(TextView) findViewById(R.id.textView2);
		t3=(TextView) findViewById(R.id.txServe);
		t4=(TextView) findViewById(R.id.txLoc);
		t5=(TextView) findViewById(R.id.textView5);
		t6=(TextView) findViewById(R.id.textView6);
		t7=(TextView) findViewById(R.id.textView7);
		t8=(TextView) findViewById(R.id.textView8);
		t9=(TextView) findViewById(R.id.textView9);
	}


}
