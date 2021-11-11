/**
 * 
 */
package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.employee.model.Employee;
import com.employee.model.EmployeeProjectMpping;
import com.employee.model.Project;

/**
 * @author snaredl
 *
 */
public interface EmployeeProjectRepository  extends CrudRepository<EmployeeProjectMpping, Integer>{
	
	@Query("SELECT u FROM EmployeeProjectMpping u WHERE u.project = :projId")
    List<EmployeeProjectMpping> findAll(@Param("projId") Project projId);
	
	@Query("SELECT u FROM EmployeeProjectMpping u WHERE u.employee = :employee and u.project=:project")
	EmployeeProjectMpping findByEmployeeAndProject(
            @Param("employee") Employee employee,
            @Param("project") Project project);

}
