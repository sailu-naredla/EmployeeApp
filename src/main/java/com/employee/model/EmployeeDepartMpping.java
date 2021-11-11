/**
 * 
 */
package com.employee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author snaredl
 *
 */
@Entity
@Table(name="emp_dept_mapping")
public class EmployeeDepartMpping implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empId")
    private Employee employee;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptId")
    private Department department;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	
}
