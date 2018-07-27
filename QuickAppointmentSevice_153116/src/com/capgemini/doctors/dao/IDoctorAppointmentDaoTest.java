package com.capgemini.doctors.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.exception.DAException;

public class IDoctorAppointmentDaoTest {
	private static IDoctorAppointmentDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new DoctorAppointmentDao();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao=null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddDoctorAppointmentDetails() throws DAException {
		DoctorAppointment da = new DoctorAppointment();
		da.setPatientName("Deepika");
		da.setPhoneNumber("9542308427");
		da.setEmail("deepika@gmail.com");
		da.setGender("Female");
		da.setProblemName("Heart");
		int appointmentId = dao.addDoctorAppointmentDetails(da);
		assertTrue(appointmentId > 0);

	}

	@Test
	public void testGetAppointmentDetails() throws DAException {
		DoctorAppointment da = new DoctorAppointment();
		da.setPatientName("Deepika");
		da.setPhoneNumber("9542308427");
		da.setEmail("deepika@gmail.com");
		da.setGender("Female");
		da.setProblemName("Heart");
		int appointmentId = dao.addDoctorAppointmentDetails(da);
		DoctorAppointment doctorAppointment = dao.getAppointmentDetails(appointmentId);
		assertNotEquals(null,doctorAppointment);
		

	}

}
