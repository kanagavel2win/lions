package com.lionsclub.springboot.thymeleaf.service;

import java.util.List;

import com.lionsclub.springboot.thymeleaf.entity.Member;

public interface MemberService {

	public List<Member> findAll();
	
	public Member findById(int theId);
	
	public void save(Member themember);
	
	public void deleteById(int theId);
	
	public List<Member> findByMemberID(String MemberID);
	
	public List<Member> getNotfilledMandatoryFields();
	
	public List<Member> getRptMemberDetails();
	
	public List<Member> getRptTopMemberDetails();
	
	public List<Member> findDOBReport(String dobDate);
	
	public List<Member> findWOBReport(String wobDate);
	
	public List<Member> findBloodGReport(String bloodGroup);
	
	public List<Member> findFamilyMemberDetails(String MemberID);
	
	public List<Member> getHouseholderdetails();
	
	public List<String> getAllMemberID();

	
	
}
