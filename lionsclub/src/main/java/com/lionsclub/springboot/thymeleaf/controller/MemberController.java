package com.lionsclub.springboot.thymeleaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lionsclub.springboot.thymeleaf.entity.Member;
import com.lionsclub.springboot.thymeleaf.service.MemberService;

@Controller
@RequestMapping("/members")
public class MemberController {

	private MemberService memberService;
	
	public MemberController(MemberService thememberService) {
		memberService = thememberService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listmembers(Model theModel) {
		
		// get members from db
		List<Member> themembers = memberService.findAll();
		
		// add to the spring model
		theModel.addAttribute("members", themembers);
		
		return "list-members";
	}
}









