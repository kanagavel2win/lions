package com.lionsclub.springboot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	// create a mapping for "/hello"
	
	@GetMapping("/")
	public String home(Model theModel) {
		
		theModel.addAttribute("theDate", new java.util.Date());
		
		return "index";
	}
	
	@GetMapping("/clubadd")
	public String header(Model theModel) {
		
		
		return "clubadd";
	}
	@GetMapping("/clublist")
	public String clublist() {
		
		return "clublist";
	}
	@GetMapping("/memberadd")
	public String memberadd() {
		
		return "memberadd";
	}
	@GetMapping("/memberlist")
	public String memberlist() {
		
		return "memberlist";
	}
}








