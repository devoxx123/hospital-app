package org.nurse.msa.repository;

import java.util.List;

import org.nurse.msa.model.BedAllotment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedAllotmentRepository extends JpaRepository<BedAllotment, Integer> {

	public BedAllotment findByBedId(String bedId);

	public List<BedAllotment> findAll();
}
