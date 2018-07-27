package com.capgemini.doctors.service;

import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.exception.DAException;

public interface IDoctorAppointmentService {
	int addDoctorAppointmentDetails(DoctorAppointment doctorAppointment) throws DAException;
	DoctorAppointment getDoctorAppointmentDetails(int appointmentId) throws DAException;

}
