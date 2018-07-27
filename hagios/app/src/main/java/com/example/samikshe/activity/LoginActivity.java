package com.example.samikshe.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.samikshe.Calhttp;
import com.example.samikshe.R;
import com.example.samikshe.TitleBarClss;


public class LoginActivity extends Activity {
TitleBarClss TitleBarLayout;
Button btnLogin;
EditText EtUserName,EtPassword;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.activity_login_otp);
		
//		TitleBarLayout = new TitleBarClss(this);
		btnLogin =(Button) findViewById(R.id.btnLogin);
		EtPassword=(EditText) findViewById(R.id.EdPassword);

		

		btnLogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent mainAct =new Intent(getApplicationContext(), PagerMain.class);
				startActivity(mainAct);
				finish();
			}
		});
//		btnLogin.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View arg0) {
//				if (EtUserName.getText().toString().equals("")){
//					EtUserName.setError("User name canot be empty");
//				}
//				else if (EtPassword.getText().toString().equals("")){
//					EtPassword.setError("Password canot be empty");
//				}
//
//				StrictMode.ThreadPolicy policy =new StrictMode.ThreadPolicy.Builder().permitAll().build();
//				StrictMode.setThreadPolicy(policy);
//				Calhttp CV=new Calhttp();
//			String ans=	CV.login(EtUserName.getText().toString(),EtPassword.getText().toString());
//
//
//
//		if (!ans.equals("false")){
//
//			Intent mainAct =new Intent(getApplicationContext(), MainActivity.class);
//			startActivity(mainAct);
//
//			SharedPreferences pref=getApplicationContext().getSharedPreferences("Student", Context.MODE_PRIVATE );
//			Editor lEditor= pref.edit();
//			lEditor.putString("StuID",ans);
//			lEditor.commit();
//		}
//			}
//		});
	}

	public void showDialog(){

		Dialog dialog=new Dialog(this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.otp_dialog);
		dialog.show();

	}
}
