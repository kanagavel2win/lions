package com.lionsclub.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lionsclub.springboot.thymeleaf.entity.ServiceMaster;

public interface ServiceRepository extends JpaRepository<ServiceMaster, Integer> {

	
}


