package org.dept.msa.service;

import java.util.List;

import org.dept.msa.model.Billing;

public interface BillingService {
	
	public Billing saveBilling(Billing billing);
	
	public List<Billing> listOfBillings();
	
	public Billing fetchByBillingNumber(String billNumber);
	
	public Billing billingUpdate(Billing billing,String billNumber);
	

}
