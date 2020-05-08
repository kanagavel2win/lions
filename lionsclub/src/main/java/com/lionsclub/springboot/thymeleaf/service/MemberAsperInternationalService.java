package com.lionsclub.springboot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import com.lionsclub.springboot.thymeleaf.entity.MemberAsperInternational;

public interface MemberAsperInternationalService {

	public List<MemberAsperInternational> findAll();

	public Optional<MemberAsperInternational> findById(int theId);

	public void save(MemberAsperInternational themember);

	public void deleteById(int theId);

	public void deleteAll();
}
