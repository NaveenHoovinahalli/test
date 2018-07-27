package com.example.samikshe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.widget.Toast;

public class DatabaseHandler extends SQLiteOpenHelper {
	private static String DATABASE_NAME = Environment.getExternalStorageDirectory() + "/ADDGPSTracking/ADDGPSTracking.db";
	private static String TABLE_NAME1 = "DevicePerimeter";
	private static int version = 1;
	private static String TABLE_NAME1_ID = "id";
	private static String TABLE_NAME1_DeviceID = "DeviceID";
	private static String TABLE_NAME1_DeviceName = "DeviceName";
	private static String TABLE_NAME1_PerimeterID = "PerimeterID";
	private static String TABLE_NAME1_PerimeterLatLong = "PerimeterLatLong";
	private static String TABLE_NAME1_PerimeterRadius = "PerimeterRadius";
	private static String TABLE_NAME1_DeleteStatus = "DeleteStatus";
	private static String TABLE_NAME1_DeviceLatitude = "DeviceLatitude";
	private static String TABLE_NAME1_DeviceLongitude = "DeviceLongitude";
	private static String TABLE_NAME1_UpdateTime = "UpdateTime";
	private static String TABLE_NAME1_Direction = "Direction";
	private static String TABLE_NAME1_Name = "Name";

	private static String TABLE_NAME2 = "TravelInfo";
	private static String TABLE_NAME2_ID = "ID";
	private static String TABLE_NAME2_Latitude = "Latitude";
	private static String TABLE_NAME2_Longitude = "Longitude";
	private static String TABLE_NAME2_DeviceID = "DeviceID";
	private static String TABLE_NAME2_DeviceName = "DeviceName";
	private static String TABLE_NAME2_UpdateDateTime = "UpdateDateTime";
	private static String TABLE_NAME2_UpdateFromServer = "UpdateFromServer";

	private Context dgcontext;

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, version);
		dgcontext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try{
		Toast.makeText(dgcontext, "creating table", Toast.LENGTH_LONG).show();
		String lQuery = "CREATE TABLE  DevicePerimeter ("
				+ "ID               INTEGER        PRIMARY KEY AUTOINCREMENT,"
				+ "DeviceID         INTEGER,"
				+ "DeviceName       VARCHAR (100),"
				+ "PerimeterID      INTEGER,"
				+ "PerimeterLatLong VARCHAR (250),"
				+ "PerimeterRadius  DOUBLE (18, 9),"
				+ "DeleteStatus     BOOLEAN,"
				+ "DeviceLatitude   DOUBLE (18, 9),"
				+ "DeviceLongitude  DOUBLE (18, 9),"
				+ "UpdateTime		  DATETIME," + "Direction        VARCHAR (20) ,"
				+ "Name        VARCHAR (100))";
		db.execSQL(lQuery);
		lQuery = "CREATE TABLE   TravelInfo("
				+ " ID               INTEGER        PRIMARY KEY AUTOINCREMENT,"
				+ "	Latitude         DOUBLE (18, 9),"
				+ "	Longitude        DOUBLE (18, 9),"
				+ "	DeviceID         INTEGER,"
				+ "	DeviceName       VARCHAR (250),"
				+ "	UpdateDateTime   DATETIME," + "	UpdateFromServer DATETIME)";
		db.execSQL(lQuery);
		}catch(Exception ex){
			Toast.makeText(dgcontext, ex.getMessage(), Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Toast.makeText(dgcontext, "updating table", Toast.LENGTH_LONG).show();
		String sqlCmd = "drop table if exists DevicePerimeter";
		db.execSQL(sqlCmd);
		sqlCmd = "drop table if exists TravelInfo";
		db.execSQL(sqlCmd);
		onCreate(db);

	}
//	public void addPerimeter (DevicePerimeter perimeter){
//		try{
//		SQLiteDatabase db=this.getWritableDatabase();
//		ContentValues values=new ContentValues();
//		values.put(TABLE_NAME1_DeviceID, perimeter.getDeviceID());
//		values.put(TABLE_NAME1_DeviceName,perimeter.getDeviceName());
//		values.put(TABLE_NAME1_PerimeterID, perimeter.getPerimeterID());//not required
//		values.put(TABLE_NAME1_PerimeterLatLong, perimeter.getPerimeterLatLong());
//		values.put(TABLE_NAME1_PerimeterRadius, perimeter.getPerimeterRadius());
//		values.put(TABLE_NAME1_DeviceLatitude, perimeter.getDeviceLatitude());
//		values.put(TABLE_NAME1_DeviceLongitude, perimeter.getDeviceLongitude());
//		values.put(TABLE_NAME1_UpdateTime, perimeter.getUpdateTime());
//		values.put(TABLE_NAME1_Direction,perimeter.getDirection());
//		values.put(TABLE_NAME1_Name, perimeter.getName());
//		values.put(TABLE_NAME1_DeleteStatus, perimeter.getDeleteStatus());
//		long i= db.insert(TABLE_NAME1, null, values);
//		db.close();
//		}catch(Exception ex){
//			Toast.makeText(dgcontext,ex.getMessage(), Toast.LENGTH_LONG).show();
//		}
//	}
	
	public void updatePerimeter(DevicePerimeter perimeter,String where,String[]con){
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues values=new ContentValues();
		values.put(TABLE_NAME1_DeviceID, perimeter.getDeviceID());
		values.put(TABLE_NAME1_DeviceName,perimeter.getDeviceName());
		values.put(TABLE_NAME1_PerimeterID, perimeter.getPerimeterID());//not required
		values.put(TABLE_NAME1_PerimeterLatLong, perimeter.getPerimeterLatLong());
		values.put(TABLE_NAME1_PerimeterRadius, perimeter.getPerimeterRadius());
		values.put(TABLE_NAME1_DeviceLatitude, perimeter.getDeviceLatitude());
		values.put(TABLE_NAME1_DeviceLongitude, perimeter.getDeviceLongitude());
		values.put(TABLE_NAME1_UpdateTime, perimeter.getUpdateTime());
		values.put(TABLE_NAME1_Direction,perimeter.getDirection());
		values.put(TABLE_NAME1_Name, perimeter.getName());
		values.put(TABLE_NAME1_DeleteStatus, perimeter.getDeleteStatus());
		int i=	db.update(TABLE_NAME1, values, where, con);
	}
	
	public void deletePerimeter(String where,String[]con){
		SQLiteDatabase db=this.getWritableDatabase();
		int i=	db.delete(TABLE_NAME1, where, con);
	}
	
	public Cursor selectPerimeter(String query){
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor lCursor= db.rawQuery(query, null);
		return lCursor;
	}
	
	public void updateDb(String query){
		SQLiteDatabase db=this.getReadableDatabase();
		db.execSQL(query);
	}
}
