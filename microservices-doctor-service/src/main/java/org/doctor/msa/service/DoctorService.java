package org.doctor.msa.service;

import java.util.List;

import org.doctor.msa.model.Doctor;

public interface DoctorService {

	public Doctor createDoctor(Doctor doctor);

	public List<Doctor> getAllDoctors();

	public Doctor getDoctorId(String doctorId);
	
	public Doctor getDoctorName(String doctorName);

	public Doctor updateDoctor(Doctor doctor,String doctorId);

}
