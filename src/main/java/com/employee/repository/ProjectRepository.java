/**
 * 
 */
package com.employee.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.employee.model.Project;

/**
 * @author snaredl
 *
 */
public interface ProjectRepository  extends CrudRepository<Project, Integer>{
	
	 @Query("SELECT p FROM Project p WHERE p.projcode = :projcode")
	    Project findProjectByCode(@Param("projcode") String projcode);

}
