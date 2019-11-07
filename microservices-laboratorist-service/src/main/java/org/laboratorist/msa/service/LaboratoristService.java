package org.laboratorist.msa.service;

import java.util.List;

import org.laboratorist.msa.dto.BloodBankDTO;
import org.laboratorist.msa.dto.BloodDonorDTO;

public interface LaboratoristService {

	public BloodDonorDTO postBloodDonor(BloodDonorDTO bloodDonorDTO);

	public List<BloodDonorDTO> getAllBloodDonors();

	public BloodDonorDTO getBloodDonorByBdid(String bdid);

	public BloodDonorDTO updateBloodDonor(BloodDonorDTO bloodDonorDTO, String bdid);

	public void deleteBloodDonorByBdid(String bdid);

	public List<BloodBankDTO> getAllBloodBankStatus();

	public BloodBankDTO updateBloodBank(BloodBankDTO bloodBankDTO);

}
