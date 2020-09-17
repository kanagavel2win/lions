package com.lionsclub.springboot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lionsclub.springboot.thymeleaf.dao.ServiceDataNewRepository;
import com.lionsclub.springboot.thymeleaf.entity.ServiceDataNew;

@Service
public class ServiceDataNewImpl implements ServiceDataNewInterf {

	@Autowired
	private ServiceDataNewRepository serviceDataNewRepository;
	
	@Override
	public List<ServiceDataNew> findAll() {
		return serviceDataNewRepository.findAll();
	}

	@Override
	public ServiceDataNew findById(int theId) {
		Optional<ServiceDataNew> result = serviceDataNewRepository.findById(theId);

		ServiceDataNew ser = null;

		if (result.isPresent()) {
			ser = result.get();
		} else {
			// we didn't find the member
			throw new RuntimeException("Did not find member id - " + theId);
		}

		
		return ser;
	}

	@Override
	public void save(ServiceDataNew theService) {
		serviceDataNewRepository.save(theService);
	}

	@Override
	public void deleteById(int theId) {
		serviceDataNewRepository.deleteById(theId);
	}

	@Override
	public void deleteAll() {
		serviceDataNewRepository.deleteAll();
		
	}


}
