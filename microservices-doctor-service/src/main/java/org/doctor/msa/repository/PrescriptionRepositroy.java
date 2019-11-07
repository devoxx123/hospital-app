package org.doctor.msa.repository;

import org.doctor.msa.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepositroy extends JpaRepository<Prescription, Long> {
	
	public Prescription findByPrescriptionId(String prescriptionId);
	
	public Prescription findByDoctorName(String doctorName);

}
