package com.example.samikshe.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.samikshe.R;


/**
 * Created by SCS on 1/20/2016.
 */
public class RemarksAdapter extends BaseAdapter{


    int lastposition=-1;
    Context context;
    TextView from,desc,date;
    public RemarksAdapter(Context context) {

        this.context=context;

    }

    @Override
    public int getCount() {
        return 3;
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
        convertView=inflater.inflate(R.layout.remarks_list_item,null);
        from= (TextView) convertView.findViewById(R.id.teacherName);
        desc= (TextView) convertView.findViewById(R.id.descp);
        date= (TextView) convertView.findViewById(R.id.dateofentry);

        setListValues(position);
//        Animation animation = AnimationUtils.loadAnimation(context, (position > lastposition) ? R.anim.listfrombottom : R.anim.listfromtop);
//        convertView.startAnimation(animation);
//        lastposition = position;
        return convertView;
    }

    private void setListValues(int position) {
        if(position==0){
            from.setText("Maths Teacher");
                date.setText("04-03-2016");
            desc.setText("He is very week in maths subject,Need to improve a lot");
        }else if(position==1){
                from.setText("English Teacher");
                date.setText("29-02-2016");
                desc.setText("He is improving in English,");
        }else if(position==2){
            from.setText("Class Teacher");
            date.setText("15-02-2016");
            desc.setText("He is coming very late to class and we got complaint from few teachers,Please send him on time");
        }
    }
}
