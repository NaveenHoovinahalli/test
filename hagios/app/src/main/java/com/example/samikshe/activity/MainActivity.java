package com.example.samikshe.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.samikshe.R;
import com.example.samikshe.TitleBarClss;


public class MainActivity extends Activity {
	TitleBarClss TitleBarLayout;
	TextView txtName;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainlayout);

	}


	public void onclick(View view){
		String press="";
		switch (view.getId()){
		case R.id.teachersButton:
			startActivity(new Intent(this,TeachersActivity.class));
			press="notification";
			break;
		case R.id.btnAttendance:
//			startActivity(new Intent (this, AttendenceActivity.class));
			startActivity(new Intent (this, AttendanceActivity.class));
			break;
		case R.id.btnCEvent:
			startActivity(new Intent (this, EventsActivity.class));
			break;
		case R.id.btnExams:
			startActivity(new Intent (this, ExamsActivity.class));
			break;
		case R.id.btnTimeTable:
			startActivity(new Intent (this, TimetableActivity.class));
			break;
		case R.id.btnInformation:
			startActivity(new Intent (this, InformationActivity.class));
			break;
		case R.id.btnhomework:
			startActivity(new Intent (this, HomeWorkActivity.class));
			break;
		case R.id.btnGallary:
			press="btnGallary";
			break;
		}
		
	}
}
