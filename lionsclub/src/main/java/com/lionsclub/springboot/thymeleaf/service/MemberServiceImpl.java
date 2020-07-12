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

	@Override
	public List<Member> findByMemberID(String MemberID) {
		
		//return null;
		return memberRepository.getMemberID(MemberID);
	}

	@Override
	public List<Member> getNotfilledMandatoryFields() {
		// TODO Auto-generated method stub
		return memberRepository.getNotfilledMandatoryFields();
	}

	@Override
	public List<Member> getRptMemberDetails() {
		// TODO Auto-generated method stub
		return memberRepository.getRptMemberDetails();
	}

	@Override
	public List<Member> getRptTopMemberDetails() {
		// TODO Auto-generated method stub
		return memberRepository.getRptTopMemberDetails();
	}

	@Override
	public List<Member> findDOBReport(String dobDate) {
		// TODO Auto-generated method stub
		return memberRepository.getRptMemberDetailsDOB(dobDate);
	}

	@Override
	public List<Member> findWOBReport(String wobDate) {
		// TODO Auto-generated method stub
		return memberRepository.getRptMemberDetailsWOB(wobDate);
	}

	@Override
	public List<Member> findBloodGReport(String bloodGroup) {
		// TODO Auto-generated method stub
		return memberRepository.getRptMemberDetailsBloodGroup(bloodGroup);
	}

	@Override
	public List<Member> findFamilyMemberDetails(String MemberID) {
		
		return memberRepository.getFamilyMemberDetails(MemberID);
	}

	@Override
	public List<Member> getHouseholderdetails() {
		// TODO Auto-generated method stub
		return memberRepository.getHouseholderdetails();
	}

	@Override
	public List<String> getAllMemberID() {
		// TODO Auto-generated method stub
		return memberRepository.getAllMemberID();
	}

	

	
}






