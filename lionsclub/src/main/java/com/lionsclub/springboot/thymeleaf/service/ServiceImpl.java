package com.lionsclub.springboot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lionsclub.springboot.thymeleaf.dao.ServiceRepository;
import com.lionsclub.springboot.thymeleaf.entity.Member;
import com.lionsclub.springboot.thymeleaf.entity.ServiceMaster;

@Service
public class ServiceImpl implements ServiceInterf {

	@Autowired
	private ServiceRepository serviceRepository;
	
	@Override
	public List<ServiceMaster> findAll() {
		return serviceRepository.findAll();
	}

	@Override
	public ServiceMaster findById(int theId) {
		Optional<ServiceMaster> result = serviceRepository.findById(theId);

		ServiceMaster ser = null;

		if (result.isPresent()) {
			ser = result.get();
		} else {
			// we didn't find the member
			throw new RuntimeException("Did not find member id - " + theId);
		}

		
		return ser;
	}

	@Override
	public void save(ServiceMaster theService) {
		serviceRepository.save(theService);
	}

	@Override
	public void deleteById(int theId) {
		serviceRepository.deleteById(theId);
	}


}
