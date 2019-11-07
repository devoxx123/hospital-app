package org.dept.msa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENT_TBL")
public class Department implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String deptId;
	private String deptName;
	private String deptInchargeName;
	private String deptStaff;
	private String deptFloor;
	private String deptDescription;

	public Department() {
	}

	public Department(Long id, String deptId, String deptName, String deptInchargeName, String deptStaff,
			String deptFloor, String deptDescription) {
		super();
		this.id = id;
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptInchargeName = deptInchargeName;
		this.deptStaff = deptStaff;
		this.deptFloor = deptFloor;
		this.deptDescription = deptDescription;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptInchargeName() {
		return deptInchargeName;
	}

	public void setDeptInchargeName(String deptInchargeName) {
		this.deptInchargeName = deptInchargeName;
	}

	public String getDeptStaff() {
		return deptStaff;
	}

	public void setDeptStaff(String deptStaff) {
		this.deptStaff = deptStaff;
	}

	public String getDeptFloor() {
		return deptFloor;
	}

	public void setDeptFloor(String deptFloor) {
		this.deptFloor = deptFloor;
	}

	public String getDeptDescription() {
		return deptDescription;
	}

	public void setDeptDescription(String deptDescription) {
		this.deptDescription = deptDescription;
	}

}
