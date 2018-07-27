package com.example.samikshe.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.samikshe.R;
import com.example.samikshe.adapters.ExpandableListAdapterExamsTable;
import com.example.samikshe.adapters.ExpandableListAdapterMarksTable;
import com.example.samikshe.models.Exams;
import com.example.samikshe.models.Marks;
import com.example.samikshe.utils.AnimatedExpandableListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * Created by SCS on 1/20/2016.
 */
public class ExamsActivity extends Activity implements ExpandableListView.OnGroupClickListener,ExpandableListView.OnChildClickListener,ExpandableListView.OnGroupExpandListener, View.OnClickListener {

    ExpandableListAdapterExamsTable listAdapter;
    ExpandableListAdapterMarksTable listAdapterMarks;
    AnimatedExpandableListView expListView;//Should use custom view
    List<String> listDataHeader,listDataHeaderMarks;
    HashMap<String, List<Marks>> listDataChildMarks;
    HashMap<String, List<Exams>> listDataChild;
    private int lastExpandedPosition = -1;
    TextView examsTV,marksTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.exams);

        examsTV= (TextView) findViewById(R.id.examsClicked);
        marksTV= (TextView) findViewById(R.id.marksClicked);
        examsTV.setOnClickListener(this);
        marksTV.setOnClickListener(this);

        // get the listview
        expListView = (AnimatedExpandableListView) findViewById(R.id.lvExpexam);

        // preparing list data
        prepareListDataExams();

        prepareListDataMarks();

        setList(true);

        expListView.setOnGroupClickListener(this);

        examsTV.setBackgroundResource(R.drawable.leftradiousblue);
        examsTV.setTextColor(Color.WHITE);
        marksTV.setBackgroundResource(R.drawable.rightradious);
        marksTV.setTextColor(getResources().getColor(R.color.apptheame));


    }

    @Override
    protected void onResume() {
        super.onResume();

   }

    private int getCurrrentDay() {
        Calendar calendar=Calendar.getInstance();
        int day=calendar.get(Calendar.DAY_OF_WEEK);

        return day;
    }

    private void prepareListDataExams() {

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<Exams>>();

        // Adding child data
        listDataHeader.add("1st Test");
        listDataHeader.add("2nd Test");
        listDataHeader.add("Final Exam");



        // Adding child data
        List<Exams> test1 = new ArrayList<Exams>();
        Exams examsS0=new Exams();
        examsS0.setSubject("Subject");
        examsS0.setDate("Date");
        examsS0.setStartTime("Start Time");
        examsS0.setEndTime("End Time");
        test1.add(examsS0);

        Exams examsS1=new Exams();
        examsS1.setSubject("Kannada");
        examsS1.setDate("28-11-2015");
        examsS1.setStartTime("10:00AM");
        examsS1.setEndTime("11:00AM");
        test1.add(examsS1);
        Exams examsS2=new Exams();
        examsS2.setSubject("English");
        examsS2.setDate("28-11-2015");
        examsS2.setStartTime("12:00PM");
        examsS2.setEndTime("01:00PM");
        test1.add(examsS2);
        Exams examsS3=new Exams();
        examsS3.setSubject("Maths");
        examsS3.setDate("28-11-2015");
        examsS3.setStartTime("02:00PM");
        examsS3.setEndTime("03:00PM");
        test1.add(examsS3);
        Exams examsS4=new Exams();
        examsS4.setSubject("Science");
        examsS4.setDate("29-11-2015");
        examsS4.setStartTime("10:00AM");
        examsS4.setEndTime("11:00AM");
        test1.add(examsS4);
        Exams examsS5=new Exams();
        examsS5.setSubject("Social");
        examsS5.setDate("28-11-2015");
        examsS5.setStartTime("12:00PM");
        examsS5.setEndTime("12:00PM");
        test1.add(examsS5);



        List<Exams> test2 = new ArrayList<Exams>();
         test2.add(examsS0);

        Exams exams1S1=new Exams();
        exams1S1.setSubject("Kannada");
        exams1S1.setDate("31-12-2015");
        exams1S1.setStartTime("10:00AM");
        exams1S1.setEndTime("11:00AM");
        test2.add(exams1S1);
        Exams exams1S2=new Exams();
        exams1S2.setSubject("English");
        exams1S2.setDate("31-12-2015");
        exams1S2.setStartTime("12:00PM");
        exams1S2.setEndTime("01:00PM");
        test2.add(exams1S2);
        Exams exams1S3=new Exams();
        exams1S3.setSubject("Maths");
        exams1S3.setDate("31-12-2015");
        exams1S3.setStartTime("02:00PM");
        exams1S3.setEndTime("03:00PM");
        test2.add(exams1S3);
        Exams exams1S4=new Exams();
        exams1S4.setSubject("Science");
        exams1S4.setDate("1-1-2016");
        exams1S4.setStartTime("10:00AM");
        exams1S4.setEndTime("11:00AM");
        test2.add(exams1S4);
        Exams exams1S5=new Exams();
        exams1S5.setSubject("Social");
        exams1S5.setDate("1-1-2016");
        exams1S5.setStartTime("12:00PM");
        exams1S5.setEndTime("12:00PM");
        test2.add(exams1S5);


        List<Exams> test3 = new ArrayList<Exams>();
        test3.add(examsS0);

        Exams exams2S1=new Exams();
        exams2S1.setSubject("Kannada");
        exams2S1.setDate("29-02-2016");
        exams2S1.setStartTime("10:00AM");
        exams2S1.setEndTime("01:00PM");
        test3.add(exams2S1);
        Exams exams2S2=new Exams();
        exams2S2.setSubject("English");
        exams2S2.setDate("01-03-2016");
        exams2S2.setStartTime("10:00AM");
        exams2S2.setEndTime("01:00PM");
        test3.add(exams2S2);
        Exams exams2S3=new Exams();
        exams2S3.setSubject("Maths");
        exams2S3.setDate("01-03-2016");
        exams2S3.setStartTime("10:00AM");
        exams2S3.setEndTime("01:00PM");
        test3.add(exams2S3);
        Exams exams2S4=new Exams();
        exams2S4.setSubject("Science");
        exams2S4.setDate("01-03-2016");
        exams2S4.setStartTime("10:00AM");
        exams2S4.setEndTime("01:00PM");
        test3.add(exams2S4);
        Exams exams2S5=new Exams();
        exams2S5.setSubject("Social");
        exams2S5.setDate("01-03-2016");
        exams2S5.setStartTime("10:00AM");
        exams2S5.setEndTime("01:00PM");
        test3.add(exams2S5);

        listDataChild.put(listDataHeader.get(0), test1); // Header, Child data
        listDataChild.put(listDataHeader.get(1), test2);
        listDataChild.put(listDataHeader.get(2), test3);

    }

    /*
     * Preparing the list data
     */
    private void prepareListDataMarks() {
        listDataHeaderMarks = new ArrayList<String>();
        listDataChildMarks = new HashMap<String, List<Marks>>();

        // Adding child data
        listDataHeaderMarks.add("1st Test");
        listDataHeaderMarks.add("2nd Test");
        listDataHeaderMarks.add("Final Exam");



        // Adding child data
        List<Marks> test1 = new ArrayList<Marks>();

        Marks marks0S1=new Marks();
        marks0S1.setSubject("Subject");
        marks0S1.setMaximumMarks("Maximum");
        marks0S1.setObtainedMarks("Obtained");
        marks0S1.setGrade("Grade");
        test1.add(marks0S1);

         Marks marksS1=new Marks();
        marksS1.setSubject("Kannada");
        marksS1.setMaximumMarks("25");
        marksS1.setObtainedMarks("23");
        marksS1.setGrade("A");
        test1.add(marksS1);

        Marks marksS2=new Marks();
        marksS2.setSubject("English");
        marksS2.setMaximumMarks("25");
        marksS2.setObtainedMarks("20");
        marksS2.setGrade("A");
        test1.add(marksS2);

        Marks marksS3=new Marks();
        marksS3.setSubject("Maths");
        marksS3.setMaximumMarks("25");
        marksS3.setObtainedMarks("20");
        marksS3.setGrade("A");
        test1.add(marksS3);

        Marks marksS4=new Marks();
        marksS4.setSubject("Social");
        marksS4.setMaximumMarks("25");
        marksS4.setObtainedMarks("18");
        marksS4.setGrade("B");
        test1.add(marksS4);

        Marks marksS5=new Marks();
        marksS5.setSubject("Science");
        marksS5.setMaximumMarks("25");
        marksS5.setObtainedMarks("19");
        marksS5.setGrade("B");
        test1.add(marksS5);

        Marks marksS6=new Marks();
        marksS6.setSubject("Total");
        marksS6.setMaximumMarks("125");
        marksS6.setObtainedMarks("100");
        marksS6.setGrade("B+");
        test1.add(marksS6);
        ///two

        List<Marks> test2 = new ArrayList<Marks>();
        test2.add(marks0S1);
        Marks marks1S1=new Marks();
        marks1S1.setSubject("Kannada");
        marks1S1.setMaximumMarks("25");
        marks1S1.setObtainedMarks("23");
        marks1S1.setGrade("A");
        test2.add(marks1S1);

        Marks marks1S2=new Marks();
        marks1S2.setSubject("English");
        marks1S2.setMaximumMarks("25");
        marks1S2.setObtainedMarks("20");
        marks1S2.setGrade("A");
        test2.add(marks1S2);

        Marks marks1S3=new Marks();
        marks1S3.setSubject("Maths");
        marks1S3.setMaximumMarks("25");
        marks1S3.setObtainedMarks("20");
        marks1S3.setGrade("A");
        test2.add(marks1S3);

        Marks marks1S4=new Marks();
        marks1S4.setSubject("Social");
        marks1S4.setMaximumMarks("25");
        marks1S4.setObtainedMarks("18");
        marks1S4.setGrade("B");
        test2.add(marks1S4);

        Marks marks1S5=new Marks();
        marks1S5.setSubject("Science");
        marks1S5.setMaximumMarks("25");
        marks1S5.setObtainedMarks("19");
        marks1S5.setGrade("B");
        test2.add(marks1S5);

        Marks marks1S6=new Marks();
        marks1S6.setSubject("Total");
        marks1S6.setMaximumMarks("125");
        marks1S6.setObtainedMarks("100");
        marks1S6.setGrade("B+");
        test2.add(marks1S6);

        //three
        List<Marks> test3 = new ArrayList<Marks>();
        test3.add(marks0S1);

        Marks marks2S1=new Marks();
        marks2S1.setSubject("Kannada");
        marks2S1.setMaximumMarks("100");
        marks2S1.setObtainedMarks("90");
        marks2S1.setGrade("A");
        test3.add(marks2S1);

        Marks marks2S2=new Marks();
        marks2S2.setSubject("English");
        marks2S2.setMaximumMarks("100");
        marks2S2.setObtainedMarks("92");
        marks2S2.setGrade("A");
        test3.add(marks2S2);

        Marks marks2S3=new Marks();
        marks2S3.setSubject("Maths");
        marks2S3.setMaximumMarks("100");
        marks2S3.setObtainedMarks("93");
        marks2S3.setGrade("A");
        test3.add(marks2S3);

        Marks marks2S4=new Marks();
        marks2S4.setSubject("Social");
        marks2S4.setMaximumMarks("100");
        marks2S4.setObtainedMarks("80");
        marks2S4.setGrade("B");
        test3.add(marks2S4);

        Marks marks2S5=new Marks();
        marks2S5.setSubject("Science");
        marks2S5.setMaximumMarks("100");
        marks2S5.setObtainedMarks("85");
        marks2S5.setGrade("B");
        test3.add(marks2S5);

        Marks marks2S6=new Marks();
        marks2S6.setSubject("Total");
        marks2S6.setMaximumMarks("500");
        marks2S6.setObtainedMarks("440");
        marks2S6.setGrade("B+");
        test3.add(marks2S6);

        listDataChildMarks.put(listDataHeaderMarks.get(0), test1); // Header, Child data
        listDataChildMarks.put(listDataHeaderMarks.get(1), test2);
        listDataChildMarks.put(listDataHeaderMarks.get(2), test3);


    }

    @Override
    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {


        if(lastExpandedPosition != -1 && groupPosition != lastExpandedPosition) {
            expListView.collapseGroupWithAnimation(lastExpandedPosition);
        }
        lastExpandedPosition=groupPosition;

        if (expListView.isGroupExpanded(groupPosition)) {
            expListView.collapseGroupWithAnimation(groupPosition);
        } else {
            expListView.expandGroupWithAnimation(groupPosition);
        }
        return true;//should return true if animation class is handling the values
    }


    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        return false;
    }

    @Override
    public void onGroupExpand(int groupPosition) {
        if(lastExpandedPosition != -1 && groupPosition != lastExpandedPosition) {
            expListView.collapseGroupWithAnimation(lastExpandedPosition);
        }
        lastExpandedPosition=groupPosition;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.examsClicked) {
            examsTV.setBackgroundResource(R.drawable.leftradiousblue);
            examsTV.setTextColor(Color.WHITE);
            marksTV.setBackgroundResource(R.drawable.rightradious);
            marksTV.setTextColor(getResources().getColor(R.color.apptheame));

            setList(true);
        } else {
            examsTV.setBackgroundResource(R.drawable.leftradious);
            examsTV.setTextColor(getResources().getColor(R.color.apptheame));
            marksTV.setBackgroundResource(R.drawable.rightradiousblue);
            marksTV.setTextColor(Color.WHITE);
            setList(false);

        }

    }


    private void setList(boolean b) {
        if (b) {

            listAdapter = new ExpandableListAdapterExamsTable(this, listDataHeader, listDataChild);

            // setting list adapter
            expListView.setAdapter(listAdapter);
//            expListView.expandGroupWithAnimation(listDataHeader.size()-1);

        } else {

            listAdapterMarks = new ExpandableListAdapterMarksTable(this, listDataHeaderMarks, listDataChildMarks);
            // setting list adapter
            expListView.setAdapter(listAdapterMarks);
//            expListView.expandGroupWithAnimation(listDataHeaderMarks.size()-1);

        }
    }


}
