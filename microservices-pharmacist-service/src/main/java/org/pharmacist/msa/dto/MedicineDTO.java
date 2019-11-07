package org.pharmacist.msa.dto;

public class MedicineDTO {

	private Long id;
	private String medicineId;
	private String medicineName;
	private String cost;
	private String quantity;
	private String manufacturDate;
	private String medicianExpired;
	private String unitPerDay;
	private String status;
	private String description;
	private String manufacturing;
	private String medicineCategory;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getManufacturDate() {
		return manufacturDate;
	}

	public void setManufacturDate(String manufacturDate) {
		this.manufacturDate = manufacturDate;
	}

	public String getMedicianExpired() {
		return medicianExpired;
	}

	public void setMedicianExpired(String medicianExpired) {
		this.medicianExpired = medicianExpired;
	}

	public String getUnitPerDay() {
		return unitPerDay;
	}

	public void setUnitPerDay(String unitPerDay) {
		this.unitPerDay = unitPerDay;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturing() {
		return manufacturing;
	}

	public void setManufacturing(String manufacturing) {
		this.manufacturing = manufacturing;
	}

	public String getMedicineCategory() {
		return medicineCategory;
	}

	public void setMedicineCategory(String medicineCategory) {
		this.medicineCategory = medicineCategory;
	}

}
