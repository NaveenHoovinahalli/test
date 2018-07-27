package com.example.samikshe.activity;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.samikshe.R;
import com.example.samikshe.activity.MainActivity;
import com.imanoweb.calendarview.CalendarListener;
import com.imanoweb.calendarview.CustomCalendarView;
import com.imanoweb.calendarview.DayDecorator;
import com.imanoweb.calendarview.DayView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class AttendanceActivity extends Activity{

	CustomCalendarView calendarView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.activity_attendance);
		calendarView= (CustomCalendarView) findViewById(R.id.calendar_view);


//Initialize calendar with date
		Calendar currentCalendar = Calendar.getInstance(Locale.getDefault());

//Show Monday as first date of week
		calendarView.setFirstDayOfWeek(Calendar.MONDAY);

//Show/hide overflow days of a month
		calendarView.setShowOverflowDate(false);

//call refreshCalendar to update calendar the view
		calendarView.refreshCalendar(currentCalendar);
		calendarView.setClickable(false);


//
//		//Handling custom calendar events
//		calendarView.setCalendarListener(new CalendarListener() {
//			@Override
//			public void onDateSelected(Date date) {
//				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//				Toast.makeText(AttendanceActivity.this, df.format(date), Toast.LENGTH_SHORT).show();
//			}
//
//			@Override
//			public void onMonthChanged(Date date) {
//				SimpleDateFormat df = new SimpleDateFormat("MM-yyyy");
//				Toast.makeText(AttendanceActivity.this, df.format(date), Toast.LENGTH_SHORT).show();
//			}
//		});

		//adding calendar day decorators
		List decorators = new ArrayList();
		decorators.add(new DaysDecorate());
		calendarView.setDecorators(decorators);
		calendarView.refreshCalendar(currentCalendar);

//
//		String date="22/01/2015";
//		SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
//
//		try
//		{
//			Date d=dateFormat.parse(date);
//			System.out.println("DATE"+d);
//			System.out.println("Formated"+dateFormat.format(d));
//			calendarView.markDayAsSelectedDay(d);
//		}
//		catch(Exception e)
//		{
//			System.out.println("Excep"+e);
//		}
	}


	private  class DaysDecorate  implements DayDecorator{

		@Override
		public void decorate(DayView dayView) {

//			if(!isPastDay(dayView.getDate())){
////				dayView.setBackgroundColor(getResources().getColor(R.color.disable_color));
//				dayView.setBackgroundColor(Color.RED);
//				Log.d("day","-"+dayView.getDate());
//
//			}


			if(isHoliday(dayView.getDate())){
				dayView.setBackgroundColor(Color.GREEN);
			}else if(isAbsent(dayView.getDate())){
				dayView.setBackgroundColor(Color.RED);

			}
		}

		private boolean isAbsent(Date date) {
			String fDate=new SimpleDateFormat("yyyy-MM-dd").format(date);

			if(fDate.equals("2016-01-12"))
				return true;
			if(fDate.equals("2016-01-02"))
				return true;
			if(fDate.equals("2016-02-06"))
				return true;
			if(fDate.equals("2015-12-12"))
				return true;


			return false;
		}

		private boolean isHoliday(Date date) {
			String fDate=new SimpleDateFormat("yyyy-MM-dd").format(date);
			Log.d("day","--"+fDate);

			if(fDate.equals("2016-01-20"))
				return true;
			if(fDate.equals("2016-01-02"))
				return true;
			if(fDate.equals("2016-02-03"))
				return true;
			if(fDate.equals("2015-12-11"))
				return true;


			return false;
		}


		private boolean isPastDay(Date date) {
			Calendar c = Calendar.getInstance();

			// set the calendar to start of today
			c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			c.set(Calendar.MILLISECOND, 0);

			// and get that as a Date
			Date today = c.getTime();

			// test your condition, if Date specified is before today
			if (date.before(today)) {
				return true;
			}
			return false;
		}
	}

}

