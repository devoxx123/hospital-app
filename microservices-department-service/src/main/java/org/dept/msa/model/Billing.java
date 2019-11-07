package org.dept.msa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "BILLING_TBL")
public class Billing implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String billNumber;
	private String patientType;
	private String doctorCharge;
	private String medicineCharge;
	private String roomCharge;
	private String noOfDays;
	private String nursingCharge;
	private String advanceCharge;
	private String paymentMode;
	private String paymentModeDetails;
	private String labCharge;
	@CreationTimestamp
	private Date billingDate;

	public Billing() {
	}

	public Billing(Long id, String billNumber, Date billingDate, String patientType, String doctorCharge,
			String medicineCharge, String roomCharge, String noOfDays, String nursingCharge, String advanceCharge,
			String paymentMode, String paymentModeDetails, String labCharge) {
		super();
		this.id = id;
		this.billNumber = billNumber;
		this.billingDate = billingDate;
		this.patientType = patientType;
		this.doctorCharge = doctorCharge;
		this.medicineCharge = medicineCharge;
		this.roomCharge = roomCharge;
		this.noOfDays = noOfDays;
		this.nursingCharge = nursingCharge;
		this.advanceCharge = advanceCharge;
		this.paymentMode = paymentMode;
		this.paymentModeDetails = paymentModeDetails;
		this.labCharge = labCharge;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public Date getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}

	public String getPatientType() {
		return patientType;
	}

	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}

	public String getDoctorCharge() {
		return doctorCharge;
	}

	public void setDoctorCharge(String doctorCharge) {
		this.doctorCharge = doctorCharge;
	}

	public String getMedicineCharge() {
		return medicineCharge;
	}

	public void setMedicineCharge(String medicineCharge) {
		this.medicineCharge = medicineCharge;
	}

	public String getRoomCharge() {
		return roomCharge;
	}

	public void setRoomCharge(String roomCharge) {
		this.roomCharge = roomCharge;
	}

	public String getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getNursingCharge() {
		return nursingCharge;
	}

	public void setNursingCharge(String nursingCharge) {
		this.nursingCharge = nursingCharge;
	}

	public String getAdvanceCharge() {
		return advanceCharge;
	}

	public void setAdvanceCharge(String advanceCharge) {
		this.advanceCharge = advanceCharge;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentModeDetails() {
		return paymentModeDetails;
	}

	public void setPaymentModeDetails(String paymentModeDetails) {
		this.paymentModeDetails = paymentModeDetails;
	}

	public String getLabCharge() {
		return labCharge;
	}

	public void setLabCharge(String labCharge) {
		this.labCharge = labCharge;
	}

}

/*
 * INSERT INTO `bill_room` VALUES (1,'2015-01-12',5000,500,'by Cash','Payment
 * done successfully!',1485500,297,1485000,'120150112')
 */
