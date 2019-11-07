package org.laboratorist.msa.repository;

import java.util.List;

import org.laboratorist.msa.model.BloodDonor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodDonorRepository extends JpaRepository<BloodDonor, Long> {

	public BloodDonor findByBdid(String bdid);

	public List<BloodDonor> findAll();

}
