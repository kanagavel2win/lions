package com.lionsclub.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lionsclub.springboot.thymeleaf.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	//public Member findByMember_ID(String member_ID); 
	
}
