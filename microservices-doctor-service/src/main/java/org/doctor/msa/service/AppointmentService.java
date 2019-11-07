package org.doctor.msa.service;

import java.util.List;
import java.util.Map;

import org.doctor.msa.model.Appointment;
import org.doctor.msa.model.Report;

public interface AppointmentService {

	public Appointment saveAppointment(Appointment appointment);
	
	public List<Appointment> getAllAppointments();

	public Appointment getAppointmentByApmId(String appointmentId);
	
    public Appointment getAppointmentDoctorName(String doctorName);
	
	public Appointment getAppointmentPatientName(String patientName);

	public Appointment updateAppointment(Appointment appointment, String appointmentId);

	//public void deleteAppointmentByApmId(String appointmentId);

}
