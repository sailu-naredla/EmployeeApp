/**
 * 
 */
package com.employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.employee.model.Department;

/**
 * @author snaredl
 *
 */
public interface DepartmentRepository  extends CrudRepository<Department, Integer>{

}
