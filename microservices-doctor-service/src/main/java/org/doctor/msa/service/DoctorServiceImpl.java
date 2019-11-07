package org.doctor.msa.service;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.doctor.msa.model.Doctor;
import org.doctor.msa.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public Doctor createDoctor(Doctor doctor) {
		doctor.setDoctorId(RandomStringUtils.randomNumeric(6));
		return doctorRepository.save(doctor);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor getDoctorId(String doctorId) {
		return doctorRepository.findByDoctorId(doctorId);
	}

	@Override
	public Doctor getDoctorName(String doctorName) {
		return doctorRepository.findByDoctorName(doctorName);
	}

	@Override
	public Doctor updateDoctor(Doctor doctor, String doctorId) {
		Doctor updateDoctor = new Doctor();
		Doctor existingDoctor = doctorRepository.findByDoctorId(doctorId);
		if (existingDoctor != null) {
			existingDoctor.setDoctorName(doctor.getDoctorName());
			existingDoctor.setDesignation(doctor.getDesignation());
			existingDoctor.setDegree(doctor.getDegree());
			existingDoctor.setExperience(doctor.getExperience());
			existingDoctor.setAddress(doctor.getAddress());
			existingDoctor.setEmail(doctor.getEmail());
			existingDoctor.setContactNumber(doctor.getContactNumber());
			existingDoctor.setPassword(doctor.getPassword());
			existingDoctor.setProfile(doctor.getProfile());
			existingDoctor.setDepartment(doctor.getDepartment());
			existingDoctor.setDateOfJoining(doctor.getDateOfJoining());
			updateDoctor = doctorRepository.save(existingDoctor);
		}
		return updateDoctor;
	}

}
