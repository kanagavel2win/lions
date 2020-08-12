package com.lionsclub.springboot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import com.lionsclub.springboot.thymeleaf.entity.ServiceMaster;

public interface ServiceInterf {

	public List<ServiceMaster> findAll();
	
	public ServiceMaster findById(int theId);
	
	public void save(ServiceMaster theService);
	
	public void deleteById(int theId);

	
	
	
}
