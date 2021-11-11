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
public class Department implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private int departId;
	
	@Column
	private String departCode;
	
	public int getDepartId() {
		return departId;
	}

	public void setDepartId(int departId) {
		this.departId = departId;
	}

	public String getDepartCode() {
		return departCode;
	}

	public void setDepartCode(String departCode) {
		this.departCode = departCode;
	}

}
