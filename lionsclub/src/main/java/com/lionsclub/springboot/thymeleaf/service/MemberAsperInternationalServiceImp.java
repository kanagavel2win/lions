package com.lionsclub.springboot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lionsclub.springboot.thymeleaf.dao.MemberAsperInternationalRepository;
import com.lionsclub.springboot.thymeleaf.entity.MemberAsperInternational;

@Service
public class MemberAsperInternationalServiceImp implements MemberAsperInternationalService {

	@Autowired
	private MemberAsperInternationalRepository memberInternationRep;

	@Override
	public List<MemberAsperInternational> findAll(String clubID) {
		// TODO Auto-generated method stub
		return memberInternationRep.findAll(clubID);
	}

	@Override
	public Optional<MemberAsperInternational> findById(int theId) {
		// TODO Auto-generated method stub
		return memberInternationRep.findById(theId);
	}

	@Override
	public void save(MemberAsperInternational themember) {

		memberInternationRep.save(themember);

	}

	@Override
	public void deleteById(int theId) {
		memberInternationRep.deleteById(theId);

	}

	@Override
	public void deleteAll(String clubID) {
		memberInternationRep.deleteAll(clubID);
		
	}

	@Override
	public List<MemberAsperInternational> findMemberID(String memberid) {
		
		return memberInternationRep.getMemberID(memberid);
	}

}
