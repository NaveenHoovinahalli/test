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
public class HomeworkAdapter extends BaseAdapter{

    int lastposition=-1;
    Context context;
    TextView subject,date,details;
    private int start=0;

    public HomeworkAdapter(Context context) {

        this.context=context;

    }

    @Override
    public int getCount() {
        return 12;
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
        convertView=inflater.inflate(R.layout.homework_list_item,null);
        subject= (TextView) convertView.findViewById(R.id.subject);
        date= (TextView) convertView.findViewById(R.id.startnendDate);
        details= (TextView) convertView.findViewById(R.id.details);

        setListValues(position);

        if(start>14){
            Animation animation = AnimationUtils.loadAnimation(context, (position > lastposition) ? R.anim.listfrombottom : R.anim.listfromtop);
            convertView.startAnimation(animation);
            lastposition = position;
        }else start++;



        return convertView;
    }

        private void setListValues(int position) {
            if(position==0){
                subject.setText("Maths");
                date.setText("07-03-2016::08-03-2016");
                details.setText("Solve the problems of Lesson 12 ");
            }else if(position==1){
                subject.setText("English");
                date.setText("07-03-2016::08-03-2016");
                details.setText("Complete the grammar of Lesson 5");
            }else if(position==2){
                subject.setText("Kannada");
                date.setText("07-03-2016::08-03-2016");
                details.setText("Answer the questions of lesson 6");
            }else if(position==3){
                subject.setText("Social");
                date.setText("07-03-2016::08-03-2016");
                details.setText("Draw the India Map");
            }else if(position==4){
                subject.setText("Science");
                date.setText("07-03-2016::08-03-2016");
                details.setText("Create a methane model ");
            }else if(position==5){
                subject.setText("Hindi");
                date.setText("07-03-2016::08-03-2016");
                details.setText("Write the poem 3 ");
            }else if(position==6){
                subject.setText("English");
                date.setText("07-03-2016::08-03-2016");
                details.setText("Write 2 pages of copy writing");
            }else if(position==7){
                subject.setText("Kannada");
                date.setText("07-03-2016::08-03-2016");
                details.setText("Write 2 pages of copy writing");
            }else if(position==8){
                subject.setText("Hindi");
                date.setText("07-03-2016::08-03-2016");
                details.setText("Write the poem 3 ");
            }else if(position==9){
                subject.setText("English");
                date.setText("07-03-2016::08-03-2016");
                details.setText("Write 2 pages of copy writing");
            }else if(position==10){
                subject.setText("Kannada");
                date.setText("07-03-2016::08-03-2016");
                details.setText("Write 2 pages of copy writing");
            }


        }

}
