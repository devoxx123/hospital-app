package org.doctor.msa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.doctor.msa.exception.DoctorNameAlreadyExistException;
import org.doctor.msa.exception.DoctorNameNotFoundException;
import org.doctor.msa.exception.DoctorNumberNotFoundException;
import org.doctor.msa.exception.ExceptionErrorMessage;
import org.doctor.msa.exception.PrescriptionNumberNotFoundException;
import org.doctor.msa.model.Doctor;
import org.doctor.msa.model.Prescription;
import org.doctor.msa.service.PrescriptionService;
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
@Api(value = "Hospital Management System", description = "Operations pertaining to Prescription in Hospital Management System")
public class PrescriptionResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PrescriptionResource.class);

	@Autowired
	private PrescriptionService prescriptionService;
	
	@GetMapping("/prescrp")
	public String prescriptionHMS() {
		String prescrp = "Welcome TO Prescription Status In Hospital Management" + new Date();
		LOGGER.info("Prescription Message " + prescrp);
		return prescrp;
	}
	
	
	@ApiOperation(value = "Create a new Prescription information", response = ResponseEntity.class)
	@RequestMapping(value = "/createprescription", method = RequestMethod.POST)
	public ResponseEntity<String> createDoctor(@RequestBody Prescription prescription) {
		LOGGER.info("Creating a new Prescription Information : {}", prescription);
		Prescription prescrip = prescriptionService.getPrescriptionDoctorName(prescription.getDoctorName());
		if (prescrip != null && prescrip.getDoctorName() != null) {
			LOGGER.error("Creating a new Prescription Information A Prescription with DoctorName {} already exist",
					prescrip.getDoctorName());
			throw new DoctorNameAlreadyExistException(ExceptionErrorMessage.DOCTOR_NAME_ALREADY_EXISTS.getErrMessage());
		}
		prescriptionService.createPrescription(prescription);
		return new ResponseEntity<String>("Prescription Information has been added sucessfully", HttpStatus.CREATED);

	}

	@ApiOperation(value = "View a list of available prescriptions", response = ResponseEntity.class)
	@RequestMapping(value = "/getallprescrips", method = RequestMethod.GET)
	public ResponseEntity<List<Prescription>> findAllPrescriptions() {
		List<Prescription> prescriptions = new ArrayList<>();
		LOGGER.info("Fetching All Doctor Informations{}", prescriptions);
		prescriptionService.getAllPrescriptions().forEach(prescriptions::add);
		return new ResponseEntity<List<Prescription>>(prescriptions, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Prescription details on the basis of Prescription ID", response = ResponseEntity.class)
	@RequestMapping(value = "/getprescripid", method = RequestMethod.GET)
	public ResponseEntity<Prescription> findByPrescriptionId(@RequestParam String prescriptionId) {
		LOGGER.info("Fetch Prescription Information with Prescription Id {}", prescriptionId);
		Prescription prescripId = prescriptionService.getPrescriptionByPcpId(prescriptionId);
		if (prescripId == null) {
			LOGGER.error("Fetching Doctor with Prescription ID {} not found.", prescripId);
			throw new PrescriptionNumberNotFoundException(ExceptionErrorMessage.PRESCRIPTION_NUMBER_NOT_AVAILABLE.getErrMessage());
		} else {
			return new ResponseEntity<Prescription>(prescripId, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Get Prescription details on the basis of prescription name", response = ResponseEntity.class)
	@RequestMapping(value = "/prescripdoctorname", method = RequestMethod.GET)
	public ResponseEntity<Prescription> findByPrescriptionDoctorName(@RequestParam String doctorName) {
		LOGGER.info("Fetch Prescription Information with doctorName {}", doctorName);
		Prescription doctName = prescriptionService.getPrescriptionDoctorName(doctorName);
		if (doctName == null) {
			LOGGER.error("Fetching DoPrescriptionctor with Doctor Name {} not found.", doctorName);
			throw new DoctorNameNotFoundException(ExceptionErrorMessage.DOCTOR_NAME_NOT_AVAILABLE.getErrMessage());
		} else {
			return new ResponseEntity<Prescription>(doctName, HttpStatus.OK);
		}
	}
	
	@ApiOperation(value = "Update existing Doctor details on the basis of doctor ID", response = ResponseEntity.class)
	@RequestMapping(value = "/updateprescrip", method = RequestMethod.PUT)
	public ResponseEntity<String> updatePrescription(@RequestBody Prescription prescription, @RequestParam("prescriptionId") String prescriptionId) {
		LOGGER.info("Updating Prescription Information with prescriptionId {}", prescriptionId);
		Prescription prescripId = prescriptionService.getPrescriptionByPcpId(prescriptionId);
		if (prescripId == null) {
			LOGGER.error("Unable to update.Prescription with prescriptionId {} not found.", prescripId);
			throw new PrescriptionNumberNotFoundException(ExceptionErrorMessage.PRESCRIPTION_NUMBER_NOT_AVAILABLE.getErrMessage());
		} else {
			prescriptionService.updatePrescription(prescription, prescriptionId);
			return new ResponseEntity<String>("Prescription has been updated sucessfully", HttpStatus.OK);
		}

	}
}
