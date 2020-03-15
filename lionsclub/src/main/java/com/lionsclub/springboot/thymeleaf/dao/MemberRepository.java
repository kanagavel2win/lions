package com.lionsclub.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lionsclub.springboot.thymeleaf.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	// that's it ... no need to write any code LOL!
	
}
