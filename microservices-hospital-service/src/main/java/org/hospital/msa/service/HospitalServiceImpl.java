package org.hospital.msa.service;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.hospital.msa.model.Hospital;
import org.hospital.msa.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Override
	public Hospital newHospital(Hospital hospital) {
		hospital.setHospitalId(RandomStringUtils.randomNumeric(9));
		return hospitalRepository.save(hospital);
	}

	@Override
	public List<Hospital> getAllHospital() {
		return hospitalRepository.findAll();
	}

	@Override
	public Hospital getHospitalId(String hospitalId) {
		return hospitalRepository.findByHospitalId(hospitalId);
	}
	
	@Override
	public Hospital getHospitalName(String name) {
		return hospitalRepository.findByName(name);
	}

	@Override
	public Hospital updateHospital(Hospital hospital, String hospitalId) {
		Hospital requestHosp = new Hospital();
		Hospital existingHosp = hospitalRepository.findByHospitalId(hospitalId);
		if (null != existingHosp) {
			existingHosp.setName(hospital.getName());
			existingHosp.setAddress(hospital.getAddress());
			existingHosp.setCity(hospital.getCity());
			existingHosp.setState(hospital.getState());
			existingHosp.setType(hospital.getType());
			existingHosp.setTelephone(hospital.getTelephone());
			existingHosp.setEmail(hospital.getEmail());
			existingHosp.setFax(hospital.getFax());
			existingHosp.setWebsite(hospital.getWebsite());
			existingHosp.setReview(hospital.getReview());
			existingHosp.setRank(hospital.getRank());
			requestHosp = hospitalRepository.save(existingHosp);
		}
		return requestHosp;
	}

}
