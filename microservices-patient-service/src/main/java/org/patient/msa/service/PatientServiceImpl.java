package org.patient.msa.service;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.patient.msa.model.Patient;
import org.patient.msa.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public Patient createPatient(Patient patientDto) {
		patientDto.setPatientNumber(RandomStringUtils.randomNumeric(8));
		return patientRepository.save(patientDto);
	}

	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Patient getPatientByPatientNumber(String patientNumber) {
		return patientRepository.findByPatientNumber(patientNumber);
	}

	@Override
	public Patient getPatientByPatientName(String patientName) {
		return patientRepository.findByPatientName(patientName);
	}

	@Override
	public Patient updatePatient(Patient patientDto, String patientNumber) {
		return patientRepository.findByPatientNumber(patientNumber);
	}

	@Override
	public void deletePatientById(Long id) {
		patientRepository.deleteById(id);

	}

}
