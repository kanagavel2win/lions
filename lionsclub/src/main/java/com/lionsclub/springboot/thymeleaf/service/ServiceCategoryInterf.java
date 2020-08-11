package com.lionsclub.springboot.thymeleaf.service;

import java.util.List;

import com.lionsclub.springboot.thymeleaf.entity.ServiceCategory;

public interface ServiceCategoryInterf {

	public List<ServiceCategory> findAll();

	public ServiceCategory findById(int theId);

	public void save(ServiceCategory theService);

	public void deleteById(int theId);

	public void deleteAll();

	public List<ServiceCategory> getServiceUsingClubID(String ClubID);

	public void updateCategory(String clubIDtemp, String clubCategoryTemp);
}
