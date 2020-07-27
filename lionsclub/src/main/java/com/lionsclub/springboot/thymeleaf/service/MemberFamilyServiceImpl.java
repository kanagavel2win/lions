package com.lionsclub.springboot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lionsclub.springboot.thymeleaf.dao.MemberFamilyRepository;
import com.lionsclub.springboot.thymeleaf.entity.Member;
import com.lionsclub.springboot.thymeleaf.entity.MemberFamily;

@Service
public class MemberFamilyServiceImpl implements MemberFamilyService {

	private MemberFamilyRepository memberFamilyRepository;
	
	@Autowired
	public MemberFamilyServiceImpl(MemberFamilyRepository thememberFamilyRepository) {
		memberFamilyRepository = thememberFamilyRepository;
	}
	
	@Override
	public List<MemberFamily> findAll() {
		return memberFamilyRepository.findAll();
	}

	
	@Override
	public MemberFamily findById(int theId) {
		Optional<MemberFamily> result = memberFamilyRepository.findById(theId);
		
		MemberFamily themember = null;
		
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
	public void save(MemberFamily themember) {
		memberFamilyRepository.save(themember);
	}

	@Override
	public void deleteById(int theId) {
		memberFamilyRepository.deleteById(theId);
	}

	@Override
	public List<MemberFamily> FamilymemberSpecific(String memberid) {
		// TODO Auto-generated method stub
		return memberFamilyRepository.FamilymemberSpecific(memberid);
	}

	@Override
	public List<MemberFamily> findAll(List<String> rptMemberdetails) {
		// TODO Auto-generated method stub
		return memberFamilyRepository.FamilymemberAllclubmmeber(rptMemberdetails);
	}

	

		
}






