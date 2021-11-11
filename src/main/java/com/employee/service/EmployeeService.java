/**
 * 
 */
package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeRequest;
import com.employee.dto.EmployeeResponse;

/**
 * @author snaredl
 *
 */
public interface EmployeeService {
	
	public List<EmployeeResponse> getEmployeesByProject(String projectCode);
	
	public boolean dissociateEmployeeFromProject(EmployeeRequest employeeRequest);

}
