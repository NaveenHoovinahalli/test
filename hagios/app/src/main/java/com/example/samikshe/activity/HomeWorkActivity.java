package com.example.samikshe.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.samikshe.R;
import com.example.samikshe.adapters.HomeworkAdapter;


/**
 * Created by SCS on 1/20/2016.
 */
public class HomeWorkActivity extends Activity {

    ListView homeworkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework);
        homeworkList= (ListView) findViewById(R.id.homeworkList);

        homeworkList.setAdapter(new HomeworkAdapter(this));

    }
}
