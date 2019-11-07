
package org.dept.msa.repository;

import org.dept.msa.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	public Department findByDeptId(String deptId);

	public Department findByDeptName(String deptName);

	public String deleteByDeptId(String deptId);
}
