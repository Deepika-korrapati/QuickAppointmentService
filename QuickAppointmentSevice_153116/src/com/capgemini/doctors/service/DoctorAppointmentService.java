package com.capgemini.doctors.service;

import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.dao.DoctorAppointmentDao;
import com.capgemini.doctors.dao.IDoctorAppointmentDao;
import com.capgemini.doctors.exception.DAException;

public class DoctorAppointmentService implements IDoctorAppointmentService {
	private IDoctorAppointmentDao dao;
	

	public DoctorAppointmentService() {
	dao= new DoctorAppointmentDao();
	}

	@Override
	public int addDoctorAppointmentDetails(DoctorAppointment doctorAppointment) throws DAException {
		int id = dao.addDoctorAppointmentDetails(doctorAppointment);
		return id;
	}

	@Override
	public DoctorAppointment getDoctorAppointmentDetails(int appointmentId) throws DAException {
		// TODO Auto-generated method stub
		DoctorAppointment da = dao.getAppointmentDetails(appointmentId);
		return da;
	}

}
