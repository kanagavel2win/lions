package com.lionsclub.springboot.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lionsclub.springboot.thymeleaf.entity.Member;
import com.lionsclub.springboot.thymeleaf.service.MemberService;

@Controller
public class HomeController {

	@Autowired
	private MemberService memberService;

	// create a mapping for "/hello"

	@GetMapping("/") 
	public String home(Model theModel) {

		theModel.addAttribute("theDate", new java.util.Date());

		return "index";
	}

	@GetMapping("/index") 
	public String index(Model theModel) {

		theModel.addAttribute("theDate", new java.util.Date());

		return "index";
	}

	@GetMapping("/memberedit")
	public String memberadd(@RequestParam("id") int memberid, Model theModel ) {
		
		Member editmemberDetails=memberService.findById(memberid);
		
		theModel.addAttribute("members", editmemberDetails);
		theModel.addAttribute("savestatus", false);
		
		return "memberadd";
	}
	
	@PostMapping("/memberedit")
	public String membersave(@ModelAttribute("members") Member member, Model themodel) {
		
		memberService.save(member);
		themodel.addAttribute("members", member);
		themodel.addAttribute("savestatus", true);
		return "memberadd";
	}

	@GetMapping("/memberlist")
	public String memberlist(Model theModel) {

		// get members from db
		List<Member> themembers = memberService.findAll();

		// add to the spring model
		theModel.addAttribute("members", themembers);

		return "memberlist";
	}
}
