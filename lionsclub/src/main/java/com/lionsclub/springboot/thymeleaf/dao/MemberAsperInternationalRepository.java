package com.lionsclub.springboot.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lionsclub.springboot.thymeleaf.entity.MemberAsperInternational;

public interface MemberAsperInternationalRepository extends JpaRepository<MemberAsperInternational, Integer>{
	
	@Query("SELECT m FROM MemberAsperInternational m WHERE m.MemberID = :memberid")
	public List<MemberAsperInternational> getMemberID(@Param("memberid") String memberid);

	@Query("Delete FROM MemberAsperInternational m WHERE  m.Club_ID = :clubID")
	public void deleteAll(@Param("clubID") String clubID);

	@Query("SELECT m FROM MemberAsperInternational m WHERE m.Club_ID = :clubID")
	public List<MemberAsperInternational> findAll(@Param("clubID") String clubID);
	
	
}
