package org.dept.msa.exception;

public enum ExceptionErrorMessage {
	INTERNAL_SERVER_ERROR("Something Went Wrong. Please Repeat This Operation Later !."),
	DEPARTMENT_NAME_ALREADY_EXISTS(" Department Name is already exists.Please try with different Department Name !."), 
	DEPARTMENT_NUMBER_NOT_AVAILABLE("Department Number not found in the database !."),
	DEPARTMENT_NAME_NOT_AVAILABLE("Department Name not found in the database !."),
	BILLING_NUMBER_NOT_AVAILABLE("Billing Number not found in the database"),
	BILLING_NUMBER_ALREADY_EXISTS(" Billing Number is already exists.Please try with different Billing Number !.");


	private String errMessage;
	
	ExceptionErrorMessage(String errorMessage) {
		this.errMessage = errorMessage;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}


}
