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
public class Project implements Serializable{
	
	private static final long serialVersionUID = 3L;

	@Id
	@Column
	private int projId;
	
	@Column
	private String projcode;

	public int getProjId() {
		return projId;
	}

	public void setProjId(int projId) {
		this.projId = projId;
	}

	public String getProjcode() {
		return projcode;
	}

	public void setProjcode(String projcode) {
		this.projcode = projcode;
	}

}
