package org.dept.msa.repository;

import org.dept.msa.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<Billing,Long>{
	
	public Billing findByBillNumber(String billNumber);
	

}
