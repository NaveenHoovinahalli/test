package com.example.samikshe.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupExpandListener;

import com.example.samikshe.R;
import com.example.samikshe.adapters.ExpMarksAdapter;
import com.example.samikshe.utils.AnimatedExpandableListView;


public class StudentMarksActivity extends Activity implements ExpandableListView.OnGroupClickListener,ExpandableListView.OnChildClickListener,OnGroupExpandListener {

	ExpMarksAdapter expBakAdapter;
	AnimatedExpandableListView expListView;//Should use custom view
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;
	private int lastExpandedPosition = -1;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.markscard);


		// get the listview
		expListView = (AnimatedExpandableListView) findViewById(R.id.lvExpMarksCard);

		// preparing list data
		prepareListData();

//		listAdapter = new ExpandableListAdapterMarks(this, listDataHeader, listDataChild);
		expBakAdapter = new ExpMarksAdapter(this, listDataHeader, listDataChild);


		// setting list adapter
		expListView.setAdapter(expBakAdapter);
		expListView.setOnGroupClickListener(this);

	}

	/*
	 * Preparing the list data
	 */
	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// Adding child data
		listDataHeader.add("1st Test");
		listDataHeader.add("2nd Test");
		listDataHeader.add("Final Exam");



		// Adding child data
		List<String> top250 = new ArrayList<String>();
		top250.add("Subject");
		top250.add("Kannada");
		top250.add("English");
		top250.add("Hindi");
		top250.add("Social");
		top250.add("Total");



		List<String> nowShowing = new ArrayList<String>();
		nowShowing.add("Subject");
		nowShowing.add("Kannada");
		nowShowing.add("English");
		nowShowing.add("Hindi");
		nowShowing.add("Social");
		nowShowing.add("Kannada");
		nowShowing.add("English");
		nowShowing.add("Total");


		List<String> comingSoon = new ArrayList<String>();
		comingSoon.add("Subject");
		comingSoon.add("Kannada");
		comingSoon.add("English");
		comingSoon.add("Hindi");
		comingSoon.add("Total");




		listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
		listDataChild.put(listDataHeader.get(1), nowShowing);
		listDataChild.put(listDataHeader.get(2), comingSoon);

	}

	@Override
	public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {


		if (expListView.isGroupExpanded(groupPosition)) {
			expListView.collapseGroupWithAnimation(groupPosition);
		} else {
			expListView.expandGroupWithAnimation(groupPosition);
		}



		if(lastExpandedPosition != -1 && groupPosition != lastExpandedPosition) {
			expListView.collapseGroupWithAnimation(lastExpandedPosition);
		}
		lastExpandedPosition=groupPosition;

		return true;//should return true if animation class is handling the values
	}


	@Override
	public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
		return false;
	}

	@Override
	public void onGroupExpand(int groupPosition) {
//		if(lastExpandedPosition != -1 && groupPosition != lastExpandedPosition) {
//			expListView.collapseGroupWithAnimation(lastExpandedPosition);
//		}
//		lastExpandedPosition=groupPosition;
	}

}
