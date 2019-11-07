package org.doctor.msa.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceResp = new ExceptionResponse(ex.getMessage(), request.getDescription(false),
				new Date());
		return new ResponseEntity<>(exceResp, HttpStatus.INTERNAL_SERVER_ERROR);

	}
    //DOCTOR EXCEPTION HANDLING
	@ExceptionHandler(DoctorNameAlreadyExistException.class)
	public final ResponseEntity<ExceptionResponse> handleDoctorNameAlreadyExistException(
			DoctorNameAlreadyExistException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(),
				request.getDescription(false), new Date());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.FOUND);
	}
	
	@ExceptionHandler(DoctorNumberNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleDoctorNumberNotFoundException(
			DoctorNumberNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(),
				request.getDescription(false), new Date());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.FOUND);
	}
	
	//REPORT EXCEPTION HANDLING
	
	

	/*@ExceptionHandler(DepartmentNameNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleDepartmentNameNotFoundException(
			DepartmentNameNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(),
				request.getDescription(false), new Date());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.FOUND);
	}*/

	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse("Validation Failed",
				ex.getBindingResult().toString(), new Date());
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
