package com.example.samikshe.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.samikshe.R;
import com.example.samikshe.adapters.HomePagerAdapter;

/**
 * Created by SCS on 1/21/2016.
 */
public class PagerMain extends FragmentActivity implements ViewPager.OnPageChangeListener {

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    int pagePosition=0;
    TextView teachers,timetable,gallery,attendance,events,exams,information,remarks,homework;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlayout_withouticons);


        mPager = (ViewPager) findViewById(R.id.pagerforfeed);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setOnPageChangeListener(this);

        teachers= (TextView) findViewById(R.id.teachersButton);
        timetable= (TextView) findViewById(R.id.btnTimeTable);
        gallery= (TextView) findViewById(R.id.btnGallary);
        attendance= (TextView) findViewById(R.id.btnAttendance);
        events= (TextView) findViewById(R.id.btnCEvent);
        exams= (TextView) findViewById(R.id.btnExams);
        information= (TextView) findViewById(R.id.btnInformation);
        remarks= (TextView) findViewById(R.id.btnRemarks);
        homework= (TextView) findViewById(R.id.btnhomework);

//        setAnimation();



    }

    private void setAnimation() {

        Animation fromLeft = AnimationUtils.loadAnimation(this, R.anim.slidefromleft);
        teachers.setAnimation(fromLeft);
        gallery.setAnimation(fromLeft);
        attendance.setAnimation(fromLeft);
        exams.setAnimation(fromLeft);
        homework.setAnimation(fromLeft);



        Animation fromRight = AnimationUtils.loadAnimation(this, R.anim.slidefromright);
        timetable.setAnimation(fromRight);
        events.setAnimation(fromRight);
        information.setAnimation(fromRight);
        remarks.setAnimation(fromRight);





    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        pagePosition=position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
//            return new HomePagerAdapter(imageslink.get(position));

            return new HomePagerAdapter(position);

        }

        @Override
        public int getCount() {
//            return imageslink.size();

            return 2;

        }
    }



    public void onclick(View view){
        String press="";
        switch (view.getId()){
            case R.id.teachersButton:
                startActivity(new Intent(this,TeachersActivity.class));
                press="notification";
                break;
            case R.id.btnAttendance:
//			startActivity(new Intent (this, AttendenceActivity.class));
                startActivity(new Intent (this, AttendanceListActivity.class));
                break;
            case R.id.btnCEvent:
                startActivity(new Intent (this, EventsActivity.class));
                break;
            case R.id.btnInformation:
                startActivity(new Intent (this, InformationActivity.class));
                break;
            case R.id.btnTimeTable:
                startActivity(new Intent (this, TimetableActivity.class));
                break;
            case R.id.btnExams:
                startActivity(new Intent (this, ExamsActivity.class));
                break;
            case R.id.btnhomework:
                startActivity(new Intent (this, HomeWorkActivity.class));
                break;
            case R.id.btnGallary:
//                startActivity(new Intent(this,GalleryActivity.class));
                startActivity(new Intent(this,GalleryPagerMain.class));
                break;
            case R.id.btnRemarks:
                startActivity(new Intent(this,RemarksActivity.class));
                break;
            case R.id.student_iv:
                setDialog(view);
                break;
        }

    }


    private void setDialog(View view) {

        final Dialog dialog=new Dialog(this,R.style.PauseDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.studentdesc);
        ImageView pic= (ImageView) dialog.findViewById(R.id.student_pic);
        TextView name= (TextView) dialog.findViewById(R.id.studentName);
        TextView dob= (TextView) dialog.findViewById(R.id.et_dobe);
        TextView father= (TextView) dialog.findViewById(R.id.et_father);
        TextView contact= (TextView) dialog.findViewById(R.id.et_mobileNo);
        TextView rollNo= (TextView) dialog.findViewById(R.id.rollNo);
        TextView emailid= (TextView) dialog.findViewById(R.id.email_id);
        Button done= (Button) dialog.findViewById(R.id.done_btn);
        TextView address= (TextView) dialog.findViewById(R.id.address);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });



        if(pagePosition==0){
            pic.setImageResource(R.drawable.student1);
            name.setText("Vignesh");
            dob.setText("12-04-2007");
            rollNo.setText("38");
        }else {
            pic.setImageResource(R.drawable.student2);
            name.setText("Jisi");
            dob.setText("11-06-2006");
            rollNo.setText("12");

        }

        father.setText("Sam");
        emailid.setText("abc@abc.com");
        contact.setText("012345678");

        address.setText("no1 \n Karnataka");
        dialog.setTitle(null);

        dialog.show();

    }


}