package com.example.samikshe.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.samikshe.R;


/**
 * Created by SCS on 1/20/2016.
 */
public class TeachersAdapter  extends BaseAdapter{


    int lastposition=-1;
     int strat=0;
    Context context;
    ImageView imageView;
    TextView  tName,tDesignation,tSubject;
    public TeachersAdapter(Context context) {

        this.context=context;


    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.teacher_list_item,null);
        imageView= (ImageView) convertView.findViewById(R.id.teacher_iv);
        tName= (TextView) convertView.findViewById(R.id.teacherName);
        tDesignation= (TextView) convertView.findViewById(R.id.designation);
        tSubject= (TextView) convertView.findViewById(R.id.subject);
        setListValues(position);

        if(strat>10){
            Animation animation = AnimationUtils.loadAnimation(context, (position > lastposition) ? R.anim.listfrombottom : R.anim.listfromtop);
            convertView.startAnimation(animation);
            lastposition = position;
        }else strat++;

          return convertView;
    }

    private void setListValues(int position) {
        switch (position){
            case 0:
                imageView.setImageResource(R.drawable.teacher1);
                tName.setText("Anoop");
                tDesignation.setText("Teacher");
                tSubject.setText("Maths");
                break;
            case 1:
                imageView.setImageResource(R.drawable.teacher2);
                tName.setText("Sushil");
                tDesignation.setText("Teacher");
                tSubject.setText("Kannada");
                break;
            case 2:
                imageView.setImageResource(R.drawable.teacher3);
                tName.setText("Karthik");
                tDesignation.setText("Teacher");
                tSubject.setText("Social science");
                break;
            case 3:
                imageView.setImageResource(R.drawable.teacher4);
                tName.setText("Sahana");
                tDesignation.setText("Teacher");
                tSubject.setText("Biology");
                break;
            case 4:
                imageView.setImageResource(R.drawable.teacher5);
                tName.setText("Venkat");
                tDesignation.setText("Teacher");
                tSubject.setText("Physics");
                break;
            case 5:
                imageView.setImageResource(R.drawable.teacher6);
                tName.setText("Aswin");
                tDesignation.setText("Teacher");
                tSubject.setText("English");
                break;
            case 6:
                imageView.setImageResource(R.drawable.teacher7);
                tName.setText("Naveen");
                tDesignation.setText("Teacher");
                tSubject.setText("Maths");
                break;

        }

    }

}
