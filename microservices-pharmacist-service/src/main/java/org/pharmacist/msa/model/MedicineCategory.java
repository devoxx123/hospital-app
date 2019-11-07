/*package org.pharmacist.msa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MEDICIAN_CATEGORY_TBL")
public class MedicineCategory implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String medicineCategoryName;
	private String medicinNumber;
	private String description;

	public MedicineCategory() {
	}

	public MedicineCategory(Long id, String medicineCategoryName, String medicinNumber, String description) {
		super();
		this.id = id;
		this.medicineCategoryName = medicineCategoryName;
		this.medicinNumber = medicinNumber;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMedicineCategoryName() {
		return medicineCategoryName;
	}

	public void setMedicineCategoryName(String medicineCategoryName) {
		this.medicineCategoryName = medicineCategoryName;
	}

	public String getMedicinNumber() {
		return medicinNumber;
	}

	public void setMedicinNumber(String medicinNumber) {
		this.medicinNumber = medicinNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
*/