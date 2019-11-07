package org.doctor.msa.service;

import java.util.List;

import org.doctor.msa.model.Prescription;

public interface PrescriptionService {
	
    public Prescription createPrescription(Prescription prescription);
	
	public List<Prescription> getAllPrescriptions();

	public Prescription getPrescriptionByPcpId(String prescriptionId);
	
	public Prescription getPrescriptionDoctorName(String doctorName);
	
	public Prescription updatePrescription(Prescription prescription,String prescriptionId);

	

	
}
