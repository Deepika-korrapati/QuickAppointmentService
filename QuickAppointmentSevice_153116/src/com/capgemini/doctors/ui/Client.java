package com.capgemini.doctors.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.exception.DAException;
import com.capgemini.doctors.service.DoctorAppointmentService;
import com.capgemini.doctors.service.IDoctorAppointmentService;

public class Client {
	//loosecoupling
	private IDoctorAppointmentService service;

	public Client() {
		//association
	service = new DoctorAppointmentService();
	}
	public static void main(String[] args) throws DAException {
		Client client = new Client();
		//make sure application runs forever unless you close it
		while(true)
		client.menu();
	}
	private void menu() throws DAException {
		System.out.println("1) Book appointment");
		System.out.println("2) view status");
		System.out.println("0) Exit Application");
		Scanner console = new Scanner(System.in);
		System.out.println("Please Select an Option:");
		int choice = console.nextInt();
		DoctorAppointment doctor = new DoctorAppointment();
		switch (choice) {
		case 1:
			
			System.out.print("Enter Name of the Patient: ");
			String name = console.next();
			System.out.print("Enter Phone number of the patient: ");
			String number = console.next();
			System.out.print("Enter Email of the patient: ");
			String email = console.next();
			System.out.print("Enter Age of the patient: ");
			int age = console.nextInt();
			System.out.print("Enter Gender of the patient: ");
			String gender = console.next();
			System.out.print("Enter Problem name of the patient: ");
			String problem = console.next();
			doctor.setPatientName(name);
			doctor.setPhoneNumber(number);
			doctor.setEmail(email);
			doctor.setAge(age);
			doctor.setGender(gender);
			doctor.setProblemName(problem);
			int id = service.addDoctorAppointmentDetails(doctor);
			if(id>0)
			System.out.println("Appointment Booking is successful:" + id);
			else
			System.out.println("Service is not offered for requested problem name");
			break;
		case 2: System.out.print("Enter Appointment Id :" );
		int id2 = console.nextInt();
		DoctorAppointment da = service.getDoctorAppointmentDetails(id2);
			break;
		case 0: System.out.println("Goodbye");
		 System.exit(0);
		 break;
			
	
		}
	}

}
