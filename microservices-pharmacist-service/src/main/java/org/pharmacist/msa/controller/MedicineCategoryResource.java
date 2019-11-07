/*package org.pharmacist.msa.controller;

import java.util.Date;
import java.util.List;

import org.pharmacist.msa.dto.MedicineCategoryDTO;
import org.pharmacist.msa.service.MedicineCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/vi")
@Api(value = "Hospital Management System", description = "Operations pertaining to MedicineCategory in Hospital Management System")
public class MedicineCategoryResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(MedicineCategoryResource.class);

	@Autowired
	private MedicineCategoryService medicineCategoryService;

	@GetMapping("/medicineategory")
	public String medicineCategoryHMS() {
		String medicineCategory = "Welcome TO MedicineCategory Status In Hospital Management " + new Date();
		LOGGER.info("MedicineCategory Message " + medicineCategory);
		return medicineCategory;
	}

	@RequestMapping(value = "/createmedicinecategory", method = RequestMethod.POST)
	public MedicineCategoryDTO postMedicineCategory(@RequestBody MedicineCategoryDTO medicineCategoryDTO) {
		return medicineCategoryService.createMedicineCategory(medicineCategoryDTO);
	}

	@RequestMapping(value = "/medicinecategorys", method = RequestMethod.GET)
	public List<MedicineCategoryDTO> getAllMedicineCategory() {
		return medicineCategoryService.getAllMedicineCategory();
	}

	@RequestMapping(value = "/getmedicinecategorybymdcid", method = RequestMethod.GET)
	public MedicineCategoryDTO getMedicineCategoryByMdcId(@RequestParam("mdcid") String mdcId) {
		return medicineCategoryService.getMedicineCategoryByMdcId(mdcId);
	}

	@RequestMapping(value = "/deletemedicinecategorybymdcid", method = RequestMethod.DELETE)
	public HttpStatus deleteMedicineCategoryByMdcId(@RequestParam("mdcid") String mdcId) {
		medicineCategoryService.deleteMedicineCategoryByMdcId(mdcId);
		return HttpStatus.OK;
	}

	@RequestMapping(value = "/updatemedicinecategory", method = RequestMethod.PUT)
	public MedicineCategoryDTO updateMedicineCategory(@RequestBody MedicineCategoryDTO medicineCategoryDTO,
			@RequestParam("mdcid") String mdcId) {
		return medicineCategoryService.updateMedicineCategory(medicineCategoryDTO, mdcId);
	}

}
*/