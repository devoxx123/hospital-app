package org.doctor.msa.service;

import java.util.List;

import org.doctor.msa.model.Appointment;
import org.doctor.msa.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public Appointment saveAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	@Override
	public List<Appointment> getAllAppointments() {
		return appointmentRepository.findAll();
	}

	@Override
	public Appointment getAppointmentByApmId(String appointmentId) {
		return appointmentRepository.findByAppointmentId(appointmentId);
	}

	@Override
	public Appointment getAppointmentDoctorName(String doctorName) {
		return appointmentRepository.findByDoctorName(doctorName);
	}

	@Override
	public Appointment getAppointmentPatientName(String patientName) {
		return appointmentRepository.findByPatientName(patientName);
	}

	@Override
	public Appointment updateAppointment(Appointment appointment, String appointmentId) {
		Appointment updateAppointment = new Appointment();
		Appointment existingAppointment = appointmentRepository.findByAppointmentId(appointmentId);
		if (existingAppointment != null) {
			existingAppointment.setDoctorName(appointment.getDoctorName());
			existingAppointment.setPatientName(appointment.getPatientName());
			existingAppointment.setDescription(appointment.getDescription());
			existingAppointment.setPreferredTime(appointment.getPreferredTime());
			existingAppointment.setPreferredDay(appointment.getPreferredDay());
			existingAppointment.setPreferredDate(appointment.getPreferredDate());
			existingAppointment.setSymptons(appointment.getSymptons());
			existingAppointment.setDisease(appointment.getDisease());
			updateAppointment = appointmentRepository.save(existingAppointment);
		}
		return updateAppointment;
	}
	
}
