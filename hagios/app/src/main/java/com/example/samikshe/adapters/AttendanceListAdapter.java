package com.example.samikshe.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.samikshe.R;


/**
 * Created by SCS on 1/20/2016.
 */
public class AttendanceListAdapter extends BaseAdapter{


    Context context;
    TextView month,days,present,absent,holidays;
    public AttendanceListAdapter(Context context) {

        this.context=context;

    }

    @Override
    public int getCount() {
        return 13;
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
        convertView=inflater.inflate(R.layout.attendance_list_item,null);


        month= (TextView) convertView.findViewById(R.id.month);
        days= (TextView) convertView.findViewById(R.id.days);
        present= (TextView) convertView.findViewById(R.id.present);
        absent= (TextView) convertView.findViewById(R.id.absent);
        holidays= (TextView) convertView.findViewById(R.id.holidays);
        String month1,days1,absent1,present1,holidays1;

        if(position==1){
            month1="JUN";days1="30";present1="20";absent1="2";holidays1="2";
        }else if(position==2){
            convertView.setBackgroundColor(context.getResources().getColor(R.color.gray_divider));
            month1="JULY";days1="31";present1="20";absent1="2";holidays1="2";
        }else if(position==3){
            month1="AUG";days1="31";present1="20";absent1="2";holidays1="2";
        }else if(position==4){
            convertView.setBackgroundColor(context.getResources().getColor(R.color.gray_divider));
            month1="SEP";days1="30";present1="20";absent1="2";holidays1="2";
        }else if(position==5){
            month1="OCT";days1="31";present1="20";absent1="2";holidays1="2";
        }else if(position==6){
            convertView.setBackgroundColor(context.getResources().getColor(R.color.gray_divider));
            month1="NOV";days1="30";present1="20";absent1="2";holidays1="2";
        }else if(position==7){
            month1="DEC";days1="31";present1="20";absent1="2";holidays1="2";
        }else if(position==8){
            convertView.setBackgroundColor(context.getResources().getColor(R.color.gray_divider));
            month1="JAN";days1="30";present1="26";absent1="0";holidays1="0";
        }else if(position==9){
            month1="FEB";days1="28";present1="18";absent1="2";holidays1="2";
        }else if(position==10){
            convertView.setBackgroundColor(context.getResources().getColor(R.color.gray_divider));
            month1="MAR";days1="30";present1="22";absent1="2";holidays1="2";
        }else if(position==11){
            month1="APR";days1="31";present1="0";absent1="0";holidays1="31";
        }else if(position==12){
            convertView.setBackgroundColor(context.getResources().getColor(R.color.gray_divider));
            month1="MAY";days1="30";present1="0";absent1="0";holidays1="31";
        }else {
            convertView.setBackgroundColor(context.getResources().getColor(R.color.gray_divider));
            month1="MONTHS";days1="DAYS";present1="PRESENT";absent1="ABSENT";holidays1="HOLIDAYS";

        }


        if(position==0) {
            convertView.setBackgroundColor(context.getResources().getColor(R.color.white));
            month.setTextColor(context.getResources().getColor(R.color.apptheame));
            days.setTextColor(context.getResources().getColor(R.color.apptheame));
            present.setTextColor(context.getResources().getColor(R.color.apptheame));
            absent.setTextColor(context.getResources().getColor(R.color.apptheame));
            holidays.setTextColor(context.getResources().getColor(R.color.apptheame));

        }

        month.setText(month1);
        days.setText(days1);
        present.setText(present1);
        absent.setText(absent1);
        holidays.setText(holidays1);


        return convertView;
    }
}
