package org.doctor.msa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.doctor.msa.exception.AppointmentNumberNotFoundException;
import org.doctor.msa.exception.DoctorNameAlreadyExistException;
import org.doctor.msa.exception.DoctorNameNotFoundException;
import org.doctor.msa.exception.ExceptionErrorMessage;
import org.doctor.msa.exception.PatientNameNotFoundException;
import org.doctor.msa.model.Appointment;
import org.doctor.msa.service.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Hospital Management System", description = "Operations pertaining to Appointment in Hospital Management System")
public class AppointmentResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentResource.class);

	@Autowired
	private AppointmentService appointmentService;

	@GetMapping("/app")
	public String appointmentHMS() {
		String app = "Welcome TO Appointment Status In Hospital Management " + new Date();
		LOGGER.info(" Appointment Message " + app);
		return app;
	}

	@ApiOperation(value = "Create a new Appointment information", response = ResponseEntity.class)
	@RequestMapping(value = "/saveappointment", method = RequestMethod.POST)
	public ResponseEntity<String> saveAppointment(@RequestBody Appointment appointment) {
		LOGGER.info("Creating a new Appointment Information : {}", appointment);
		Appointment appoint = appointmentService.getAppointmentDoctorName(appointment.getDoctorName());
		if (appoint != null && appoint.getDoctorName() != null) {
			LOGGER.error("Creating a new Report Information A Report with DoctorName {} already exist",
					appoint.getDoctorName());
			throw new DoctorNameAlreadyExistException(ExceptionErrorMessage.DOCTOR_NAME_ALREADY_EXISTS.getErrMessage());
		}
		appointmentService.saveAppointment(appointment);
		return new ResponseEntity<String>("Appointment Information has been added sucessfully", HttpStatus.CREATED);
	}

	@ApiOperation(value = "View a list of available appointments", response = ResponseEntity.class)
	@RequestMapping(value = "/listofappointment", method = RequestMethod.GET)
	public ResponseEntity<List<Appointment>> findAllAppointments() {
		List<Appointment> appointments = new ArrayList<>();
		LOGGER.info("Fetching All Appointment Informations{}", appointments);
		appointmentService.getAllAppointments().forEach(appointments::add);
		return new ResponseEntity<List<Appointment>>(appointments, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Appointment details on the basis of Appointment ID", response = ResponseEntity.class)
	@RequestMapping(value = "/getappointid", method = RequestMethod.GET)
	public ResponseEntity<Appointment> findByAppointId(@RequestParam String appointmentId) {
		LOGGER.info("Fetch Appointment Information with AppointmentId {}", appointmentId);
		Appointment appointId = appointmentService.getAppointmentByApmId(appointmentId);
		if (appointId == null) {
			LOGGER.error("Fetching Appointment with AppointmentId {} not found.", appointId);
			throw new AppointmentNumberNotFoundException(
					ExceptionErrorMessage.APPOINTMENT_NUMBER_NOT_AVAILABLE.getErrMessage());
		} else {
			return new ResponseEntity<Appointment>(appointId, HttpStatus.OK);
		}

	}

	@ApiOperation(value = "Get Appointment details on the basis of doctor name", response = ResponseEntity.class)
	@RequestMapping(value = "/getappointdoctorname", method = RequestMethod.GET)
	public ResponseEntity<Appointment> findByReportDoctorName(@RequestParam String doctorName) {
		LOGGER.info("Fetch Appointment Information with doctorName {}", doctorName);
		Appointment appointmentDoctName = appointmentService.getAppointmentDoctorName(doctorName);
		if (appointmentDoctName == null) {
			LOGGER.error("Fetching Appointment with Doctor Name {} not found.", appointmentDoctName);
			throw new DoctorNameNotFoundException(ExceptionErrorMessage.DOCTOR_NAME_NOT_AVAILABLE.getErrMessage());
		} else {
			return new ResponseEntity<Appointment>(appointmentDoctName, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Get Appointment details on the basis of patient name", response = ResponseEntity.class)
	@RequestMapping(value = "/getappointpatientname", method = RequestMethod.GET)
	public ResponseEntity<Appointment> findByAppointmentPatientName(@RequestParam String patientName) {
		LOGGER.info("Fetch Appointment Information with patient Name {}", patientName);
		Appointment appointmentPatientName = appointmentService.getAppointmentPatientName(patientName);
		if (appointmentPatientName == null) {
			LOGGER.error("Fetching Appointment with patient Name {} not found.", patientName);
			throw new PatientNameNotFoundException(ExceptionErrorMessage.PATIENT_NAME_NOT_AVAILABLE.getErrMessage());
		} else {
			return new ResponseEntity<Appointment>(appointmentPatientName, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Update existing Appointment details on the basis of Appointment ID", response = ResponseEntity.class)
	@RequestMapping(value = "/updateappointment", method = RequestMethod.PUT)
	public ResponseEntity<String> updateAppointment(@RequestBody Appointment appointment,
			@RequestParam("appointmentId") String appointmentId) {
		LOGGER.info("Updating Appointment Information with Appointment Id {}", appointmentId);
		Appointment appointId = appointmentService.getAppointmentByApmId(appointmentId);
		if (appointId == null) {
			LOGGER.error("Unable to update.Appointment with  Appointment Id {} not found.", appointId);
			throw new AppointmentNumberNotFoundException(
					ExceptionErrorMessage.APPOINTMENT_NUMBER_NOT_AVAILABLE.getErrMessage());
		} else {
			appointmentService.updateAppointment(appointment, appointmentId);
			return new ResponseEntity<String>("Appointment has been updated sucessfully", HttpStatus.OK);
		}

	}

}
