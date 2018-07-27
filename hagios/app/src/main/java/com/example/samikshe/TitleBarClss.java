package com.example.samikshe;




import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class TitleBarClss {
Context DgCtx;
public ImageButton linmbackarrow;
public TitleBarClss(Context pCtx){
	DgCtx=pCtx;
	LayoutInflater lytInflater=(LayoutInflater)DgCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	View Layouts=lytInflater.inflate(R.layout.titlebar,null);
	  linmbackarrow=(ImageButton) Layouts.findViewById(R.id.inmbackarrow); 
	ActionBar ActBar=((Activity)DgCtx).getActionBar();
	ActBar.setDisplayHomeAsUpEnabled(false);
	ActBar.setDisplayShowHomeEnabled(false);
	ActBar.setDisplayShowCustomEnabled(true);
	ActBar.setDisplayShowTitleEnabled(false);
	ActBar.setCustomView(Layouts);
	
	 linmbackarrow.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
					((Activity) DgCtx).finish();
			}
		});
}
}
