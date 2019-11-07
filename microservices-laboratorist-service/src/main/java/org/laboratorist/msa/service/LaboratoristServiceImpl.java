package org.laboratorist.msa.service;

import java.util.List;

import org.laboratorist.msa.dto.BloodBankDTO;
import org.laboratorist.msa.dto.BloodDonorDTO;
import org.laboratorist.msa.mapper.BloodBankMapper;
import org.laboratorist.msa.mapper.BloodDonorMapper;
import org.laboratorist.msa.model.BloodBank;
import org.laboratorist.msa.model.BloodDonor;
import org.laboratorist.msa.repository.BloodBankRepository;
import org.laboratorist.msa.repository.BloodDonorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaboratoristServiceImpl implements LaboratoristService {

	private final Logger LOGGER = LoggerFactory.getLogger(LaboratoristServiceImpl.class);

	@Autowired
	private BloodDonorRepository bloodDonorRepository;

	@Autowired
	private BloodBankRepository bloodBankRepository;

	@Autowired(required=true)
	private BloodDonorMapper bloodDonorMapper;

	@Autowired(required=true)
	private BloodBankMapper bloodBankMapper;

	@Override
	public BloodDonorDTO postBloodDonor(BloodDonorDTO bloodDonorDTO) {
		String count = "1";
		BloodBank bloodBank = new BloodBank();
		BloodDonor bloodDonor = bloodDonorRepository
				.save(bloodDonorMapper.bloodDonorBoToBloodDonorEntity(bloodDonorDTO));
		bloodBank = bloodBankRepository.findByBloodGroup(bloodDonor.getBloodGroup());
		if (null != bloodBank) {
			bloodBank.setStatus(bloodBank.getStatus() + count);
			bloodBankRepository.save(bloodBank);
		} else {
			bloodBank = new BloodBank();
			bloodBank.setBloodGroup(bloodDonor.getBloodGroup());
			bloodBank.setStatus(count);
			bloodBankRepository.save(bloodBank);
		}
		return bloodDonorMapper.bloodDonorEntityToBloodDonorBo(bloodDonor);
	}

	@Override
	public List<BloodDonorDTO> getAllBloodDonors() {
		List<BloodDonor> bloodDonors = bloodDonorRepository.findAll();
		return bloodDonorMapper.bloodDonorEntitysToBloodDonorBos(bloodDonors);
	}

	@Override
	public BloodDonorDTO getBloodDonorByBdid(String bdid) {
		BloodDonor bloodDonor = bloodDonorRepository.findByBdid(bdid);
		return bloodDonorMapper.bloodDonorEntityToBloodDonorBo(bloodDonor);
	}

	@Override
	public BloodDonorDTO updateBloodDonor(BloodDonorDTO bloodDonorDTO, String bdid) {
		BloodDonor updatedBloodDonor = new BloodDonor();
		BloodDonor existingBloodDonor = bloodDonorRepository.findByBdid(bdid);
		if (null != existingBloodDonor) {
			existingBloodDonor.setAddress(bloodDonorDTO.getAddress());
			existingBloodDonor.setPhone(bloodDonorDTO.getPhone());
			existingBloodDonor.setEmail(bloodDonorDTO.getEmail());

			updatedBloodDonor = bloodDonorRepository.save(existingBloodDonor);
		}
		return bloodDonorMapper.bloodDonorEntityToBloodDonorBo(updatedBloodDonor);
	}

	@Override
	public void deleteBloodDonorByBdid(String bdid) {
		BloodDonor bloodDonor = bloodDonorRepository.findByBdid(bdid);
		if (null != bloodDonor) {
			bloodDonorRepository.delete(bloodDonor);
		}
	}

	@Override
	public List<BloodBankDTO> getAllBloodBankStatus() {
		List<BloodBank> bloodBankEntitys = bloodBankRepository.findAll();
		return bloodBankMapper.bloodBankEntitysToBloodBankBos(bloodBankEntitys);
	}

	@Override
	public BloodBankDTO updateBloodBank(BloodBankDTO bloodBankDTO) {
		LOGGER.info("Enter into updateBloodBank with status: " + bloodBankDTO.getStatus());
		BloodBank bloodBankEntity = new BloodBank();
		BloodBank excitingBloodBankEntity = bloodBankRepository.findByBloodGroup(bloodBankDTO.getBloodGroup());
		if (null != excitingBloodBankEntity) {
			excitingBloodBankEntity.setStatus(bloodBankDTO.getStatus());
			bloodBankEntity = bloodBankRepository.save(excitingBloodBankEntity);
		}
		LOGGER.info("Exit from updateBloodBank with status: " + excitingBloodBankEntity.getStatus());
		return bloodBankMapper.bloodBankEntityToBloodBankBo(bloodBankEntity);
	}
}
