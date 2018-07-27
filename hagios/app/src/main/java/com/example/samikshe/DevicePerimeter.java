package com.example.samikshe;



public class DevicePerimeter {
private int ID,DeviceID,PerimeterID;
private String DeviceName,PerimeterLatLong,UpdateTime,Direction,Name;
private boolean DeleteStatus;
private double DeviceLatitude,DeviceLongitude,PerimeterRadius;

public void setID(int iD) {
	ID = iD;
}
public void setDeviceID(int deviceID) {
	DeviceID = deviceID;
}
public void setPerimeterID(int perimeterID) {
	PerimeterID = perimeterID;
}
public void setDeviceName(String deviceName) {
	DeviceName = deviceName;
}
public void setPerimeterLatLong(String perimeterLatLong) {
	PerimeterLatLong = perimeterLatLong;
}
public void setPerimeterRadius(double perimeterRadius) {
	PerimeterRadius = perimeterRadius;
}
public void setUpdateTime(String updateTime) {
	UpdateTime = updateTime;
}
public void setDirection(String direction) {
	Direction = direction;
}
public void setName(String name) {
	Name = name;
}
public void setDeleteStatus(boolean deleteStatus) {
	DeleteStatus = deleteStatus;
}
public void setDeviceLatitude(double deviceLatitude) {
	DeviceLatitude = deviceLatitude;
}
public void setDeviceLongitude(double deviceLongitude) {
	DeviceLongitude = deviceLongitude;
}



      
public int getID(){
	return this.ID;
}
public int getDeviceID(){
	return this.DeviceID;
}
public int getPerimeterID(){
	return this.PerimeterID;
}
public String getPerimeterLatLong(){
	return this.PerimeterLatLong;
}

public String getDeviceName(){
	return this.DeviceName;
}
public double getPerimeterRadius(){
	return this.PerimeterRadius;
}
public String getUpdateTime(){
	return this.UpdateTime;
}

public String getDirection(){
	return this.Direction;
}
public String getName(){
	return this.Name;
}
public boolean getDeleteStatus(){
	return this.DeleteStatus;
}

public double getDeviceLatitude(){
	return this.DeviceLatitude;
}

public double getDeviceLongitude(){
	return this.DeviceLongitude;
}




}
