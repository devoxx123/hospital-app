package org.doctor.msa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APPOINTMENT_TBL")
public class Appointment implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String appointmentId;
	private String doctorName;
	private String patientName;
	private String description;
	private String preferredDay;
	private String preferredTime;
	private String preferredDate;
	private String symptons;
	private String disease;

	public Appointment() {
	}

	public Appointment(Long id, String appointmentId, String doctorName, String patientName,
			String description, String preferredDay, String preferredTime, String preferredDate, String symptons,
			String disease) {
		super();
		this.id = id;
		this.appointmentId = appointmentId;
		this.doctorName = doctorName;
		this.patientName = patientName;
		this.description = description;
		this.preferredDay = preferredDay;
		this.preferredTime = preferredTime;
		this.preferredDate = preferredDate;
		this.symptons = symptons;
		this.disease = disease;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPreferredDay() {
		return preferredDay;
	}

	public void setPreferredDay(String preferredDay) {
		this.preferredDay = preferredDay;
	}

	public String getPreferredTime() {
		return preferredTime;
	}

	public void setPreferredTime(String preferredTime) {
		this.preferredTime = preferredTime;
	}

	public String getPreferredDate() {
		return preferredDate;
	}

	public void setPreferredDate(String preferredDate) {
		this.preferredDate = preferredDate;
	}

	public String getSymptons() {
		return symptons;
	}

	public void setSymptons(String symptons) {
		this.symptons = symptons;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

}
