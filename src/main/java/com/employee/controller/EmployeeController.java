/**
 * 
 */
package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeRequest;
import com.employee.dto.EmployeeResponse;
import com.employee.service.EmployeeService;

/**
 * @author snaredl
 *
 */
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee/{projectCode}")
	private List<EmployeeResponse> getEmployeesByProject(@PathVariable("projectCode") String projectCode) {
		return employeeService.getEmployeesByProject(projectCode);
	}
	
	@PostMapping("/employee")
	private boolean dissociateEmployeeFromProject(@RequestBody EmployeeRequest employeeRequest) {
		return employeeService.dissociateEmployeeFromProject(employeeRequest);
	}

}
