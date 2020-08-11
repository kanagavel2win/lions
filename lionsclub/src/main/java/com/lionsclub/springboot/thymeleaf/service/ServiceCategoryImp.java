package com.lionsclub.springboot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lionsclub.springboot.thymeleaf.dao.ServiceCategoryRepository;
import com.lionsclub.springboot.thymeleaf.entity.ServiceCategory;

@Service
public class ServiceCategoryImp implements ServiceCategoryInterf {

	@Autowired
	private ServiceCategoryRepository serviceCategoryRepository;

	@Override
	public List<ServiceCategory> findAll() {

		return serviceCategoryRepository.findAll();
	}

	@Override
	public ServiceCategory findById(int theId) {

		Optional<ServiceCategory> result = serviceCategoryRepository.findById(theId);

		ServiceCategory ser = null;

		if (result.isPresent()) {
			ser = result.get();
		} else {
			// we didn't find the member
			throw new RuntimeException("Did not find member id - " + theId);
		}

		return ser;
	}

	@Override
	public void save(ServiceCategory theService) {
		serviceCategoryRepository.save(theService);
	}

	@Override
	public void deleteById(int theId) {
		serviceCategoryRepository.deleteById(theId);
	}

	@Override
	public void deleteAll() {
		serviceCategoryRepository.deleteAll();
	}

	@Override
	public List<ServiceCategory> getServiceUsingClubID(String ClubID) {
		return serviceCategoryRepository.getServiceUsingClubID(ClubID);
	}

	@Override
	public void updateCategory(String clubIDtemp, String clubCategoryTemp) {
		 //serviceCategoryRepository.updateCategory(clubIDtemp,clubCategoryTemp);
	}

}
