package org.hospital.msa.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class HospitalGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<HospitalExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		HospitalExceptionResponse exceResp = new HospitalExceptionResponse(ex.getMessage(),
				request.getDescription(false), new Date());
		return new ResponseEntity<>(exceResp, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(HospitalNameAlreadyExistException.class)
	public final ResponseEntity<HospitalExceptionResponse> handleHospitalNameAlreadyExistException(
			HospitalNameAlreadyExistException ex, WebRequest request) {
		HospitalExceptionResponse exceptionResponse = new HospitalExceptionResponse(ex.getMessage(),
				request.getDescription(false), new Date());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.FOUND);
	}

	@ExceptionHandler(HospitalNameNotFoundException.class)
	public final ResponseEntity<HospitalExceptionResponse> handlePatientHospitalNameNotFoundException(
			HospitalNameNotFoundException ex, WebRequest request) {
		HospitalExceptionResponse exceptionResponse = new HospitalExceptionResponse(ex.getMessage(),
				request.getDescription(false), new Date());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.FOUND);
	}

	@ExceptionHandler(HospitalNumberNotFoundException.class)
	public final ResponseEntity<HospitalExceptionResponse> handleHospitalNumberNotFoundException(
			HospitalNumberNotFoundException ex, WebRequest request) {
		HospitalExceptionResponse exceptionResponse = new HospitalExceptionResponse(ex.getMessage(),
				request.getDescription(false), new Date());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		HospitalExceptionResponse exceptionResponse = new HospitalExceptionResponse("Validation Failed",
				ex.getBindingResult().toString(), new Date());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
