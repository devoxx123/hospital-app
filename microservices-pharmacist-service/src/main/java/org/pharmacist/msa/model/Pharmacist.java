/*package org.pharmacist.msa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PHARMACIST_TBL")
public class Pharmacist implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String pharmacistName;
	private String pharmacistNumber;
	private String email;
	private String address;
	private String password;
	private String phone;

	public Pharmacist() {
	}

	public Pharmacist(Long id, String pharmacistName, String pharmacistNumber, String email, String address,
			String password, String phone) {
		super();
		this.id = id;
		this.pharmacistName = pharmacistName;
		this.pharmacistNumber = pharmacistNumber;
		this.email = email;
		this.address = address;
		this.password = password;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPharmacistName() {
		return pharmacistName;
	}

	public void setPharmacistName(String pharmacistName) {
		this.pharmacistName = pharmacistName;
	}

	public String getPharmacistNumber() {
		return pharmacistNumber;
	}

	public void setPharmacistNumber(String pharmacistNumber) {
		this.pharmacistNumber = pharmacistNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
*/