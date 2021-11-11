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
@Table(name="proj_dept_mapping")
public class ProjectDepartMpping {
	
	@Id
	@Column
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projeId")
    private Project project;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptId")
    private Department department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	
}
