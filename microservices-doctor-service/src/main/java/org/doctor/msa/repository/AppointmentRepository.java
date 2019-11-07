package org.doctor.msa.repository;

import org.doctor.msa.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	public Appointment findByAppointmentId(String appointmentId);

	public Appointment findByDoctorName(String doctorName);

	public Appointment findByPatientName(String patientName);
}
