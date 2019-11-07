package org.hospital.msa.repository;

import org.hospital.msa.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer>  {

	public Hospital findByHospitalId(String hospitalId);
	
	public Hospital findByName(String name);

}
