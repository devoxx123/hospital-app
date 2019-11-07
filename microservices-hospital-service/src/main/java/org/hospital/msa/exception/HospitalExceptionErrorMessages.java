package org.hospital.msa.exception;

public enum HospitalExceptionErrorMessages {
	INTERNAL_SERVER_ERROR("Something Went Wrong. Please Repeat This Operation Later !."),
	HOSPITAL_NAME_ALREADY_EXISTS(" Hospital Name is already exists.Please try with different Hospital Name !."), 
	HOSPITAL_NUMBER_NOT_AVAILABLE("Hospital Number not found in the database !."),
	HOSPITAL_NAME_NOT_AVAILABLE("Hospital Name not found in the database !.");


	private String errMessage;

	HospitalExceptionErrorMessages(String errorMessage) {
		this.errMessage = errorMessage;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}


}
