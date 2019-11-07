package org.nurse.msa.dto;


public class BedAllotmentDTO {
	private Integer id;
	private String bedId;
	private String bedNumber;
	private String patientName;
	private String allotmentTime;
	private String dischargeTime;

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
