package com.example.samikshe.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.samikshe.R;
import com.example.samikshe.models.Exams;
import com.example.samikshe.models.Marks;
import com.example.samikshe.utils.AnimatedExpandableListView;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapterExamsTable extends AnimatedExpandableListView.AnimatedExpandableListAdapter {

	private Context _context;
	private List<String> _listDataHeader; // header titles
	// child data in format of header title, child title
	private HashMap<String, List<Exams>> _listDataChild;
	View bttomLine;
	TextView subjectTV,totalMarksTV,obtainedTV,gradeTV;
	TextView date;

	public ExpandableListAdapterExamsTable(Context context, List<String> listDataHeader,
										   HashMap<String, List<Exams>> listChildData) {
		this._context = context;
		this._listDataHeader = listDataHeader;
		this._listDataChild = listChildData;
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

			LayoutInflater infalInflater = (LayoutInflater) this._context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.exams_expitem_table, null);
		subjectTV= (TextView) convertView.findViewById(R.id.textView1);
		totalMarksTV= (TextView) convertView.findViewById(R.id.textView2);
		obtainedTV= (TextView) convertView.findViewById(R.id.textView3);
		gradeTV= (TextView) convertView.findViewById(R.id.textView4);


//		if ( childPosition % 2 == 0 )
			convertView.setBackgroundColor(_context.getResources().getColor(R.color.gray_divider2));


		final Exams exams = (Exams) getChild(groupPosition, childPosition);



		subjectTV.setText(exams.getSubject());
		totalMarksTV.setText(exams.getDate());
		obtainedTV.setText(exams.getStartTime());
		gradeTV.setText(exams.getEndTime());

		bttomLine=convertView.findViewById(R.id.bottomView);
		if(childPosition==this._listDataChild.get(this._listDataHeader.get(groupPosition))
				.size()-1)
			bttomLine.setVisibility(View.VISIBLE);
		else bttomLine.setVisibility(View.GONE);
		return convertView;
	}

	@Override
	public int getRealChildrenCount(int groupPosition) {
		return this._listDataChild.get(this._listDataHeader.get(groupPosition))
				.size();	}


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
			LayoutInflater infalInflater = (LayoutInflater) this._context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.marks_list_group, null);
         date= (TextView) convertView.findViewById(R.id.examDate);
		if(groupPosition==0)
			date.setText("28-11-2015");
		else if(groupPosition==1)
			date.setText("31-12-2015");
		else if(groupPosition==2)
			date.setText("29-02-2016");

//		if ( groupPosition % 2 == 0 )
			convertView.setBackgroundColor(_context.getResources().getColor(R.color.white));

		TextView lblListHeader = (TextView) convertView
				.findViewById(R.id.lblListHeader);

		lblListHeader.setText(headerTitle);

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
