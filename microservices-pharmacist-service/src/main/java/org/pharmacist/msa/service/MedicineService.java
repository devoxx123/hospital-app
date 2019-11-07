package org.pharmacist.msa.service;

import java.util.List;

import org.pharmacist.msa.dto.MedicineCategoryDTO;
import org.pharmacist.msa.dto.MedicineDTO;
import org.springframework.stereotype.Service;

public interface MedicineService {
	
	public MedicineDTO createMedicine(MedicineDTO medicineDTO);

	public List<MedicineDTO> getAllMedicines();

	public MedicineDTO getMedicineByMdId(String mdId);

	public MedicineDTO updateMedicine(MedicineDTO medicineBo, String mdId);

	public void deleteMedicineByMdId(String mdId);

}
