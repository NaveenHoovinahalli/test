package com.example.samikshe.activity;



import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.samikshe.EventsAdapter;
import com.example.samikshe.R;

public class EventsActivity extends Activity implements View.OnClickListener {


	ListView eventList;
	TextView eventsText, holidaysText;
	EventsAdapter eventsAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_events);
		eventList = (ListView) findViewById(R.id.listEvent);
		eventsText = (TextView) findViewById(R.id.eventClicked);
		holidaysText = (TextView) findViewById(R.id.holidaysClicked);

		setList(true);
		eventsText.setOnClickListener(this);
		holidaysText.setOnClickListener(this);

		eventsText.setTextColor(Color.WHITE);
		eventsText.setBackgroundResource(R.drawable.leftradiousblue);
		holidaysText.setTextColor(getResources().getColor(R.color.apptheame));
		holidaysText.setBackgroundResource(R.drawable.rightradious);

	}


	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.eventClicked) {
			eventsText.setTextColor(Color.WHITE);
			eventsText.setBackgroundResource(R.drawable.leftradiousblue);
			holidaysText.setTextColor(getResources().getColor(R.color.apptheame));
			holidaysText.setBackgroundResource(R.drawable.rightradious);
			setList(true);
		} else {
			eventsText.setTextColor(getResources().getColor(R.color.apptheame));
			eventsText.setBackgroundResource(R.drawable.leftradious);
			holidaysText.setTextColor(Color.WHITE);
			holidaysText.setBackgroundResource(R.drawable.rightradiousblue);
			setList(false);

		}

	}

	private void setList(boolean b) {
		if (b) {
			eventsAdapter = new EventsAdapter(this, b);
			eventList.setAdapter(eventsAdapter);
		} else {

			eventsAdapter = new EventsAdapter(this, b);
			eventList.setAdapter(eventsAdapter);
		}
	}
}
