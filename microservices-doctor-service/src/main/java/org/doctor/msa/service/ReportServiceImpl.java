package org.doctor.msa.service;

import java.util.List;

import org.doctor.msa.model.Report;
import org.doctor.msa.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportRepository reportRepository;

	@Override
	public Report newReport(Report report) {
		return reportRepository.save(report);
	}

	@Override
	public List<Report> getAllReports() {
		return reportRepository.findAll();
	}

	@Override
	public Report getReportId(String reportId) {
		return reportRepository.findByReportId(reportId);
	}

	@Override
	public Report getDoctorName(String doctorName) {
		return reportRepository.findByDoctorName(doctorName);
	}

	@Override
	public Report updateReport(Report report, String reportId) {
		Report updateReport = new Report();
		Report existingreport = reportRepository.findByReportId(reportId);
		if (existingreport != null) {
			existingreport.setDoctorName(report.getDoctorName());
			existingreport.setReportType(report.getReportType());
			existingreport.setReportDesc(report.getReportDesc());
			existingreport.setPatientName(report.getPatientName());
			existingreport.setReportDate(report.getReportDate());
			updateReport = reportRepository.save(existingreport);
		}
		return updateReport;
	}

	@Override
	public Report getPatientName(String patientName) {
		return reportRepository.findByPatientName(patientName);
	}

}
