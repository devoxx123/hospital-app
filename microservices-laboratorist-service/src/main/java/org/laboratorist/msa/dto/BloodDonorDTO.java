package org.laboratorist.msa.dto;

import java.time.LocalDate;

public class BloodDonorDTO {

	private String name;
	private String bdid;
	private String email;
	private String address;
	private String phone;
	private String gender;
	private String bloodGroup;
	private LocalDate ldd;

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
