package org.patient.msa.service;

import java.util.List;

import org.patient.msa.model.Patient;

public interface PatientService {
	public Patient createPatient(Patient patientDto);

	public List<Patient> getAllPatients();

	public Patient getPatientByPatientNumber(String patientNumber);

	public Patient getPatientByPatientName(String patientName);

	public Patient updatePatient(Patient patientDto, String patientNumber);
   
	public void deletePatientById(Long id);
}
