package com.lionsclub.springboot.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lionsclub.springboot.thymeleaf.entity.Member;
import com.lionsclub.springboot.thymeleaf.entity.MemberFamily;

public interface MemberFamilyRepository extends JpaRepository<MemberFamily, Integer> {

	
	
	@Query("Select m From MemberFamily m Where m.houseofHeadMemberID = :memberid Order By orderID")
	public List<MemberFamily> FamilymemberSpecific(@Param("memberid") String memberid);

	@Query("Select m From MemberFamily m Where m.MemberID IN :rptMemberdetails Order By orderID")
	public List<MemberFamily> FamilymemberAllclubmmeber(@Param("rptMemberdetails") List<String> rptMemberdetails);


 }
