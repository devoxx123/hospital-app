package org.pharmacist.msa.service;

import java.util.List;

import org.pharmacist.msa.dto.MedicineDTO;
import org.pharmacist.msa.mapper.MedicineMapper;
import org.pharmacist.msa.model.Medicine;
import org.pharmacist.msa.repository.MedicineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineServiceImpl implements MedicineService {

	private final Logger LOGGER = LoggerFactory.getLogger(MedicineServiceImpl.class);

	@Autowired
	private MedicineRepository medicineRepository;

	//@Autowired
	private MedicineMapper medicineMapper;
	
	@Autowired
	public MedicineServiceImpl(MedicineMapper medicineMapper) {
		this.medicineMapper = medicineMapper;
	}
	

	@Override
	public MedicineDTO createMedicine(MedicineDTO medicineDTO) {
		LOGGER.info("Enter into create medicine with medicine name: " + medicineDTO.getMedicineName());
		Medicine medicine = medicineRepository.save(medicineMapper.medicineDTOToMedicinePojo(medicineDTO));
		LOGGER.info("medicine details saved with medicine name:  " + medicine.getMedicineName());
		return medicineMapper.medicinePojoToMedicineDTO(medicine);
	}

	@Override
	public List<MedicineDTO> getAllMedicines() {
		LOGGER.info("Enter into get all medicines");
		List<Medicine> medicines = medicineRepository.findAll();
		LOGGER.info("Exit from get all medicines and the number of medicine's are: " + medicines.size());
		return medicineMapper.medicinePojosToMedicineDTOs(medicines);
	}

	@Override
	public MedicineDTO getMedicineByMdId(String mdId) {
		LOGGER.info("Enter into get medicines by medicine Id" + mdId);
		Medicine existingMedicine = medicineRepository.findByMedicineId(mdId);
		LOGGER.info("Exit from get medicines by medicine id: " + existingMedicine.getMedicineId());
		return medicineMapper.medicinePojoToMedicineDTO(existingMedicine);
	}

	@Override
	public MedicineDTO updateMedicine(MedicineDTO medicineDTO, String mdId) {
		Medicine existingMedicine = medicineRepository.findByMedicineId(mdId);
		LOGGER.info("Enter into update medicines by medicine Id" + mdId);
		if (null != existingMedicine) {
			existingMedicine.setMedicineName(medicineDTO.getMedicineName());
			existingMedicine.setDescription(medicineDTO.getDescription());
			existingMedicine.setCost(medicineDTO.getCost());
			existingMedicine.setMedicineCategory(medicineDTO.getMedicineCategory());
			existingMedicine.setManufacturing(medicineDTO.getManufacturing());
			existingMedicine.setStatus(medicineDTO.getStatus());
			medicineRepository.save(existingMedicine);
			LOGGER.info("Exit from update medicines ");
		}
		return medicineMapper.medicinePojoToMedicineDTO(existingMedicine);

	}

	@Override
	public void deleteMedicineByMdId(String mdId) {
		Medicine existingMedicineEntity = medicineRepository.findByMedicineId(mdId);
		LOGGER.info("Enter into delete medicines by medicine Id" + mdId);
		if (null != existingMedicineEntity) {
			medicineRepository.delete(existingMedicineEntity);
			LOGGER.info("Exit from delete medicines ");
		}
	}

}
