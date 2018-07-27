package com.example.samikshe.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.samikshe.R;
import com.example.samikshe.adapters.AttendanceListAdapter;
import com.example.samikshe.models.Attendance;

import java.util.ArrayList;

/**
 * Created by SCS on 3/1/2016.
 */
public class AttendanceListActivity extends Activity {


    ListView attendanceList;
    ArrayList<Attendance> attendancesArray=new ArrayList<Attendance>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attendance_list);
        attendanceList= (ListView) findViewById(R.id.attendanceList);

        prepareData();

        attendanceList.setAdapter(new AttendanceListAdapter(this));

    }

    private void prepareData() {

    }
}

