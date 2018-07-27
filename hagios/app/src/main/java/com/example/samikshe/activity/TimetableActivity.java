package com.example.samikshe.activity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.samikshe.EventsAdapter;
import com.example.samikshe.R;
import com.example.samikshe.adapters.ExpandableListAdapter;
import com.example.samikshe.utils.AnimatedExpandableListView;

public class TimetableActivity extends Activity implements OnGroupClickListener,OnChildClickListener,OnGroupExpandListener, View.OnClickListener {

	ExpandableListAdapter listAdapter,listAdapterFood;
	AnimatedExpandableListView expListView;//Should use custom view
	List<String> listDataHeader,listDataHeaderfood;
	HashMap<String, List<String>> listDataChild,listDataChildfood;
	private int lastExpandedPosition = -1;
	TextView subjectTV,foodTV;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.timetable);

		subjectTV= (TextView) findViewById(R.id.subjectClicked);
		foodTV= (TextView) findViewById(R.id.foodClicked);
		subjectTV.setOnClickListener(this);
		foodTV.setOnClickListener(this);

		// get the listview
		expListView = (AnimatedExpandableListView) findViewById(R.id.lvExpTimeTable);

		// preparing list data
		prepareListDataSUbject();

		prepareListDataFood();

		setList(true);

		expListView.setOnGroupClickListener(this);

		if(foodTV.getVisibility()==View.GONE) {
			subjectTV.setBackgroundResource(R.drawable.layout_bluestroke);
			subjectTV.setTextColor(Color.WHITE);
		}else {

			subjectTV.setBackgroundResource(R.drawable.leftradiousblue);
			subjectTV.setTextColor(Color.WHITE);
			foodTV.setBackgroundResource(R.drawable.rightradious);
			foodTV.setTextColor(getResources().getColor(R.color.apptheame));
		}

	}

	@Override
	protected void onResume() {
		super.onResume();



	}

	private int getCurrrentDay() {
		Calendar calendar=Calendar.getInstance();
		int day=calendar.get(Calendar.DAY_OF_WEEK);

		return day;
	}

	private void prepareListDataFood() {

		listDataHeaderfood = new ArrayList<String>();
		listDataChildfood = new HashMap<String, List<String>>();

		// Adding child data
		listDataHeaderfood.add("Monday");
		listDataHeaderfood.add("Tuesday");
		listDataHeaderfood.add("Wednesday");
		listDataHeaderfood.add("Thursday");
		listDataHeaderfood.add("Friday");
//		listDataHeaderfood.add("Saturday");
//		listDataHeaderfood.add("Sunday");


		// Adding child data
		List<String> top250 = new ArrayList<String>();
		top250.add("Tea");
		top250.add("Meals");
        top250.add("Milk");

		List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("Tea");
        nowShowing.add("Fried Rice");
        nowShowing.add("Milk");


		List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Tea");
        comingSoon.add("Meals");
        comingSoon.add("Milk");

		List<String> comingSoon4 = new ArrayList<String>();
        comingSoon4.add("Tea");
        comingSoon4.add("Veg-Biriyani");
        comingSoon4.add("Milk");


		List<String> comingSoon5 = new ArrayList<String>();
        comingSoon5.add("Tea");
        comingSoon5.add("Chappathi");
        comingSoon5.add("Milk");





		listDataChildfood.put(listDataHeaderfood.get(0), top250); // Header, Child data
		listDataChildfood.put(listDataHeaderfood.get(1), nowShowing);
		listDataChildfood.put(listDataHeaderfood.get(2), comingSoon);
		listDataChildfood.put(listDataHeaderfood.get(3), comingSoon4);
		listDataChildfood.put(listDataHeaderfood.get(4), comingSoon5);

	}

	/*
	 * Preparing the list data
	 */
	private void prepareListDataSUbject() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// Adding child data
		listDataHeader.add("Monday");
		listDataHeader.add("Tuesday");
		listDataHeader.add("Wednesday");
		listDataHeader.add("Thursday");
		listDataHeader.add("Friday");
//		listDataHeader.add("Saturday");
//		listDataHeader.add("Sunday");


		// Adding child data
		List<String> top250 = new ArrayList<String>();
		top250.add("Kannada");
		top250.add("Hindi");
		top250.add("English");
		top250.add("Biology");
		top250.add("Maths");


		List<String> nowShowing = new ArrayList<String>();
		nowShowing.add("Kannada");
		nowShowing.add("Hindi");
		nowShowing.add("English");
		nowShowing.add("Biology");
		nowShowing.add("Maths");

		List<String> comingSoon = new ArrayList<String>();
		comingSoon.add("Kannada");
		comingSoon.add("Hindi");
		comingSoon.add("English");
		comingSoon.add("Biology");
		comingSoon.add("Maths");


		List<String> comingSoon4 = new ArrayList<String>();
		comingSoon4.add("Kannada");
		comingSoon4.add("Hindi");
		comingSoon4.add("English");
		comingSoon4.add("Biology");
		comingSoon4.add("Maths");


		List<String> comingSoon5 = new ArrayList<String>();
		comingSoon5.add("Kannada");
		comingSoon5.add("Hindi");
		comingSoon5.add("English");
		comingSoon5.add("Biology");
		comingSoon5.add("Maths");




		listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
		listDataChild.put(listDataHeader.get(1), nowShowing);
		listDataChild.put(listDataHeader.get(2), comingSoon);
		listDataChild.put(listDataHeader.get(3), comingSoon4);
		listDataChild.put(listDataHeader.get(4), comingSoon5);
//		listDataChild.put(listDataHeader.get(5), comingSoon6);
//		listDataChild.put(listDataHeader.get(6), comingSoon7);

	}

	@Override
	public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {


		if(lastExpandedPosition != -1 && groupPosition != lastExpandedPosition) {
			expListView.collapseGroupWithAnimation(lastExpandedPosition);
		}
		lastExpandedPosition=groupPosition;

		if (expListView.isGroupExpanded(groupPosition)) {
			expListView.collapseGroupWithAnimation(groupPosition);
		} else {
			expListView.expandGroupWithAnimation(groupPosition);
		}
		return true;//should return true if animation class is handling the values
	}


	@Override
	public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
		return false;
	}

	@Override
	public void onGroupExpand(int groupPosition) {
		if(lastExpandedPosition != -1 && groupPosition != lastExpandedPosition) {
			expListView.collapseGroupWithAnimation(lastExpandedPosition);
		}
		lastExpandedPosition=groupPosition;
	}

	@Override
	public void onClick(View v) {
		if(foodTV.getVisibility()==View.GONE){
			return;
		}

		if (v.getId() == R.id.subjectClicked) {
			subjectTV.setBackgroundResource(R.drawable.leftradiousblue);
			subjectTV.setTextColor(Color.WHITE);
			foodTV.setBackgroundResource(R.drawable.rightradious);
			foodTV.setTextColor(getResources().getColor(R.color.apptheame));

			setList(true);
		} else {
			subjectTV.setBackgroundResource(R.drawable.leftradious);
			subjectTV.setTextColor(getResources().getColor(R.color.apptheame));
			foodTV.setBackgroundResource(R.drawable.rightradiousblue);
			foodTV.setTextColor(Color.WHITE);
			setList(false);

		}

	}


	private void setList(boolean b) {
		if (b) {

			listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild,true);

			// setting list adapter
			expListView.setAdapter(listAdapter);

			expandGroup();

		} else {

			listAdapterFood = new ExpandableListAdapter(this, listDataHeaderfood, listDataChildfood,false);
			// setting list adapter
			expListView.setAdapter(listAdapterFood);
			expandGroup();

		}
	}

	private void expandGroup() {
		if(getCurrrentDay()==1 || getCurrrentDay()==7) {
//			expListView.expandGroupWithAnimation(6);
//			lastExpandedPosition=6;
		}else {
			expListView.expandGroupWithAnimation(getCurrrentDay() - 2);
			lastExpandedPosition=getCurrrentDay()-2;

		}
	}
}
