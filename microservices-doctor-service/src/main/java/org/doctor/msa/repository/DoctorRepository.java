package org.doctor.msa.repository;

import org.doctor.msa.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
	public Doctor findByDoctorId(String doctorId);
	
	public Doctor findByDoctorName(String doctorName);
	
	

}
