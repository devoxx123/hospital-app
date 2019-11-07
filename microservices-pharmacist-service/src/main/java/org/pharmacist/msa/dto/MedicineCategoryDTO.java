package org.pharmacist.msa.dto;

public class MedicineCategoryDTO {
	private String medicineCategoryName;
	private String mdcId;
	private String description;

	public String getMedicineCategoryName() {
		return medicineCategoryName;
	}

	public void setMedicineCategoryName(String medicineCategoryName) {
		this.medicineCategoryName = medicineCategoryName;
	}

	public String getMdcId() {
		return mdcId;
	}

	public void setMdcId(String mdcId) {
		this.mdcId = mdcId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
