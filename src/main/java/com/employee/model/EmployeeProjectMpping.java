/**
 * 
 */
package com.employee.model;

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
@Table(name="emp_proj_mapping")
public class EmployeeProjectMpping {
	
	@Id
	@Column
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empId")
    private Employee employee;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projId")
    private Project project;

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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	

}
