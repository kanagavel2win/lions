package com.lionsclub.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lionsclub.springboot.thymeleaf.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!
	
}
