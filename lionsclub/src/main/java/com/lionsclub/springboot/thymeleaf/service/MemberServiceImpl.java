package com.lionsclub.springboot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lionsclub.springboot.thymeleaf.dao.MemberRepository;
import com.lionsclub.springboot.thymeleaf.entity.Member;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberRepository memberRepository;
	
	@Autowired
	public MemberServiceImpl(MemberRepository thememberRepository) {
		memberRepository = thememberRepository;
	}
	
	@Override
	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	@Override
	public Member findById(int theId) {
		Optional<Member> result = memberRepository.findById(theId);
		
		Member themember = null;
		
		if (result.isPresent()) {
			themember = result.get();
		}
		else {
			// we didn't find the member
			throw new RuntimeException("Did not find member id - " + theId);
		}
		
		return themember;
	}

	@Override
	public void save(Member themember) {
		memberRepository.save(themember);
	}

	@Override
	public void deleteById(int theId) {
		memberRepository.deleteById(theId);
	}

}






