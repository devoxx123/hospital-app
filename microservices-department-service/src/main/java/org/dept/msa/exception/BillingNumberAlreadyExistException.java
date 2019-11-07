package org.dept.msa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BillingNumberAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BillingNumberAlreadyExistException(String exception) {
		super(exception);
	}

}
