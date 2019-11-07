package org.pharmacist.msa.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.pharmacist.msa.dto.MedicineDTO;
import org.pharmacist.msa.model.Medicine;

@Mapper(componentModel = "spring")
public interface MedicineMapper {

	public MedicineDTO medicinePojoToMedicineDTO(Medicine medicine);

	public Medicine medicineDTOToMedicinePojo(MedicineDTO medicineDTO);

	public List<MedicineDTO> medicinePojosToMedicineDTOs(List<Medicine> medicines);

	

}
