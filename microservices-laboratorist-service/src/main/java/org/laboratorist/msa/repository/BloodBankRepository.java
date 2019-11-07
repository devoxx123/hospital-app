package org.laboratorist.msa.repository;

import java.util.List;

import org.laboratorist.msa.model.BloodBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodBankRepository extends JpaRepository<BloodBank, Long> {

	public List<BloodBank> findAll();

	public BloodBank findByBloodGroup(String bdGroup);

}
