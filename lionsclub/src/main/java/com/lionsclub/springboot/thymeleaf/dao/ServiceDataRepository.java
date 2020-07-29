package com.lionsclub.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lionsclub.springboot.thymeleaf.entity.ServiceData;

public interface ServiceDataRepository extends JpaRepository<ServiceData, Integer> {

	
}


