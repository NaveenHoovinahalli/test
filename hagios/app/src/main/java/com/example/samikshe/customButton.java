package com.example.samikshe;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class customButton extends LinearLayout {
	ImageButton btnImage;
	TextView tvvalue;
	int dgImageSrc,dgbackground;
	String	dgMenuName ;
	 
	 @Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		btnImage =(ImageButton) findViewById(R.id.btnImage);
		tvvalue =(TextView) findViewById(R.id.tvvalue);
		if (tvvalue!=null)
		 	tvvalue.setText(dgMenuName);
		
		if (btnImage!=null){
			btnImage.setImageResource(dgImageSrc);
			btnImage.setBackgroundResource(dgbackground);
		}
		if (btnImage !=null)
		btnImage.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				performClick();
			}
		});
		if (tvvalue !=null)
		tvvalue.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				performClick();
			}
		});
	}

	public customButton(Context context) {
		super(context);
		LayoutInflater.from(context).inflate(R.layout.custombutton, this);
	}

	public customButton(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initiateView(context,attrs);
	}

	public customButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		initiateView(context,attrs);
	}

	
	public void initiateView(Context context, AttributeSet attrs){
	TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
			R.styleable.customButton, 0, 0);

	try {
	 	dgMenuName = a.getString(R.styleable.customButton_name);
		dgImageSrc= a.getResourceId(R.styleable.customButton_Imagesrc, R.drawable.erricon);
		dgbackground= a.getResourceId(R.styleable.customButton_Imagebgsrc, R.drawable.erricon);
	
	} finally {
		a.recycle();
	}
	LayoutInflater.from(context).inflate(R.layout.custombutton, this);
}

	@Override
	public boolean performClick() {
		return super.performClick();
	}
}
