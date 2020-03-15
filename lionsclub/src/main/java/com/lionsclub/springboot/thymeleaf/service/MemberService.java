package com.lionsclub.springboot.thymeleaf.service;

import java.util.List;

import com.lionsclub.springboot.thymeleaf.entity.Member;

public interface MemberService {

	public List<Member> findAll();
	
	public Member findById(int theId);
	
	public void save(Member themember);
	
	public void deleteById(int theId);
	
	public Member findByMember_ID(String Member_ID);
	
}
