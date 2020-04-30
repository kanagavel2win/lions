package com.lionsclub.springboot.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lionsclub.springboot.thymeleaf.service.MemberFamilyService;

@Controller
public class MemberController {

	@Autowired
	MemberFamilyService  memberFamilyService;

	@PostMapping("memberFamilyDelete")
	@ResponseBody
	public String MemberFamilyDelete(@RequestParam("deleteId") int deleteId)
	{
		memberFamilyService.deleteById(deleteId);
		return " Family Member Removed Successfully";
		
	}
	
	
}









