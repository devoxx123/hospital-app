package org.dept.msa.service;

import java.util.List;

import org.dept.msa.model.Department;

public interface DepartmentService {

	public Department createDepartment(Department department);

	public List<Department> getAllDepartments();

	public Department getDeptId(String deptId);
	
	public Department getDepartmentName(String deptName);

	public Department updateDepartment(Department department, String deptId);

	public void deleteDeptId(Long id);
	
	
	
}
