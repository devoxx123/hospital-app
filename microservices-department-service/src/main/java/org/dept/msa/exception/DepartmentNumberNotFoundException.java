package org.dept.msa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepartmentNumberNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DepartmentNumberNotFoundException(String exception) {
		super(exception);
	}

}
