package com.handymen;



import java.util.ArrayList;
import java.util.Iterator;

import com.toolmen.R;
import com.toolmen.R.id;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddData extends Activity{

	EditText user,email, pass, confirmpass,field,charges,phoneno,address,city;
	
	
	Button add;
	Datasource datasource;
	Gettersetter getter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_data);
	getter = Gettersetter.getInstance();
	final MediaPlayer buttonsound1=MediaPlayer.create(AddData.this, R.raw.button_click1);
	datasource = new Datasource(getApplicationContext());

	user = (EditText) findViewById(R.id.aa);
	email = (EditText) findViewById(R.id.bb);
	pass= (EditText) findViewById(R.id.cc);
	confirmpass = (EditText) findViewById(R.id.dd);
	field = (EditText) findViewById(R.id.ee);
	charges = (EditText) findViewById(R.id.ff);
	phoneno= (EditText) findViewById(R.id.gg);
	address =(EditText) findViewById(R.id.hh);
     city=(EditText) findViewById(R.id.ii);   

	
	add = (Button) findViewById(R.id.addupload);
	add.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {
			//buttonsound1.start();
			String userText = user.getText().toString();
			String emailText = email.getText().toString();
			String passText = pass.getText().toString();
			
			String confirmpassText =confirmpass.getText().toString();
			String fieldText =field.getText().toString();
			String chargesText = charges.getText().toString();
			String phonenoText =phoneno.getText().toString();
			String addressText = address.getText().toString();
			String cityText = city.getText().toString();
			if ((passText).equals(confirmpassText)
					&& validateEmail(emailText)) {

				getter.setData(userText, emailText, passText, fieldText, chargesText,phonenoText, addressText, cityText);
				if (insertIntoDatabase(getter)) {
					Intent intent = new Intent(AddData.this,
							Providerlogin.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
							| Intent.FLAG_ACTIVITY_NEW_TASK);
					startActivity(intent);
				}
			} else {
				Toast toast = Toast.makeText(getBaseContext(),
						"passwords don't match or EmailId invalid", Toast.LENGTH_SHORT);
				toast.show();
			}
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

boolean insertIntoDatabase(Gettersetter setter) {
	datasource.openDatabase();
	ArrayList<Gettersetter> dataBeans = datasource.retrieveAllData();
	Iterator<Gettersetter> iterator = dataBeans.iterator();
	int count = 0;
	while (iterator.hasNext()) {
		Gettersetter myBean = iterator.next();
		if ((setter.getUsername()).equals(myBean.getUsername())) {
			count++;
			break;
		}
	}

	if (count > 0) {
		Toast toast = Toast.makeText(getBaseContext(),
				"Username already used. ", Toast.LENGTH_SHORT);
		toast.show();
		return false;
	} else {

		setter = datasource.insertData(setter);

		if (setter.getID() != -1) {
			Toast toast = Toast.makeText(getBaseContext(),
					"Data Successfully Uploaded/Added.",
					Toast.LENGTH_SHORT);
			toast.show();
			return true;
		} else {
			Toast toast = Toast.makeText(getBaseContext(),
					" Problem occured.", Toast.LENGTH_SHORT);
			toast.show();
			return false;
		}
	}
}

boolean validateEmail(String emailId) {
	try {
		
		String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		return emailId.matches(emailreg);

	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
		return false;
	}
}
}
	
