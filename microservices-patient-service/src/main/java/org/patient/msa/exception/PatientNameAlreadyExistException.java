package org.patient.msa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PatientNameAlreadyExistException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PatientNameAlreadyExistException(String exception) {
		super(exception);
	}

}
