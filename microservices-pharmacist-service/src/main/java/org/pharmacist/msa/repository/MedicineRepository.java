package org.pharmacist.msa.repository;

import java.util.List;

import org.pharmacist.msa.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
	
	public Medicine findByMedicineId(String medicineId);
	
	public List<Medicine> findAll();

}
