package com.employee.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.employee.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
	@Query("SELECT p FROM Employee p WHERE p.empcode = :empcode")
	Employee findEmployeeByCode(@Param("empcode") String empcode);
	
}
