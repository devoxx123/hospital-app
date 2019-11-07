package org.doctor.msa.exception;

public enum ExceptionErrorMessage {
	INTERNAL_SERVER_ERROR("Something Went Wrong. Please Repeat This Operation Later !."),
	DOCTOR_NAME_ALREADY_EXISTS(" Doctor Name is already exists.Please try with different Doctor Name !."), 
	DOCTOR_NUMBER_NOT_AVAILABLE("Doctor Number not found in the database !."),
	DOCTOR_NAME_NOT_AVAILABLE("Doctor Name not found in the database !."),
	REPORT_NUMBER_NOT_AVAILABLE("Report Number not found in the database !."),
	PATIENT_NAME_NOT_AVAILABLE("Patient Name not found in the database !."),
	APPOINTMENT_NUMBER_NOT_AVAILABLE("Appointment Number not found in the database !."),
	PRESCRIPTION_NUMBER_NOT_AVAILABLE("Prescription Number not found in the database !.");
	
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
