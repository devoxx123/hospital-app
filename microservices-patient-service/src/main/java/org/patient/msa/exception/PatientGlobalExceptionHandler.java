package org.patient.msa.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class PatientGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<PatientExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		PatientExceptionResponse exceResp = new PatientExceptionResponse(ex.getMessage(), request.getDescription(false),
				new Date());
		return new ResponseEntity<>(exceResp, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(PatientNameAlreadyExistException.class)
	public final ResponseEntity<PatientExceptionResponse> handlePatientNameAlreadyExistException(
			PatientNameAlreadyExistException ex, WebRequest request) {
		PatientExceptionResponse exceptionResponse = new PatientExceptionResponse(ex.getMessage(),
				request.getDescription(false), new Date());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.FOUND);
	}

	@ExceptionHandler(PatientNameNotFoundException.class)
	public final ResponseEntity<PatientExceptionResponse> handlePatientNameNotFoundException(
			PatientNameNotFoundException ex, WebRequest request) {
		PatientExceptionResponse exceptionResponse = new PatientExceptionResponse(ex.getMessage(),
				request.getDescription(false), new Date());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.FOUND);
	}

	@ExceptionHandler(PatientNumberNotFoundException.class)
	public final ResponseEntity<PatientExceptionResponse> handlePatientNumberNotFoundException(
			PatientNumberNotFoundException ex, WebRequest request) {
		PatientExceptionResponse exceptionResponse = new PatientExceptionResponse(ex.getMessage(),
				request.getDescription(false), new Date());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		PatientExceptionResponse exceptionResponse = new PatientExceptionResponse("Validation Failed",
				ex.getBindingResult().toString(), new Date());
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
