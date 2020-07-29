package com.lionsclub.springboot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lionsclub.springboot.thymeleaf.dao.ServiceDataRepository;
import com.lionsclub.springboot.thymeleaf.entity.ServiceData;

@Service
public class ServiceDataImpl implements ServiceDataInterf {

	@Autowired
	private ServiceDataRepository serviceDataRepository;
	
	@Override
	public List<ServiceData> findAll() {
		return serviceDataRepository.findAll();
	}

	@Override
	public ServiceData findById(int theId) {
		Optional<ServiceData> result = serviceDataRepository.findById(theId);

		ServiceData ser = null;

		if (result.isPresent()) {
			ser = result.get();
		} else {
			// we didn't find the member
			throw new RuntimeException("Did not find member id - " + theId);
		}

		
		return ser;
	}

	@Override
	public void save(ServiceData theService) {
		serviceDataRepository.save(theService);
	}

	@Override
	public void deleteById(int theId) {
		serviceDataRepository.deleteById(theId);
	}

	@Override
	public void deleteAll() {
		serviceDataRepository.deleteAll();
		
	}


}
