package com.example.samikshe.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.samikshe.R;
import com.example.samikshe.adapters.GalleryAdapter;

/**
 * Created by SCS on 1/22/2016.
 */
public class GalleryActivity extends Activity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallerymain);
        gridView= (GridView) findViewById(R.id.imageGrid);
        gridView.setAdapter(new GalleryAdapter(this));
    }
}
