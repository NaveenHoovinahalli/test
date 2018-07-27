package com.example.samikshe.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.samikshe.R;
import com.example.samikshe.adapters.HomeworkAdapter;
import com.example.samikshe.adapters.InformationAdapter;

/**
 * Created by SCS on 3/1/2016.
 */
public class InformationActivity extends Activity {

    ListView informationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);
        informationList= (ListView) findViewById(R.id.informationkList);

        informationList.setAdapter(new InformationAdapter(this));

    }
}
