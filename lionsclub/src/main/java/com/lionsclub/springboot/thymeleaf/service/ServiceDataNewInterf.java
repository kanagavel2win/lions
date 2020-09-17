package com.lionsclub.springboot.thymeleaf.service;

import java.util.List;

import com.lionsclub.springboot.thymeleaf.entity.ServiceDataNew;

public interface ServiceDataNewInterf {

	public List<ServiceDataNew> findAll();

	public ServiceDataNew findById(int theId);

	public void save(ServiceDataNew theService);

	public void deleteById(int theId);

	public void deleteAll();

}
