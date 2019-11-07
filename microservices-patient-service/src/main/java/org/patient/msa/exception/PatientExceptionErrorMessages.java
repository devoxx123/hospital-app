package org.patient.msa.exception;

public enum PatientExceptionErrorMessages {
	INTERNAL_SERVER_ERROR("Something Went Wrong. Please Repeat This Operation Later !."),
	PATIENT_NAME_ALREADY_EXISTS(" Patient Name is already exists.Please try with different Patient Name !."), 
	PATIENT_NUMBER_NOT_AVAILABLE("Patient Number not found in the database !."),
	PATIENT_NAME_NOT_AVAILABLE("Patient Name not found in the database !.");


	private String errMessage;

	PatientExceptionErrorMessages(String errorMessage) {
		this.errMessage = errorMessage;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}


}
