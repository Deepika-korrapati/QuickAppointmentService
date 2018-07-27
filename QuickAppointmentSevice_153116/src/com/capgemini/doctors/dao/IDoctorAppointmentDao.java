package com.capgemini.doctors.dao;

import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.exception.DAException;

public interface IDoctorAppointmentDao {
	int addDoctorAppointmentDetails(DoctorAppointment doctorAppointment) throws DAException;
	DoctorAppointment getAppointmentDetails(int appointmentId) throws DAException;

}
