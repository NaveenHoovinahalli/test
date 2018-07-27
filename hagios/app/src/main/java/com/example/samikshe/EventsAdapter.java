package com.example.samikshe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.samikshe.activity.EventsActivity;

/**
 * Created by SCS on 1/18/2016.
 */
public class EventsAdapter extends BaseAdapter {
    Context context;
    boolean i;
    TextView eventName,eventDate,eventDesc;
    private int lastposition=-1;
    int start=0;
    public EventsAdapter(EventsActivity eventsActivity, boolean i) {

        this.context=eventsActivity;
        this.i=i;
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
        convertView=inflater.inflate(R.layout.event_list_item,null);
        eventName= (TextView) convertView.findViewById(R.id.subject);
        eventDate= (TextView) convertView.findViewById(R.id.startDate);
        eventDesc= (TextView) convertView.findViewById(R.id.details);

        setListValues(position);

//        if(start>2){
            Animation animation = AnimationUtils.loadAnimation(context, (position > lastposition) ? R.anim.listfrombottom : R.anim.listfromtop);
            convertView.startAnimation(animation);
            lastposition = position;
//        }else start++;

        return convertView;
    }

    private void setListValues(int position) {
        String name = null,date = null,details;
        details="Lorem ipsum dolor sit er elit lamet, consectetaur cillium adipisicing pecu, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";


        if(i){
            switch (position){
                case 0:
                    name="PTA Meeting";
                    date="31-05-2016";
                    break;
                case 1:
                    name="Youth Festival";
                    date="23-06-2016";
                    break;
                case 2:
                    name="Sports";
                    date="12-07-2016";
                    break;
                case 3:
                    name="Science-Festival";
                    date="31-05-2016";
                    break;
                case 4:
                    name="PTA Meeting";
                    date="23-08-2016";
                    break;
                case 5:
                    name="Campus Cleaning";
                    date="30-09-2016";
                    break;
                case 6:
                    name="X-Mas Celebration";
                    date="23-12-2016";
                    break;
            }

        }else {
            switch (position){
                case 0:
                    name="New Year";
                    date="1-01-2016";
                    break;
                case 1:
                    name="Ugadi";
                    date="27-03-2016";
                    break;
                case 2:
                    name="Ganesh Chathurthi";
                    date="28-05-2016";
                    break;
                case 3:
                    name="Pooja";
                    date="12-07-2016";
                    break;
                case 4:
                    name="Independence Day";
                    date="15-08-2016";
                    break;
                case 5:
                    name="Gandhi Jayanti";
                    date="30-09-2016";
                    break;
                case 6:
                    name="X-Mas";
                    date="25-12-2016";
                    break;
            }

        }



        eventName.setText(name);
        eventDate.setText(date);
        eventDesc.setText(details);
    }
}
