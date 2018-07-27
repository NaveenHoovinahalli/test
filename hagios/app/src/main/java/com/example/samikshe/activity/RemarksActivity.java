package com.example.samikshe.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.samikshe.R;
import com.example.samikshe.adapters.HomeworkAdapter;
import com.example.samikshe.adapters.RemarksAdapter;

/**
 * Created by SCS on 3/1/2016.
 */
public class RemarksActivity extends Activity {


    ListView remarksList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remarks);

        remarksList= (ListView) findViewById(R.id.remarkskList);

        remarksList.setAdapter(new RemarksAdapter(this));
    }
}
