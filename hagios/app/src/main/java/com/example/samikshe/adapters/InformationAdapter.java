package com.example.samikshe.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.samikshe.R;


/**
 * Created by SCS on 1/20/2016.
 */
public class InformationAdapter extends BaseAdapter {


    int lastposition=-1;
    Context context;
    TextView informationTopic,informationDetails;
    public InformationAdapter(Context context) {

        this.context=context;

    }

    @Override
    public int getCount() {
        return 6;
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
    public View getView(final int position, View convertView, final ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.information_list_item,null);
        informationTopic= (TextView) convertView.findViewById(R.id.informationtopic);
        informationDetails= (TextView) convertView.findViewById(R.id.informationDesc);

        convertView.setId(position);
        setListValues(position);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callUrl(position);
            }
        });

//        Animation animation = AnimationUtils.loadAnimation(context, (position > lastposition) ? R.anim.listfrombottom : R.anim.listfromtop);
//        convertView.startAnimation(animation);
//        lastposition = position;

        return convertView;
    }

    private void callUrl(int position) {
        String url = null;
        if(position==0){
            url="https://www.scholarships.gov.in/main.do";
        }else if(position==1){
            url="http://booksy.in/2013/11/14/national-book-week-celebrations-begin-across-the-country-3/";
        }else if(position==2){
            url="http://www.teachersbadi.in/2015/05/navodaya-entrance-exam2016-jnvs-entrance-test2016-jnvs-selection-test-2016-nvshq-org.html";
        }else if(position==3){
            url="http://schoolcountry.com/blog/post/2011/09/15/10-scholarship-programs-for-school-students-in-india.aspx";
        }else if(position==4){
            url="https://www.toppr.com/bytes/competitive-exam-list/";
        }else if(position==5){
            url="http://kidsactivitiesblog.com/51671/summer-camp-activities";
        }



        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(myIntent);
    }

    private void setListValues(int position) {

        if(position==0){
            informationTopic.setText("Scholarships");
            informationDetails.setText("National Scholarships Portal is one stop solution for end to end scholarship process..");
        }else if(position==1){
            informationTopic.setText("National Book Week");
            informationDetails.setText("National Book Week celebrations begin across the country");
        }else if(position==2){
            informationTopic.setText("Navodaya Entrance Exam 2017 Notification");
            informationDetails.setText("Navodaya Entrance Exam 2017 Notification for admission into navodaya schools. ...");
        }else if(position==3){
            informationTopic.setText("12 prestigious scholarship");
            informationDetails.setText(" programs for school students - See more at:....");

        }else if(position==4){
            informationTopic.setText("Competitive exams");
            informationDetails.setText("List of competitive exams for school students");

        }else if(position==5){
            informationTopic.setText("Summer Camp");
            informationDetails.setText("50+ Summer camp-inspired activities for kids");

        }

    }

}
