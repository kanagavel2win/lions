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
	public List<Member> findAll(String clubID) {
		return memberRepository.findAll(clubID);
	}

	@Override
	public Member findById(int theId) {
		Optional<Member> result = memberRepository.findById(theId);

		Member themember = null;

		if (result.isPresent()) {
			themember = result.get();
		} else {
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

		// return null;
		return memberRepository.getMemberID(MemberID);
	}

	@Override
	public List<Member> getNotfilledMandatoryFields(String clubID) {

		return memberRepository.getNotfilledMandatoryFields(clubID);
	}

	@Override
	public List<Member> getRptMemberDetails(String clubID) {

		return memberRepository.getRptMemberDetails(clubID);
	}

	@Override
	public List<Member> getRptTopMemberDetails(String clubID) {

		return memberRepository.getRptTopMemberDetails(clubID);
	}

	@Override
	public List<Member> findDOBReport(String dobDate, String clubID) {

		return memberRepository.getRptMemberDetailsDOB(dobDate, clubID);
	}

	@Override
	public List<Member> findWOBReport(String wobDate, String clubID) {

		return memberRepository.getRptMemberDetailsWOB(wobDate, clubID);
	}

	@Override
	public List<Member> findBloodGReport(String bloodGroup, String clubID) {

		return memberRepository.getRptMemberDetailsBloodGroup(bloodGroup, clubID);
	}

	@Override
	public List<Member> findFamilyMemberDetails(String MemberID, String clubID) {

		return memberRepository.getFamilyMemberDetails(MemberID, clubID);
	}

	@Override
	public List<Member> getHouseholderdetails(String clubID) {

		return memberRepository.getHouseholderdetails(clubID);
	}

	@Override
	public List<String> getAllMemberID(String clubID) {

		return memberRepository.getAllMemberID(clubID);
	}

	

}
