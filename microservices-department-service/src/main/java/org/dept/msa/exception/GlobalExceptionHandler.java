package org.dept.msa.exception;

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
		ExceptionResponse exceResp = new ExceptionResponse(ex.getMessage(), request.getDescription(false), new Date());
		return new ResponseEntity<>(exceResp, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(DepartmentNameAlreadyExistException.class)
	public final ResponseEntity<ExceptionResponse> handleDepartmentNameAlreadyExistException(
			DepartmentNameAlreadyExistException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false),
				new Date());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.FOUND);
	}

	@ExceptionHandler(DepartmentNameNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleDepartmentNameNotFoundException(
			DepartmentNameNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false),
				new Date());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.FOUND);
	}

	@ExceptionHandler(DepartmentNumberNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleDepartmentNumberNotFoundException(
			DepartmentNumberNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false),
				new Date());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.FOUND);
	}

	@ExceptionHandler(BillingNumberNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleBillingNumberNotFoundException(
			BillingNumberNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false),
				new Date());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.FOUND);
	}
	
	@ExceptionHandler(BillingNumberAlreadyExistException.class)
	public final ResponseEntity<ExceptionResponse> handleBillingNumberAlreadyExistException(
			BillingNumberAlreadyExistException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false),
				new Date());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse("Validation Failed",
				ex.getBindingResult().toString(), new Date());
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
