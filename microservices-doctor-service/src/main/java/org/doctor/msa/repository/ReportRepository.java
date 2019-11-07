package org.doctor.msa.repository;

import org.doctor.msa.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
	
	public Report findByReportId(String reportId);
	
	public Report findByDoctorName(String doctorName);
	
	public Report findByPatientName(String patientName);

}
