/*package org.pharmacist.msa.service;

import java.util.List;

import org.pharmacist.msa.dto.MedicineCategoryDTO;
import org.pharmacist.msa.mapper.MedicineCategoryMapper;
import org.pharmacist.msa.model.MedicineCategory;
import org.pharmacist.msa.repository.MedicineCategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MedicineCategoryServiceImpl implements MedicineCategoryService {

	private final Logger LOGGER = LoggerFactory.getLogger(MedicineCategoryServiceImpl.class);

	@Autowired
	private MedicineCategoryRepository medicineCategoryRepository;

	@Autowired
	private MedicineCategoryMapper medicineCategoryMapper;

	@Override
	public MedicineCategoryDTO createMedicineCategory(MedicineCategoryDTO medicineCategoryDTO) {
		LOGGER.info("Enter into create medicine category with medicine name: "
				+ medicineCategoryDTO.getMedicineCategoryName());
		MedicineCategory medicineCategory = medicineCategoryRepository
				.save(medicineCategoryMapper.medicineCategoryDTOToMedicineCategoryPojo(medicineCategoryDTO));
		LOGGER.info(
				"medicine details saved with medicine category name:  " + medicineCategory.getMedicineCategoryName());
		return medicineCategoryMapper.medicineCategoryPojoToMedicineCategoryDTO(medicineCategory);
	}

	@Override
	public List<MedicineCategoryDTO> getAllMedicineCategory() {
		LOGGER.info("Enter into get all medicines category");
		List<MedicineCategory> MedicineCategorys = medicineCategoryRepository.findAll();
		LOGGER.info("Exit from get all medicines category and the number of medicine categories are: "
				+ MedicineCategorys.size());
		return medicineCategoryMapper.medicineCategoryPjosToMedicineCategoryDTOs(MedicineCategorys);
	}

	@Override
	public MedicineCategoryDTO getMedicineCategoryByMdcId(String mdcId) {
		LOGGER.info("Enter into get medicines category by medicine category Id" + mdcId);
		MedicineCategory medicineCategory = medicineCategoryRepository.findById(mdcId);
		LOGGER.info("Exit from get  medicines category by medicine category id: " + medicineCategory.getId());
		return medicineCategoryMapper.medicineCategoryPojoToMedicineCategoryDTO(medicineCategory);
	}

	@Override
	public MedicineCategoryDTO updateMedicineCategory(MedicineCategoryDTO medicineCategoryDTO, String mdcId) {
		MedicineCategory medicineCategory = medicineCategoryRepository.findById(mdcId);
		LOGGER.info("Enter into update medicines category by medicine category Id" + mdcId);
		if (null != medicineCategory) {
			medicineCategory.setMedicineCategoryName(medicineCategoryDTO.getMedicineCategoryName());
			medicineCategory.setDescription(medicineCategoryDTO.getDescription());
			medicineCategoryRepository.save(medicineCategory);
			LOGGER.info("Exit from update medicines category");
		}
		return medicineCategoryMapper.medicineCategoryPojoToMedicineCategoryDTO(medicineCategory);

	}

	@Override
	public void deleteMedicineCategoryByMdcId(String mdcId) {
		MedicineCategory medicineCategory = medicineCategoryRepository.findById(mdcId);
		LOGGER.info("Enter into delete medicines category by medicine category Id" + mdcId);
		if (null != medicineCategory) {
			medicineCategoryRepository.delete(medicineCategory);
			LOGGER.info("Exit from delete medicines category");
		}
	}
}
*/