package org.doctor.msa.service;

import java.util.List;

import org.doctor.msa.model.Report;

public interface ReportService {

	public Report newReport(Report report);

	public List<Report> getAllReports();

	public Report getReportId(String reportId);
	
	public Report getDoctorName(String doctorName);
	
	public Report getPatientName(String patientName);

	public Report updateReport(Report report,String reportId);

	//public void deleteDoctorId(String doctorId);

}
