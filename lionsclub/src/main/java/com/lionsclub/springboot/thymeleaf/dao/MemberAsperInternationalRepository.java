package com.lionsclub.springboot.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lionsclub.springboot.thymeleaf.entity.MemberAsperInternational;

public interface MemberAsperInternationalRepository extends JpaRepository<MemberAsperInternational, Integer>{
	
	@Query("SELECT m FROM MemberAsperInternational m WHERE m.MemberID = ?1")
	public List<MemberAsperInternational> getMemberID(String MemberID);
}
