package com.example.samikshe.adapters;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.samikshe.R;
import com.example.samikshe.activity.AttendanceActivity;
import com.example.samikshe.activity.EventsActivity;
import com.example.samikshe.activity.ExamsActivity;
import com.example.samikshe.activity.HomeWorkActivity;
import com.example.samikshe.activity.StudentMarksActivity;
import com.example.samikshe.activity.TeachersActivity;
import com.example.samikshe.activity.TimetableActivity;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by SCS on 1/21/2016.
 */
public class HomePagerAdapter extends android.support.v4.app.Fragment  {

    View view;
    int position;
    TextView txt,tvSchool,tvclass;
    CircleImageView circleImageView;
    ImageView logo;



    @SuppressLint("ValidFragment")
    public HomePagerAdapter(int position) {
        this.position=position;
    }

   public  HomePagerAdapter()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.pageritem,container,false);
        txt= (TextView) view.findViewById(R.id.txtName);
        tvSchool= (TextView) view.findViewById(R.id.school);
        tvclass= (TextView) view.findViewById(R.id.txtclass);
        circleImageView= (CircleImageView) view.findViewById(R.id.student_iv);
        logo= (ImageView) view.findViewById(R.id.schoollogo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"This will redirect to School website",Toast.LENGTH_SHORT).show();
            }
        });
        return view;


    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(position==0) {
            txt.setText("Vignesh");
            tvSchool.setText("My School 1");
            tvclass.setText("4th-B");
            circleImageView.setImageResource(R.drawable.student1);
        } else if(position==1) {
            txt.setText("Jisi");
            tvclass.setText("5th-A");
            circleImageView.setImageResource(R.drawable.student2);
        }

    }


//    public void onclick(View view){
//        String press="";
//        switch (view.getId()){
//            case R.id.teachersButton:
//                startActivity(new Intent(getActivity(),TeachersActivity.class));
//                press="notification";
//                break;
//            case R.id.btnAttendance:
////			startActivity(new Intent (this, AttendenceActivity.class));
//                startActivity(new Intent (getActivity(), AttendanceActivity.class));
//                break;
//            case R.id.btnCEvent:
//                startActivity(new Intent (getActivity(), EventsActivity.class));
//                break;
//            case R.id.btnExams:
//                startActivity(new Intent (getActivity(), ExamsActivity.class));
//                break;
//            case R.id.btnTimeTable:
//                startActivity(new Intent (getActivity(), TimetableActivity.class));
//                break;
//            case R.id.btnMarks:
//                startActivity(new Intent (getActivity(), StudentMarksActivity.class));
//                break;
//            case R.id.btnhomework:
//                startActivity(new Intent (getActivity(), HomeWorkActivity.class));
//                break;
//            case R.id.btnGallary:
//                Log.d("dialog","dialog");
//                press="btnGallary";
//                break;
//            case R.id.student_iv:
//                Log.d("dialog","dialog");
//                setDialog(view);
//                break;
//        }
//
//    }

    private void setDialog(View view) {

        Log.d("dialog","dialog");
        Dialog dialog=new Dialog(getActivity());
        dialog.setContentView(R.layout.studentdesc);
        dialog.show();

    }
}
