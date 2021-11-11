/**
 * 
 */
package com.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeRequest;
import com.employee.dto.EmployeeResponse;
import com.employee.model.Employee;
import com.employee.model.EmployeeProjectMpping;
import com.employee.model.Project;
import com.employee.repository.EmployeeProjectRepository;
import com.employee.repository.EmployeeRepository;
import com.employee.repository.ProjectRepository;
import com.employee.service.EmployeeService;

/**
 * @author snaredl
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	EmployeeProjectRepository employeeProjectRepository;
	
	
	@Override
	public List<EmployeeResponse> getEmployeesByProject(String projectCode) {
		 LOGGER.info("Entering getEmployeesByProject()");
		 
		 List<EmployeeResponse> employees = new ArrayList<EmployeeResponse>();
		 try {		 
			 Project project = projectRepository.findProjectByCode(projectCode);
			 LOGGER.info(project.getProjcode());
			 
			 List<EmployeeProjectMpping> projectMppings = employeeProjectRepository.findAll(project);
			 if(null != projectMppings && !projectMppings.isEmpty()){
				 LOGGER.info("empcode:"+projectMppings.get(0).getEmployee().getEmpcode());
				 for(EmployeeProjectMpping mpping : projectMppings){
					 EmployeeResponse employeeResponse = new EmployeeResponse();
						employeeResponse.setEmpcode(mpping.getEmployee().getEmpcode());
						employeeResponse.setEmpId(mpping.getEmployee().getEmpId());
						employees.add(employeeResponse);
				 }
			 }
		 } catch(Exception ex){
			 LOGGER.error("Error while retreiving employees of project ", ex);
		}
		LOGGER.info("Exiting getEmployeesByProject()");
		return employees;
	}

	@Override
	public boolean dissociateEmployeeFromProject(EmployeeRequest employeeRequest) {
		
		boolean status =  false;
		try {
			 Project project = projectRepository.findProjectByCode(employeeRequest.getProjectCode());
			 LOGGER.info(project.getProjcode());
			 
			 Employee employee = employeeRepository.findEmployeeByCode(employeeRequest.getEmpCode());
			 LOGGER.info(employee.getEmpcode());
			
			 EmployeeProjectMpping projectMpping = employeeProjectRepository.findByEmployeeAndProject(employee, project);
			 employeeProjectRepository.delete(projectMpping);
			 status = true;
		} catch(Exception ex){
			 LOGGER.error("Error while disassociatig employee from project ", ex);
		}
		LOGGER.info("Exiting getEmployeesByProject()");
		
		return status;
	}

}
