package org.doctor.msa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.doctor.msa.exception.DoctorNameAlreadyExistException;
import org.doctor.msa.exception.DoctorNameNotFoundException;
import org.doctor.msa.exception.DoctorNumberNotFoundException;
import org.doctor.msa.exception.ExceptionErrorMessage;
import org.doctor.msa.model.Doctor;
import org.doctor.msa.service.DoctorService;
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
@Api(value = "Hospital Management System", description = "Operations pertaining to Doctor in Hospital Management System")
public class DoctorResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorResource.class);

	@Autowired
	private DoctorService doctorService;

	@GetMapping("/doctor")
	public String doctorHMS() {
		String doctor = " Welcome TO Doctor Status In Hospital Management " + new Date();
		LOGGER.info("Doctor Message " + doctor);
		return doctor;
	}

	@ApiOperation(value = "Create a new Doctor information", response = ResponseEntity.class)
	@RequestMapping(value = "/createdoctor", method = RequestMethod.POST)
	public ResponseEntity<String> createDoctor(@RequestBody Doctor doctor) {
		LOGGER.info("Creating a new Doctor Information : {}", doctor);
		Doctor doct = doctorService.getDoctorName(doctor.getDoctorName());
		if (doct != null && doct.getDoctorName() != null) {
			LOGGER.error("Creating a new Doctor Information A Doctor with DoctorName {} already exist",
					doctor.getDoctorName());
			throw new DoctorNameAlreadyExistException(ExceptionErrorMessage.DOCTOR_NAME_ALREADY_EXISTS.getErrMessage());
		}
		doctorService.createDoctor(doctor);
		return new ResponseEntity<String>("Doctor Information has been added sucessfully", HttpStatus.CREATED);

	}

	@ApiOperation(value = "View a list of available doctors", response = ResponseEntity.class)
	@RequestMapping(value = "/getalldoctors", method = RequestMethod.GET)
	public ResponseEntity<List<Doctor>> findAllDoctors() {
		List<Doctor> doctors = new ArrayList<>();
		LOGGER.info("Fetching All Doctor Informations{}", doctors);
		doctorService.getAllDoctors().forEach(doctors::add);
		return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Doctor details on the basis of Doctor ID", response = ResponseEntity.class)
	@RequestMapping(value = "/getdoctorid", method = RequestMethod.GET)
	public ResponseEntity<Doctor> findByDoctorId(@RequestParam String doctorId) {
		LOGGER.info("Fetch Doctor Information with doctorId {}", doctorId);
		Doctor doctId = doctorService.getDoctorId(doctorId);
		if (doctId == null) {
			LOGGER.error("Fetching Doctor with DoctorID {} not found.", doctorId);
			throw new DoctorNumberNotFoundException(ExceptionErrorMessage.DOCTOR_NUMBER_NOT_AVAILABLE.getErrMessage());
		} else {
			return new ResponseEntity<Doctor>(doctId, HttpStatus.OK);
		}

	}

	@ApiOperation(value = "Get Doctor details on the basis of doctor name", response = ResponseEntity.class)
	@RequestMapping(value = "/getdoctorname", method = RequestMethod.GET)
	public ResponseEntity<Doctor> findByDoctorName(@RequestParam String doctorName) {
		LOGGER.info("Fetch Doctor Information with doctorName {}", doctorName);
		Doctor doctName = doctorService.getDoctorName(doctorName);
		if (doctName == null) {
			LOGGER.error("Fetching Doctor with Doctor Name {} not found.", doctorName);
			throw new DoctorNameNotFoundException(ExceptionErrorMessage.DOCTOR_NAME_NOT_AVAILABLE.getErrMessage());
		} else {
			return new ResponseEntity<Doctor>(doctName, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Update existing Doctor details on the basis of doctor ID", response = ResponseEntity.class)
	@RequestMapping(value = "/updatedoctor", method = RequestMethod.PUT)
	public ResponseEntity<String> updateDoctor(@RequestBody Doctor doctor, @RequestParam("doctorId") String doctorId) {
		LOGGER.info("Updating Doctor Information with doctorId {}", doctorId);
		Doctor doctId = doctorService.getDoctorId(doctorId);
		if (doctId == null) {
			LOGGER.error("Unable to update.Doctor with doctorId {} not found.", doctorId);
			throw new DoctorNumberNotFoundException(ExceptionErrorMessage.DOCTOR_NUMBER_NOT_AVAILABLE.getErrMessage());
		} else {
			doctorService.updateDoctor(doctor, doctorId);
			return new ResponseEntity<String>("Doctor has been updated sucessfully", HttpStatus.OK);
		}

	}

}
