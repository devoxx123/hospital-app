package org.dept.msa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dept.msa.exception.BillingNumberAlreadyExistException;
import org.dept.msa.exception.BillingNumberNotFoundException;
import org.dept.msa.exception.ExceptionErrorMessage;
import org.dept.msa.model.Billing;
import org.dept.msa.service.BillingService;
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
@Api(value = "Hospital Management System", description = "Operations pertaining to Billing in Hospital Management System")
public class BillingResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(BillingResource.class);

	@Autowired
	private BillingService billingService;

	@GetMapping("/billings")
	public String billingHMS() {
		String billing = "Welcome TO Billing Status In Hospital Management " + new Date();
		LOGGER.info("Billing Message " + billing);
		return billing;
	}

	@ApiOperation(value = "Create a new Billing information", response = ResponseEntity.class)
	@RequestMapping(value = "/createbilling", method = RequestMethod.POST)
	public ResponseEntity<String> createBilling(@RequestBody Billing billing) {
		LOGGER.info("Creating a new Billing Information : {}", billing);
		Billing billings = billingService.fetchByBillingNumber(billing.getBillNumber());
		if (billings != null && billings.getBillNumber() != null) {
			LOGGER.error("Creating a new Billing Information A Billing with Billing Number {} already exist",
					billings.getBillNumber());
			throw new BillingNumberAlreadyExistException(
					ExceptionErrorMessage.BILLING_NUMBER_ALREADY_EXISTS.getErrMessage());
		}
		billingService.saveBilling(billing);
		return new ResponseEntity<String>("Billing Information has been added sucessfully", HttpStatus.CREATED);
	}

	@ApiOperation(value = "View a list of available billings", response = ResponseEntity.class)
	@RequestMapping(value = "/getallbillings", method = RequestMethod.GET)
	public ResponseEntity<List<Billing>> findAllBillings() {
		List<Billing> billings = new ArrayList<>();
		LOGGER.info("Fetching All Billing Informations{}", billings);
		billingService.listOfBillings().forEach(billings::add);
		return new ResponseEntity<List<Billing>>(billings, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Billing details on the basis of Billing Number", response = ResponseEntity.class)
	@RequestMapping(value = "/getbillnumber", method = RequestMethod.GET)
	public ResponseEntity<Billing> findByBillNumber(@RequestParam String billNumber) {
		LOGGER.info("Fetch Billing Information with Billing Number {}", billNumber);
		Billing billingNumber = billingService.fetchByBillingNumber(billNumber);
		if (billingNumber == null) {
			LOGGER.error("Fetching Billing with Billing Number {} not found.", billingNumber);
			throw new BillingNumberNotFoundException(
					ExceptionErrorMessage.BILLING_NUMBER_NOT_AVAILABLE.getErrMessage());
		} else {
			return new ResponseEntity<Billing>(billingNumber, HttpStatus.OK);
		}

	}

	@ApiOperation(value = "Update existing Billing details on the basis of Billing Number", response = ResponseEntity.class)
	@RequestMapping(value = "/updatebilling", method = RequestMethod.PUT)
	public ResponseEntity<String> updateBilling(@RequestBody Billing billing,
			@RequestParam("billNumber") String billNumber) {
		LOGGER.info("Updating Billing Information with Bill Number {}", billNumber);
		Billing billingNumber = billingService.fetchByBillingNumber(billNumber);
		if (billingNumber == null) {
			LOGGER.error("Unable to update.Billing with billing Number {} not found.", billingNumber);
			throw new BillingNumberNotFoundException(
					ExceptionErrorMessage.BILLING_NUMBER_NOT_AVAILABLE.getErrMessage());
		} else {
			billingService.billingUpdate(billing, billNumber);
			return new ResponseEntity<String>("Billing has been updated sucessfully", HttpStatus.OK);
		}

	}
}
