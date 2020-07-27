package com.lionsclub.springboot.thymeleaf.service;

import java.util.List;

import com.lionsclub.springboot.thymeleaf.entity.Member;
import com.lionsclub.springboot.thymeleaf.entity.MemberFamily;

public interface MemberFamilyService {

	public List<MemberFamily> findAll();
	
	public MemberFamily findById(int theId);
	
	public void save(MemberFamily themember);
	
	public void deleteById(int theId);
	
	public  List<MemberFamily> FamilymemberSpecific(String memberid);

	public List<MemberFamily> findAll(List<String> rptMemberdetails);

	
	
}
