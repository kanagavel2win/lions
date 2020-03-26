package com.lionsclub.springboot.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lionsclub.springboot.thymeleaf.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	@Query("SELECT m FROM Member m WHERE m.MemberID = ?1")
	public List<Member> getMemberID(String MemberID);
}
