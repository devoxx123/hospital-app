package org.dept.msa.service;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.dept.msa.model.Department;
import org.dept.msa.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department createDepartment(Department department) {
		department.setDeptId(RandomStringUtils.randomNumeric(8));
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department getDeptId(String departmentId) {
		return departmentRepository.findByDeptId(departmentId);
	}

	@Override
	public Department getDepartmentName(String deptName) {
		return departmentRepository.findByDeptName(deptName);
	}
	
	@Override
	public Department updateDepartment(Department department, String deptId) {
		Department responseDept = new Department();
		Department existingDept = departmentRepository.findByDeptId(deptId);
		if (null != existingDept) {
			existingDept.setDeptName(department.getDeptName());
			existingDept.setDeptInchargeName(department.getDeptInchargeName());
			existingDept.setDeptStaff(department.getDeptStaff());
			existingDept.setDeptFloor(department.getDeptFloor());
			existingDept.setDeptDescription(department.getDeptDescription());
			responseDept = departmentRepository.save(existingDept);
		}
		return responseDept;
	}

	@Override
	public void deleteDeptId(Long id) {
		departmentRepository.deleteById(id);
	}

	

}
