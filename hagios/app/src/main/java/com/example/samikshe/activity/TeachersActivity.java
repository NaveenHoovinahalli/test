package com.example.samikshe.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.samikshe.R;
import com.example.samikshe.adapters.TeachersAdapter;

/**
 * Created by SCS on 1/20/2016.
 */
public class TeachersActivity extends Activity {

    ListView teachersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teachers);
        teachersList= (ListView) findViewById(R.id.listTeachers);
        teachersList.setAdapter(new TeachersAdapter(this));

    }
}
