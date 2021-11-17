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
import org.springframework.web.client.ResourceAccessException;

import com.employee.dto.EmployeeRequest;
import com.employee.dto.EmployeeResponse;
import com.employee.dto.EmployeeVo;
import com.employee.exception.DataNotFoundException;
import com.employee.exception.ServiceUnavailableException;
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
	public EmployeeResponse getEmployeesByProject(String projectCode) 
			throws DataNotFoundException,  ServiceUnavailableException{
		
		EmployeeResponse response = new EmployeeResponse();
		
		String logPrefix = EmployeeServiceImpl.class.toString() + ":: getEmployeesByProject()::";
		 LOGGER.info(logPrefix+"Entering getEmployeesByProject()");
		 
		 List<EmployeeVo> employees = new ArrayList<EmployeeVo>();
		 try {		 
			 Project project = projectRepository.findProjectByCode(projectCode);
			 if(null == project){
				 throw new DataNotFoundException("Requested Project Not Found");
			 }
			 LOGGER.info(logPrefix+project.getProjcode());
			 List<EmployeeProjectMpping> projectMppings = employeeProjectRepository.findAll(project);
			 if(null != projectMppings && !projectMppings.isEmpty()){
				 LOGGER.info("empcode:"+projectMppings.get(0).getEmployee().getEmpcode());
				 for(EmployeeProjectMpping mpping : projectMppings){
					 EmployeeVo employeeResponse = new EmployeeVo();
						employeeResponse.setEmpcode(mpping.getEmployee().getEmpcode());
						employeeResponse.setEmpId(mpping.getEmployee().getEmpId());
						employees.add(employeeResponse);
				 }
				 response.setList(employees);
			 }else{
				 throw new DataNotFoundException("Not Employees Found In Requested Project");
			 }
		 } catch (ResourceAccessException ex) {
	            LOGGER.error(logPrefix+"Error in processing POST call", ex);
	            throw new ServiceUnavailableException("I/O error on POST request for employee Service URI");
		 } catch(Exception ex){
			 LOGGER.error(logPrefix+"Error while retreiving employees of project ", ex);
		 }
		LOGGER.info(logPrefix+"Exiting getEmployeesByProject()");
		return response;
	}

	@Override
	public boolean dissociateEmployeeFromProject(EmployeeRequest employeeRequest) {
		
		String logPrefix = EmployeeServiceImpl.class.toString() + ":: dissociateEmployeeFromProject()::";
		LOGGER.info(logPrefix+"Entering dissociateEmployeeFromProject()");
		boolean status =  false;
		try {
			 Project project = projectRepository.findProjectByCode(employeeRequest.getProjectCode());
			 if(null == project){
				 throw new DataNotFoundException("Requested Project Not Found");
			 }
			 LOGGER.info(logPrefix+"dissociateEmployeeFromProject::"+project.getProjcode());
			 
			 Employee employee = employeeRepository.findEmployeeByCode(employeeRequest.getEmpCode());
			 if(null == employee){
				 throw new DataNotFoundException("Requested Employee Not Found");
			 }
			 LOGGER.info(logPrefix+employee.getEmpcode());
			
			 EmployeeProjectMpping projectMpping = employeeProjectRepository.findByEmployeeAndProject(employee, project);
			 employeeProjectRepository.delete(projectMpping);
			 status = true;
		} catch (ResourceAccessException ex) {
            LOGGER.error(logPrefix+"Error in processing POST call", ex);
            throw new ServiceUnavailableException("I/O error on POST request for employee ptoject Service URI");	 
		} catch(Exception ex){
			 LOGGER.error(logPrefix+"Error while disassociatig employee from project ", ex);
		}
		LOGGER.info(logPrefix+"Exiting dissociateEmployeeFromProject()");
		
		return status;
	}

}
