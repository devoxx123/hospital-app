package org.laboratorist.msa.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BLOOD_DONOR_TBL")
public class BloodDonor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String bdid;
	private String email;
	private String address;
	private String phone;
	private String gender;
	private String bloodGroup;
	private LocalDate ldd;

	public BloodDonor() {
	}

	public BloodDonor(Long id, String name, String bdid, String email, String address, String phone, String gender,
			String bloodGroup, LocalDate ldd) {
		super();
		this.id = id;
		this.name = name;
		this.bdid = bdid;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.ldd = ldd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBdid() {
		return bdid;
	}

	public void setBdid(String bdid) {
		this.bdid = bdid;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public LocalDate getLdd() {
		return ldd;
	}

	public void setLdd(LocalDate ldd) {
		this.ldd = ldd;
	}

}
