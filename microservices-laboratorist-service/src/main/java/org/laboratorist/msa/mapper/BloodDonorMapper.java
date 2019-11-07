package org.laboratorist.msa.mapper;

import java.util.List;

import org.laboratorist.msa.dto.BloodDonorDTO;
import org.laboratorist.msa.model.BloodDonor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BloodDonorMapper {

	public BloodDonorDTO bloodDonorEntityToBloodDonorBo(BloodDonor bloodDonor);

	public BloodDonor bloodDonorBoToBloodDonorEntity(BloodDonorDTO bloodDonorDTO);

	public List<BloodDonorDTO> bloodDonorEntitysToBloodDonorBos(List<BloodDonor> bloodDonors);

}
