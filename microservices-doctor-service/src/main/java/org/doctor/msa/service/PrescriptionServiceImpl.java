package org.doctor.msa.service;

import java.util.List;

import org.doctor.msa.model.Prescription;
import org.doctor.msa.repository.PrescriptionRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

	@Autowired
	private PrescriptionRepositroy prescriptionRepositroy;

	@Override
	public Prescription createPrescription(Prescription prescription) {
		return prescriptionRepositroy.save(prescription);
	}

	@Override
	public List<Prescription> getAllPrescriptions() {
		return prescriptionRepositroy.findAll();
	}

	@Override
	public Prescription getPrescriptionByPcpId(String prescriptionId) {
		return prescriptionRepositroy.findByPrescriptionId(prescriptionId);
	}

	@Override
	public Prescription getPrescriptionDoctorName(String doctorName) {
		return prescriptionRepositroy.findByDoctorName(doctorName);
	}
	
	@Override
	public Prescription updatePrescription(Prescription prescription, String prescriptionId) {
		Prescription updatePrescripe = new Prescription();
		Prescription existingPrescripe = prescriptionRepositroy.findByPrescriptionId(prescriptionId);
		if (null != existingPrescripe) {
			existingPrescripe.setDoctorName(prescription.getDoctorName());
			existingPrescripe.setPatientName(prescription.getPatientName());
			existingPrescripe.setCaseHistory(prescription.getCaseHistory());
			existingPrescripe.setMedication(prescription.getMedication());
			existingPrescripe.setPharmaMedication(prescription.getPharmaMedication());
			existingPrescripe.setPrescriptionDate(prescription.getPrescriptionDate());
			updatePrescripe = prescriptionRepositroy.save(existingPrescripe);
		}
		return updatePrescripe;
	}

	

}
