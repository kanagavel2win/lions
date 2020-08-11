package com.lionsclub.springboot.thymeleaf.service;

import java.util.List;

import com.lionsclub.springboot.thymeleaf.entity.ServiceData;

public interface ServiceDataInterf {

	public List<ServiceData> findAll();
	
	public ServiceData findById(int theId);
	
	public void save(ServiceData theService);
	
	public void deleteById(int theId);

	public void deleteAll();
	
	
}
