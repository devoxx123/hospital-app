
package org.laboratorist.msa.controller;

import java.util.Date;
import java.util.List;

import org.laboratorist.msa.dto.BloodBankDTO;
import org.laboratorist.msa.dto.BloodDonorDTO;
import org.laboratorist.msa.service.LaboratoristService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Hospital Management System", description = "Operations pertaining to Laboratorist in Hospital Management System")
public class LaboratoristResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(LaboratoristResource.class);

	@Autowired(required=true)
	private LaboratoristService laboratoristService;

	@GetMapping("/lab")
	public String laboratoristHMS() {
		String lab = "Welcome TO Laboratorist Status In Hospital Management " + new Date();
		LOGGER.info("Laboratorist Message " + lab);
		return lab;
	}

	@RequestMapping(value = "/createbloodonor", method = RequestMethod.POST)
	public BloodDonorDTO createBloodDonor(@RequestBody BloodDonorDTO bloodDonorDTO) {
		return laboratoristService.postBloodDonor(bloodDonorDTO);
	}

	@RequestMapping(value = "/getallblooddonor", method = RequestMethod.GET)
	public List<BloodDonorDTO> getAllBloodDonor() {
		return laboratoristService.getAllBloodDonors();
	}

	@RequestMapping(value = "/getblooddonorbybdid", method = RequestMethod.GET)
	public BloodDonorDTO getBloodDonorByBdid(@RequestParam(value = "bdid", required = true) String bdid) {
		return laboratoristService.getBloodDonorByBdid(bdid);
	}

	@RequestMapping(value = "/updateblooddonor", method = RequestMethod.PUT)
	public BloodDonorDTO updateBloodDonor(@RequestBody BloodDonorDTO bloodDonorDTO,
			@RequestParam(value = "bdid", required = true) String bdid) {
		return laboratoristService.updateBloodDonor(bloodDonorDTO, bdid);
	}

	@RequestMapping(value = "/deleteblooddonorbybdid", method = RequestMethod.DELETE)
	public HttpStatus deleteBloodDonorByBdid(@RequestParam(value = "bdid", required = true) String bdid) {
		laboratoristService.deleteBloodDonorByBdid(bdid);
		return HttpStatus.OK;
	}

	@RequestMapping(value = "/getallbloodbankstatus", method = RequestMethod.GET)
	public List<BloodBankDTO> getAllBloodBankStatus() {
		return laboratoristService.getAllBloodBankStatus();
	}

	@RequestMapping(value = "/updatebloodbank/{bloodGroup}", method = RequestMethod.PUT)
	public BloodBankDTO putBloodBank(@RequestBody BloodBankDTO bloodBankDTO,
			@PathVariable(value = "bloodGroup") String bloodGroup) {
		bloodBankDTO.setBloodGroup(bloodGroup);
		return laboratoristService.updateBloodBank(bloodBankDTO);
	}

}
