
package org.pharmacist.msa.controller;

import java.util.Date;
import java.util.List;

import org.pharmacist.msa.dto.MedicineCategoryDTO;
import org.pharmacist.msa.dto.MedicineDTO;
import org.pharmacist.msa.service.MedicineService;
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
@Api(value = "Hospital Management System", description = "Operations pertaining to Medician in Hospital Management System")
public class MedicianResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(MedicianResource.class);

	@Autowired
	private MedicineService medicineService;

	@GetMapping("/medician")
	public String MedicianHMS() {
		String medician = "Welcome TO Medician Status In Hospital Management " + new Date();
		LOGGER.info("Medician Message " + medician);
		return medician;
	}
	
	@RequestMapping(value = "/createmedicine", method = RequestMethod.POST)
	public MedicineDTO postMedicine(@RequestBody MedicineDTO medicineDTO) {
		return medicineService.createMedicine(medicineDTO);
	}

	@RequestMapping(value = "/medicines", method = RequestMethod.GET)
	public List<MedicineDTO> getAllMedicines() {
		return medicineService.getAllMedicines();
	}

	@RequestMapping(value = "/getmedicinebymdid", method = RequestMethod.GET)
	public MedicineDTO getMedicineByMdId(@RequestParam("mdid") String mdId) {
		return medicineService.getMedicineByMdId(mdId);
	}

	@RequestMapping(value = "/updatemedicine", method = RequestMethod.PUT)
	public MedicineDTO updateMedicine(@RequestBody MedicineDTO medicineDTO, @RequestParam("mdid") String mdId) {
		return medicineService.updateMedicine(medicineDTO, mdId);
	}

	@RequestMapping(value = "/deletemedicinebymdid", method = RequestMethod.DELETE)
	public HttpStatus deleteMedicineByMdId(@RequestParam("mdid") String mdId) {
		medicineService.deleteMedicineByMdId(mdId);
		return HttpStatus.OK;
	}

}
