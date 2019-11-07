package org.dept.msa.service;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.dept.msa.model.Billing;
import org.dept.msa.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingServiceImpl implements BillingService{
	
	@Autowired
	private BillingRepository billingRepository;

	@Override
	public Billing saveBilling(Billing billing) {
		billing.setBillNumber(RandomStringUtils.randomNumeric(8));
		return billingRepository.save(billing);
	}

	@Override
	public List<Billing> listOfBillings() {
		return billingRepository.findAll();
	}

	@Override
	public Billing fetchByBillingNumber(String billNumber) {
		return billingRepository.findByBillNumber(billNumber);
	}

	@Override
	public Billing billingUpdate(Billing billing, String billNumber) {
		Billing updatebilling = new Billing();
		Billing existingbilling = billingRepository.findByBillNumber(billNumber);
		if (existingbilling != null) {
			existingbilling.setPatientType(billing.getPatientType());
			existingbilling.setDoctorCharge(billing.getDoctorCharge());
			existingbilling.setMedicineCharge(billing.getMedicineCharge());
			existingbilling.setRoomCharge(billing.getRoomCharge());
			existingbilling.setNoOfDays(billing.getNoOfDays());
			existingbilling.setNursingCharge(billing.getNursingCharge());
			existingbilling.setAdvanceCharge(billing.getAdvanceCharge());
			existingbilling.setPaymentMode(billing.getPaymentMode());
			existingbilling.setPaymentModeDetails(billing.getPaymentModeDetails());
			existingbilling.setLabCharge(billing.getLabCharge());
			existingbilling.setBillingDate(billing.getBillingDate());
			updatebilling = billingRepository.save(existingbilling);
		}
		return updatebilling;
	}

}
