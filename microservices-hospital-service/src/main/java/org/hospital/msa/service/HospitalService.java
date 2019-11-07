package org.hospital.msa.service;


import java.util.List;

import org.hospital.msa.model.Hospital;

public interface HospitalService {

	public Hospital newHospital(Hospital hospital);

	public List<Hospital> getAllHospital();

	public Hospital getHospitalId(String hospitalId);
	
	public Hospital getHospitalName(String name);

	public Hospital updateHospital(Hospital hospital, String hospitalId);

}
