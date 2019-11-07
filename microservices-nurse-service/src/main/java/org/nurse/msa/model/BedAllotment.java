package org.nurse.msa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BED_ALLOTMENT_TBL")
public class BedAllotment implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String bedId;
	private String bedNumber;
	private String patientName;
	private String allotmentTime;
	private String dischargeTime;

	public BedAllotment() {
	}

	public BedAllotment(Integer id, String bedId, String bedNumber, String patientName, String allotmentTime,
			String dischargeTime) {
		super();
		this.id = id;
		this.bedId = bedId;
		this.bedNumber = bedNumber;
		this.patientName = patientName;
		this.allotmentTime = allotmentTime;
		this.dischargeTime = dischargeTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBedId() {
		return bedId;
	}

	public void setBedId(String bedId) {
		this.bedId = bedId;
	}

	public String getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getAllotmentTime() {
		return allotmentTime;
	}

	public void setAllotmentTime(String allotmentTime) {
		this.allotmentTime = allotmentTime;
	}

	public String getDischargeTime() {
		return dischargeTime;
	}

	public void setDischargeTime(String dischargeTime) {
		this.dischargeTime = dischargeTime;
	}

}
