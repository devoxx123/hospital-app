
package org.nurse.msa.repository;

import java.util.List;

import org.nurse.msa.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Integer> {
	
	public Nurse findByNurseId(String nsid);
	
	public List<Nurse> findAll();
}
