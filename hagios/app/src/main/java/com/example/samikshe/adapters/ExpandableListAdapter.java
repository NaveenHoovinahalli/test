package com.example.samikshe.adapters;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.samikshe.R;
import com.example.samikshe.utils.AnimatedExpandableListView;

public class ExpandableListAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter {

	private Context _context;
	private List<String> _listDataHeader; // header titles
	// child data in format of header title, child title
	private HashMap<String, List<String>> _listDataChild;
	boolean showTeacher=true;
	TextView teacherName;

	public ExpandableListAdapter(Context context, List<String> listDataHeader,
								 HashMap<String, List<String>> listChildData, boolean b) {
		this._context = context;
		this._listDataHeader = listDataHeader;
		this._listDataChild = listChildData;
		this.showTeacher=b;
	}

	@Override
	public Object getChild(int groupPosition, int childPosititon) {
		return this._listDataChild.get(this._listDataHeader.get(groupPosition))
				.get(childPosititon);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public View getRealChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		final String childText = (String) getChild(groupPosition, childPosition);


			LayoutInflater infalInflater = (LayoutInflater) this._context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.timetable_list_item, null);

		convertView.setBackgroundColor(_context.getResources().getColor(R.color.gray_divider2));


		teacherName= (TextView) convertView.findViewById(R.id.teacherName);
		if(!showTeacher)
			teacherName.setVisibility(View.GONE);
		else{
			if(childPosition==0)
				teacherName.setText("Sushil");
			else if(childPosition==1)
				teacherName.setText("Anoop");
			else if(childPosition==2)
				teacherName.setText("Aswin");
			else if(childPosition==3)
				teacherName.setText("Sahana");
			else teacherName.setText("Naveen");
		}


		TextView txtListChild = (TextView) convertView
				.findViewById(R.id.lblListItem);
		txtListChild.setText(childText);
		return convertView;
	}

	@Override
	public int getRealChildrenCount(int groupPosition) {
		return this._listDataChild.get(this._listDataHeader.get(groupPosition))
				.size();	}

//	@Override
//	public View getChildView(int groupPosition, final int childPosition,
//			boolean isLastChild, View convertView, ViewGroup parent) {
//
//		final String childText = (String) getChild(groupPosition, childPosition);
//
//		if (convertView == null) {
//			LayoutInflater infalInflater = (LayoutInflater) this._context
//					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//			convertView = infalInflater.inflate(R.layout.list_item, null);
//		}
//
//		TextView txtListChild = (TextView) convertView
//				.findViewById(R.id.lblListItem);
//
//		txtListChild.setText(childText);
//		return convertView;
//	}

//	@Override
//	public int getChildrenCount(int groupPosition) {
//		return this._listDataChild.get(this._listDataHeader.get(groupPosition))
//				.size();
//	}

	@Override
	public Object getGroup(int groupPosition) {
		return this._listDataHeader.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return this._listDataHeader.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		String headerTitle = (String) getGroup(groupPosition);
//		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) this._context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.timetable_list_group, null);
//		}

//		if ( groupPosition % 2 == 0 )
			convertView.setBackgroundColor(_context.getResources().getColor(R.color.white));

		TextView lblListHeader = (TextView) convertView
				.findViewById(R.id.lblListHeader);
		lblListHeader.setText(headerTitle);
		lblListHeader.setTextColor(_context.getResources().getColor(R.color.apptheame));

		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

}
