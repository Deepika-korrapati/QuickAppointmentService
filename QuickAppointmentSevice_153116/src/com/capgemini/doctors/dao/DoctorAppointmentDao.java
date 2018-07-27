package com.capgemini.doctors.dao;

import java.util.HashMap;
import java.util.Map;
import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.exception.DAException;

public class DoctorAppointmentDao implements IDoctorAppointmentDao {
	
	Map<Integer,DoctorAppointment> myMap = new HashMap<>();
	Map<String,String> doctorSpeciality = new HashMap<String,String>();
	{
		doctorSpeciality.put("Heart", "Dr. Brijesh Kumar");
		doctorSpeciality.put("Gynecology", "Dr. Sharda Singh");
		doctorSpeciality.put("Diabetes", "Dr. Heena Khan");
		doctorSpeciality.put("ENT", "Dr. Paras Mal");
		doctorSpeciality.put("Bone", "Dr. Renuka Kher");
		doctorSpeciality.put("Dermatology", "Dr. Kanika Kapoor");
	}
	public int generateAppointmentId() {
		//Idgeneration using random function
		double rndDouble = Math.random();
		//return type of random func is double 
		//conversion to int
		return (int) (rndDouble*10000);
	}

	@Override
	public int addDoctorAppointmentDetails(DoctorAppointment doctorAppointment) throws DAException {
		doctorAppointment.setAppointmentId(generateAppointmentId());
		String problem  = doctorAppointment.getProblemName();
		
		if( doctorSpeciality.get(problem) != null )
		{
			doctorAppointment.setAppointmentStatus("Approved");
			doctorAppointment.setDoctorName( doctorSpeciality.get(problem) );
		}
		
		//add appointment request irrespective of approval status
		myMap.put(doctorAppointment.getAppointmentId(), doctorAppointment);
		
		return doctorAppointment.getAppointmentId();
	}

	@Override
	public DoctorAppointment getAppointmentDetails(int appointmentId) throws DAException {
		try {
			if(myMap.containsKey(appointmentId)== false)
				throw new DAException("The requested Id is not found");
		} catch (DAException e) {
			System.out.println("Error:" +e.getMessage());
		}
		DoctorAppointment details  = myMap.get(appointmentId);
		String problem= details.getProblemName();
		if(doctorSpeciality.containsKey(problem)) {
			System.out.print("Patient Name :" + details.getPatientName());
			System.out.println();
			System.out.print("Appointment Status :" +details.getAppointmentStatus());
			System.out.println();
			System.out.print("Doctor Name:" + doctorSpeciality.get(problem));
			System.out.println();
			System.out.println("Appointment Date and time, along with doctors phone number will be shared shortly with u ");
		}
		else {
			System.out.print("Patient Name :" + details.getPatientName());
			System.out.println();
			System.out.print("Appointment Status : DISAPPROVED");
			System.out.println();
			System.out.print("Doctor Name:  " );
			System.out.println();
			
			
		}
		return details;
	}

	public Map<Integer, DoctorAppointment> getMyMap() {
		return myMap;
	}

	public void setMyMap(Map<Integer, DoctorAppointment> myMap) {
		this.myMap = myMap;
	}
	

}
