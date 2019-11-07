package org.doctor.msa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PatientNameNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PatientNameNotFoundException(String exception) {
		super(exception);
	}

}
