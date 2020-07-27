package com.lionsclub.springboot.thymeleaf.service;

import java.util.List;

import com.lionsclub.springboot.thymeleaf.entity.Member;

public interface MemberService {

	public List<Member> findAll(String clubID);
	
	public Member findById(int theId);
	
	public void save(Member themember);
	
	public void deleteById(int theId);
	
	public List<Member> findByMemberID(String MemberID);
	
	public List<Member> getNotfilledMandatoryFields(String clubID);
	
	public List<Member> getRptMemberDetails(String clubID);
	
	public List<Member> getRptTopMemberDetails(String clubID);
	
	public List<Member> findDOBReport(String dobDate,String clubID);
	
	public List<Member> findWOBReport(String wobDate,String clubID);
	
	public List<Member> findBloodGReport(String bloodGroup,String clubID);
	
	public List<Member> findFamilyMemberDetails(String MemberID,String clubID);
	
	public List<Member> getHouseholderdetails(String clubID);
	
	public List<String> getAllMemberID(String clubID);

	


	
	
}
