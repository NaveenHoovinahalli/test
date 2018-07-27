package com.example.samikshe.adapters;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.samikshe.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by SCS on 1/21/2016.
 */
public class GalleryPagerAdapter extends android.support.v4.app.Fragment  {

    View view;
    int position;
    TextView txt,tvSchool,tvclass;
    ImageView imageView;



    @SuppressLint("ValidFragment")
    public GalleryPagerAdapter(int position) {
        this.position=position;
    }

   public GalleryPagerAdapter()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.gallerypageritem,container,false);
        imageView= (ImageView) view.findViewById(R.id.imagegal);
        return view;


    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(position==0) {
            imageView.setImageResource(R.drawable.b);
        }else if(position==1){
            imageView.setImageResource(R.drawable.c);
        }else if(position==2){
            imageView.setImageResource(R.drawable.d);
        }else if(position==3){
            imageView.setImageResource(R.drawable.e);
        }else if(position==4){
            imageView.setImageResource(R.drawable.f);
        }else if(position==5){
            imageView.setImageResource(R.drawable.g);
        }else if(position==6){
            imageView.setImageResource(R.drawable.h);
        }else if(position==7){
            imageView.setImageResource(R.drawable.i);
        }else if(position==8){
            imageView.setImageResource(R.drawable.j);
        }else if(position==9){
            imageView.setImageResource(R.drawable.k);
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
