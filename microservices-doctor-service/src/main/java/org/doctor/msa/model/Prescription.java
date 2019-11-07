package org.doctor.msa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRESCRIPTION_TBL")
public class Prescription implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String doctorName;
	private String prescriptionId;
	private String patientName;
	private String caseHistory;
	private String medication;
	private String pharmaMedication;
	private String description;
	private String prescriptionDate;

	public Prescription() {
	}

	public Prescription(Long id, String doctorName, String prescriptionId, String patientName, String caseHistory,
			String medication, String pharmaMedication, String description, String prescriptionDate) {
		super();
		this.id = id;
		this.doctorName = doctorName;
		this.prescriptionId = prescriptionId;
		this.patientName = patientName;
		this.caseHistory = caseHistory;
		this.medication = medication;
		this.pharmaMedication = pharmaMedication;
		this.description = description;
		this.prescriptionDate = prescriptionDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(String prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getCaseHistory() {
		return caseHistory;
	}

	public void setCaseHistory(String caseHistory) {
		this.caseHistory = caseHistory;
	}

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	public String getPharmaMedication() {
		return pharmaMedication;
	}

	public void setPharmaMedication(String pharmaMedication) {
		this.pharmaMedication = pharmaMedication;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrescriptionDate() {
		return prescriptionDate;
	}

	public void setPrescriptionDate(String prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}

}
