
package org.dept.msa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dept.msa.exception.BillingNumberAlreadyExistException;
import org.dept.msa.exception.BillingNumberNotFoundException;
import org.dept.msa.exception.DepartmentNameAlreadyExistException;
import org.dept.msa.exception.DepartmentNameNotFoundException;
import org.dept.msa.exception.DepartmentNumberNotFoundException;
import org.dept.msa.exception.ExceptionErrorMessage;
import org.dept.msa.model.Billing;
import org.dept.msa.model.Department;
import org.dept.msa.service.DepartmentService;
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
@Api(value = "Hospital Management System", description = "Operations pertaining to Department in Hospital Management System")
public class DepartmentResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentResource.class);

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/depts")
	public String deptHMS() {
		String dept = "Welcome TO Department Status In Hospital Management " + new Date();
		LOGGER.info("Department Message " + dept);
		return dept;
	}

	@ApiOperation(value = "Create a new Department information", response = ResponseEntity.class)
	@RequestMapping(value = "/createdept", method = RequestMethod.POST)
	public ResponseEntity<String> saveDepartment(@RequestBody Department department) {
		LOGGER.info("Creating a new Department Information : {}", department);
		Department depts = departmentService.getDepartmentName(department.getDeptName());
		if (depts != null && depts.getDeptName() != null) {
			LOGGER.error("Creating a new Department Information A Billing with Department Name {} already exist",
					depts.getDeptName());
			throw new DepartmentNameAlreadyExistException(
					ExceptionErrorMessage.DEPARTMENT_NAME_ALREADY_EXISTS.getErrMessage());
		}
		departmentService.createDepartment(department);
		return new ResponseEntity<String>("Department Information has been added sucessfully", HttpStatus.CREATED);
	}

	@ApiOperation(value = "View a list of available depts", response = ResponseEntity.class)
	@RequestMapping(value = "/getalldepts", method = RequestMethod.GET)
	public ResponseEntity<List<Department>> listOfDepts() {
		List<Department> depts = new ArrayList<>();
		LOGGER.info("Fetching All Department Information{}", depts);
		departmentService.getAllDepartments().forEach(depts::add);
		return new ResponseEntity<List<Department>>(depts, HttpStatus.OK);

	}

	@ApiOperation(value = "Get Department details on the basis of Department Number", response = ResponseEntity.class)
	@RequestMapping(value = "/fetchbydeptid", method = RequestMethod.GET)
	public ResponseEntity<Department> findByDepartmentNumber(@RequestParam String deptId) {
		LOGGER.info("Fetch Department Information with Department Number {}", deptId);
		Department deptsId = departmentService.getDeptId(deptId);
		if (deptsId == null) {
			LOGGER.error("Fetching Department with Department Number {} not found.", deptsId);
			throw new DepartmentNumberNotFoundException(
					ExceptionErrorMessage.DEPARTMENT_NUMBER_NOT_AVAILABLE.getErrMessage());
		} else {
			return new ResponseEntity<Department>(deptsId, HttpStatus.OK);
		}
	}
	
	@ApiOperation(value = "Get Department details on the basis of Department Name", response = ResponseEntity.class)
	@RequestMapping(value = "/fetchbydeptname", method = RequestMethod.GET)
	public ResponseEntity<Department> findByDepartmentName(@RequestParam String deptName) {
		LOGGER.info("Fetch Department Information with Department Name {}", deptName);
		Department deptsName = departmentService.getDepartmentName(deptName);
		if (deptsName == null) {
			LOGGER.error("Fetching Department with Department Name {} not found.", deptsName);
			throw new DepartmentNameNotFoundException(
					ExceptionErrorMessage.DEPARTMENT_NAME_NOT_AVAILABLE.getErrMessage());
		} else {
			return new ResponseEntity<Department>(deptsName, HttpStatus.OK);
		}
	}
	
	
	@ApiOperation(value = "Update existing Department details on the basis of Department Number", response = ResponseEntity.class)
	@RequestMapping(value = "/updatedept", method = RequestMethod.PUT)
	public ResponseEntity<String> updateDepartment(@RequestBody Department department,
			@RequestParam("deptId") String deptId) {
		LOGGER.info("Updating Department Information with Department Number {}", deptId);
		Department deptNumber = departmentService.getDeptId(deptId);
		if (deptNumber == null) {
			LOGGER.error("Unable to update.Department with Department Number {} not found.", deptNumber);
			throw new DepartmentNumberNotFoundException(
					ExceptionErrorMessage.DEPARTMENT_NUMBER_NOT_AVAILABLE.getErrMessage());
		} else {
			departmentService.updateDepartment(department, deptId);
			return new ResponseEntity<String>("Department has been updated sucessfully", HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/deletebydeptid", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteByDeptId(@RequestParam("id") Long id) {
		LOGGER.info("Deleting Department Information with id {}", id);
		departmentService.deleteDeptId(id);
		return new ResponseEntity<String>("Department has been deleted sucessfully", HttpStatus.OK);
	}
}
