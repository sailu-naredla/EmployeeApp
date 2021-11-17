/**
 * 
 */
package com.employee.service;

import com.employee.dto.EmployeeRequest;
import com.employee.dto.EmployeeResponse;
import com.employee.exception.DataNotFoundException;
import com.employee.exception.ServiceUnavailableException;

/**
 * @author snaredl
 *
 */
public interface EmployeeService {
	
	public EmployeeResponse getEmployeesByProject(String projectCode)
			throws DataNotFoundException,  ServiceUnavailableException;
	
	public boolean dissociateEmployeeFromProject(EmployeeRequest employeeRequest)
			throws DataNotFoundException,  ServiceUnavailableException;

}
