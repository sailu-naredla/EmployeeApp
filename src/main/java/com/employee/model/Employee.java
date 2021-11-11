/**
 * 
 */
package com.employee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author snaredl
 *
 */
@Entity
@Table
public class Employee implements Serializable{

	private static final long serialVersionUID = 2L;

	@Id
	@Column
	private int empId;
	
	@Column
	private String empcode ;
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpcode() {
		return empcode;
	}

	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}

}
