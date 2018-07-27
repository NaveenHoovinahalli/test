package com.example.samikshe.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewParent;
import android.widget.GridView;

import com.example.samikshe.R;
import com.example.samikshe.adapters.GalleryAdapter;
import com.example.samikshe.adapters.GalleryPagerAdapter;
import com.example.samikshe.adapters.HomePagerAdapter;

/**
 * Created by SCS on 1/22/2016.
 */
public class GalleryPagerMain extends FragmentActivity {

    ViewPager viewPager;
    ScreenSlidePagerAdapter mPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.galerypager);
        viewPager= (ViewPager) findViewById(R.id.galeryPager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mPagerAdapter);
    }



    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
//            return new HomePagerAdapter(imageslink.get(position));

            return new GalleryPagerAdapter(position);

        }

        @Override
        public int getCount() {
//            return imageslink.size();

            return 10;

        }
    }
}
