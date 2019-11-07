
package org.hospital.msa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hospital.msa.exception.HospitalExceptionErrorMessages;
import org.hospital.msa.exception.HospitalNameAlreadyExistException;
import org.hospital.msa.exception.HospitalNameNotFoundException;
import org.hospital.msa.exception.HospitalNumberNotFoundException;
import org.hospital.msa.model.Hospital;
import org.hospital.msa.service.HospitalService;
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
@Api(value = "Hospital Management System", description = "Operations pertaining to Hospital in Hospital Management System")
public class HospitalResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(HospitalResource.class);

	@Autowired
	private HospitalService hospitalService;

	@GetMapping("/admin")
	public String adminHMS() {
		String admin = "Welcome TO Admin Status In Hospital Management " + new Date();
		LOGGER.info("Admin Message " + admin);
		return admin;
	}

	@ApiOperation(value = "Create a new hosptial information",response = ResponseEntity.class)
	@RequestMapping(value = "/createhosp", method = RequestMethod.POST)
	public ResponseEntity<String> saveHospital(@RequestBody Hospital hospital) {
		LOGGER.info("Creating a new Hospital Information : {}", hospital);
		Hospital hosp = hospitalService.getHospitalName(hospital.getName());
		if (hosp != null && hosp.getName() != null) {
			LOGGER.error("Creating a new Hospital Information A Hospital with HospitalName {} already exist",
					hospital.getName());
			throw new HospitalNameAlreadyExistException(
					HospitalExceptionErrorMessages.HOSPITAL_NAME_ALREADY_EXISTS.getErrMessage());
		}
		hospitalService.newHospital(hospital);
		return new ResponseEntity<String>("Hospital has been added sucessfully", HttpStatus.CREATED);

	}

	@ApiOperation(value = "View a list of available hospitals", response = ResponseEntity.class)
	@RequestMapping(value = "/getallhosps", method = RequestMethod.GET)
	public ResponseEntity<List<Hospital>> findAllHospitals() {
		List<Hospital> hospitals = new ArrayList<>();
		LOGGER.info("Fetching All Hospital Information{}", hospitals);
		hospitalService.getAllHospital().forEach(hospitals::add);
		return new ResponseEntity<List<Hospital>>(hospitals, HttpStatus.OK);
	}

	@ApiOperation(value = "Get hospital details on the basis of hospital ID",response = ResponseEntity.class)
	@RequestMapping(value = "/gethospid", method = RequestMethod.GET)
	public ResponseEntity<Hospital> findByHospitalId(@RequestParam String hospitalId) {
		LOGGER.info("Fetch Hospital Information with hospitalId {}", hospitalId);
		Hospital hospId = hospitalService.getHospitalId(hospitalId);
		if (hospId == null) {
			LOGGER.error("Fetching Hospital with HospitalID {} not found.", hospitalId);
			throw new HospitalNumberNotFoundException(
					HospitalExceptionErrorMessages.HOSPITAL_NUMBER_NOT_AVAILABLE.getErrMessage());
		} else {
			return new ResponseEntity<Hospital>(hospId, HttpStatus.OK);
		}

	}
	@ApiOperation(value = "Get hospital details on the basis of hospital name",response = ResponseEntity.class)
	@RequestMapping(value = "/gethospname", method = RequestMethod.GET)
	public ResponseEntity<Hospital> findByHospitalName(@RequestParam String name) {
		LOGGER.info("Fetch Hospital Information with hospitalName {}", name);
		Hospital hospitalName = hospitalService.getHospitalName(name);
		if (hospitalName == null) {
			LOGGER.error("Fetching Hospital with Hospita Name {} not found.", name);
			throw new HospitalNameNotFoundException(
					HospitalExceptionErrorMessages.HOSPITAL_NAME_NOT_AVAILABLE.getErrMessage());
		} else {
			return new ResponseEntity<Hospital>(hospitalName, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Update existing hospital details on the basis of hospital ID",response = ResponseEntity.class)
	@RequestMapping(value = "/updatehosp", method = RequestMethod.PUT)
	public ResponseEntity<String> updateHospital(@RequestBody Hospital hospital,
			@RequestParam("hospitalId") String hospitalId) {
		LOGGER.info("Updating Hospital Information with HospitaID {}", hospitalId);
		Hospital hospId = hospitalService.getHospitalId(hospitalId);
		if (hospId == null) {
			LOGGER.error("Unable to update.Hospital with HospitaID {} not found.", hospitalId);
			throw new HospitalNameNotFoundException(
					HospitalExceptionErrorMessages.HOSPITAL_NUMBER_NOT_AVAILABLE.getErrMessage());
		} else {
			hospitalService.updateHospital(hospital, hospitalId);
			return new ResponseEntity<String>("Hospital has been updated sucessfully", HttpStatus.OK);
		}

	}

}
