package com.example.samikshe;
import java.io.IOException;
import java.util.ArrayList;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.Marshal;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;


import android.os.Bundle;


public class Calhttp {

	public String login (String pUsn, String pPsw){
		  final String SOAP_ACTION = "http://tempuri.org/hagiosLogin";
		    final String METHOD_NAME = "hagiosLogin";
		    final String NAMESPACE = "http://tempuri.org/";
		    final String URL = "http://hagios.in/service.asmx";
		    
		        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);           
		 
		        
		        request.addProperty("usn", pUsn);
		        request.addProperty("paswd",pPsw );
		        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		        envelope.dotNet = true;
		        envelope.setOutputSoapObject(request);
		 String result="";
		        HttpTransportSE ht = new HttpTransportSE(URL);
		        try {
		         ht.call(SOAP_ACTION, envelope);
		            Object responses = envelope.getResponse();
		            result=responses.toString();
		        } catch (Exception e) {
		            e.printStackTrace();
		            result="false";
		        }
		return result;
	}
	
	
	public String getAttendence(String pStuid, String pFromdate, String pTodate){
		 final String SOAP_ACTION = "http://tempuri.org/attendenceDetail";
		    final String METHOD_NAME = "attendenceDetail";
		    final String NAMESPACE = "http://tempuri.org/";
		    final String URL = "http://hagios.in/service.asmx";
		    
		    
		    SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);           
	        request.addProperty("pStuID", pStuid);
	        request.addProperty("pFromDate",pFromdate );
	        request.addProperty("pTodate",pTodate );
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	 String result="";
	        HttpTransportSE ht = new HttpTransportSE(URL);
	        try {
	         ht.call(SOAP_ACTION, envelope);
	            Object responses = envelope.getResponse();
	            result=responses.toString();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	
	return result;
	}

	
//	public ArrayList<GpsTrackingDevice> ADDLoadGPSDevices( int pUserID, boolean pActiveYN){
//		String SOAP_ACTION = "http://tempuri.org/ADDLoadGPSDevices";
//		String OPERATION_NAME = "ADDLoadGPSDevices";
//		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
//		PropertyInfo pi=new PropertyInfo();
//
//		pi.setName("pUserID");
//		pi.setValue(pUserID);
//		pi.setType(Integer.class);
//		request.addProperty(pi);
//
//		pi=new PropertyInfo();
//
//		pi.setName("pActiveYN");
//		pi.setValue(pActiveYN);
//		pi.setType(Boolean.class);
//		request.addProperty(pi);
//		
//		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
//				SoapEnvelope.VER11);
//				envelope.dotNet = true;
//
//				envelope.setOutputSoapObject(request);
//			
//				HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
////				ArrayList<GpsTrackingDevice> deviceList=new ArrayList<GpsTrackingDevice>();
//		
//				try{
//					httpTransport.call(SOAP_ACTION, envelope);
//
//					SoapObject lResponse = (SoapObject) envelope.getResponse();
//
//					    Object property = lResponse.getProperty("diffgram");
//					    if (property instanceof SoapObject) {
//					        SoapObject dataset = (SoapObject) property;
//					        
//					        for (int i = 0; i < dataset.getPropertyCount(); i++) {
//					        	  SoapObject DeviceDetails =(SoapObject) dataset.getProperty("NewDataSet");
//					        	  if (DeviceDetails instanceof SoapObject) {
//							        	for (int j = 0; j < DeviceDetails.getPropertyCount(); j++) {
//							        		SoapObject GPSDevice=(SoapObject) DeviceDetails.getProperty(j);
////							        		GpsTrackingDevice device =new GpsTrackingDevice();
//							        		device.ID = Integer.parseInt( GPSDevice.getProperty("ID").toString());
//							        		device.UserID= Integer.parseInt( GPSDevice.getProperty("UserID").toString());
//							        		if(pActiveYN){
//							        		device.GPSDeviceName = GPSDevice.getProperty("GPSDeviceName").toString();
//							        		}
//							        		device.GPSDeviceIMEI = GPSDevice.getProperty("GPSDeviceIMEI").toString();
//							        		device.ActiveYN =Boolean.parseBoolean (GPSDevice.getProperty("ActiveYN").toString());
//							        		deviceList.add(device);
//							        	}
//							        }
//					        }
//					    }
//				}catch (Exception exception){
//					deviceList=null;
//				}
//				
//				
//		return deviceList;
//	}
	
	
//	include if it contains double values
//MarshalDouble md = new MarshalDouble();
	public class MarshalDouble implements Marshal {
        public Object readInstance(XmlPullParser parser, String namespace,
                String name, PropertyInfo expected) throws IOException,
                XmlPullParserException {

            return Double.parseDouble(parser.nextText());
        }

        public void register(SoapSerializationEnvelope cm) {
            cm.addMapping(cm.xsd, "double", Double.class, this);

        }

        public void writeInstance(XmlSerializer writer, Object obj)
                throws IOException {
            writer.text(obj.toString());
        }
    }
}
