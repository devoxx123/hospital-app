package org.laboratorist.msa.mapper;

import java.util.List;

import org.laboratorist.msa.dto.BloodBankDTO;
import org.laboratorist.msa.model.BloodBank;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BloodBankMapper {
	public BloodBankDTO bloodBankEntityToBloodBankBo(BloodBank bloodBankEntity);

	public BloodBank bloodBankBoToBloodBankEntity(BloodBankDTO bloodBankDTO);
	
	public List<BloodBankDTO> bloodBankEntitysToBloodBankBos(List<BloodBank> bloodBankEntitys);

}
