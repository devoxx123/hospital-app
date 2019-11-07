package org.doctor.msa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.doctor.msa.exception.DoctorNameAlreadyExistException;
import org.doctor.msa.exception.DoctorNameNotFoundException;
import org.doctor.msa.exception.DoctorNumberNotFoundException;
import org.doctor.msa.exception.ExceptionErrorMessage;
import org.doctor.msa.exception.PatientNameNotFoundException;
import org.doctor.msa.exception.ReportNumberNotFoundException;
import org.doctor.msa.model.Doctor;
import org.doctor.msa.model.Report;
import org.doctor.msa.service.ReportService;
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
@Api(value = "Hospital Management System", description = "Operations pertaining to Report in Hospital Management System")
public class ReportResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReportResource.class);

	@Autowired
	private ReportService reportService;

	@GetMapping("/report")
	public String reportHMS() {
		String report = "Welcome TO Report Status In Hospital Management " + new Date();
		LOGGER.info("Report Message " + report);
		return report;
	}

	@ApiOperation(value = "Create a new Report information", response = ResponseEntity.class)
	@RequestMapping(value = "/savereport", method = RequestMethod.POST)
	public ResponseEntity<String> saveReport(@RequestBody Report report) {
		LOGGER.info("Creating a new Report Information : {}", report);
		Report repo = reportService.getDoctorName(report.getDoctorName());
		if (repo != null && repo.getDoctorName() != null) {
			LOGGER.error("Creating a new Report Information A Report with DoctorName {} already exist",
					report.getDoctorName());
			throw new DoctorNameAlreadyExistException(ExceptionErrorMessage.DOCTOR_NAME_ALREADY_EXISTS.getErrMessage());
		}
		reportService.newReport(report);
		return new ResponseEntity<String>("Report Information has been added sucessfully", HttpStatus.CREATED);
	}

	@ApiOperation(value = "View a list of available reports", response = ResponseEntity.class)
	@RequestMapping(value = "/listofreports", method = RequestMethod.GET)
	public ResponseEntity<List<Report>> findAllReports() {
		List<Report> reports = new ArrayList<>();
		LOGGER.info("Fetching All Report Informations{}", reports);
		reportService.getAllReports().forEach(reports::add);
		return new ResponseEntity<List<Report>>(reports, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Report details on the basis of Report ID", response = ResponseEntity.class)
	@RequestMapping(value = "/getreportid", method = RequestMethod.GET)
	public ResponseEntity<Report> findByReportId(@RequestParam String reportId) {
		LOGGER.info("Fetch Report Information with reportId {}", reportId);
		Report reporId = reportService.getReportId(reportId);
		if (reporId == null) {
			LOGGER.error("Fetching Report with reportId {} not found.", reporId);
			throw new ReportNumberNotFoundException(ExceptionErrorMessage.REPORT_NUMBER_NOT_AVAILABLE.getErrMessage());
		} else {
			return new ResponseEntity<Report>(reporId, HttpStatus.OK);
		}

	}

	@ApiOperation(value = "Get Report details on the basis of doctor name", response = ResponseEntity.class)
	@RequestMapping(value = "/getreportdoctorname", method = RequestMethod.GET)
	public ResponseEntity<Report> findByReportDoctorName(@RequestParam String doctorName) {
		LOGGER.info("Fetch Report Information with doctorName {}", doctorName);
		Report reportDoctName = reportService.getDoctorName(doctorName);
		if (reportDoctName == null) {
			LOGGER.error("Fetching Doctor with Doctor Name {} not found.", doctorName);
			throw new DoctorNameNotFoundException(ExceptionErrorMessage.DOCTOR_NAME_NOT_AVAILABLE.getErrMessage());
		} else {
			return new ResponseEntity<Report>(reportDoctName, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Get Report details on the basis of patient name", response = ResponseEntity.class)
	@RequestMapping(value = "/getreportpatientname", method = RequestMethod.GET)
	public ResponseEntity<Report> findByReportPatientName(@RequestParam String patientName) {
		LOGGER.info("Fetch Report Information with patient Name {}", patientName);
		Report reportPatientName = reportService.getPatientName(patientName);
		if (reportPatientName == null) {
			LOGGER.error("Fetching Report with patient Name {} not found.", patientName);
			throw new PatientNameNotFoundException(ExceptionErrorMessage.PATIENT_NAME_NOT_AVAILABLE.getErrMessage());
		} else {
			return new ResponseEntity<Report>(reportPatientName, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Update existing Report details on the basis of report ID", response = ResponseEntity.class)
	@RequestMapping(value = "/updatereport", method = RequestMethod.PUT)
	public ResponseEntity<String> updateReport(@RequestBody Report report, @RequestParam("reportId") String reportId) {
		LOGGER.info("Updating Report Information with reportId {}", reportId);
		Report reporId = reportService.getReportId(reportId);
		if (reporId == null) {
			LOGGER.error("Unable to update.Report with reporId {} not found.", reporId);
			throw new ReportNumberNotFoundException(ExceptionErrorMessage.REPORT_NUMBER_NOT_AVAILABLE.getErrMessage());
		} else {
			reportService.updateReport(report, reportId);
			return new ResponseEntity<String>("Report has been updated sucessfully", HttpStatus.OK);
		}

	}
}
