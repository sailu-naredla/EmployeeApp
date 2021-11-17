/**
 * 
 */
package com.employee.dto;

import java.util.List;

/**
 * @author snaredl
 *
 */
public class EmployeeResponse {
	
	List<EmployeeVo> list;

	public List<EmployeeVo> getList() {
		return list;
	}

	public void setList(List<EmployeeVo> list) {
		this.list = list;
	}
	
}
