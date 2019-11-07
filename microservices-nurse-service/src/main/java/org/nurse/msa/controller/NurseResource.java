
package org.nurse.msa.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Hospital Management System", description = "Operations pertaining to Nurse in Hospital Management System")
public class NurseResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(NurseResource.class);

	@GetMapping("/nurse")
	public String nurseHMS() {
		String nurse = "Welcome TO Nurse Status In Hospital Management " + new Date();
		LOGGER.info("Nurse Message " + nurse);
		return nurse;
	}

}
