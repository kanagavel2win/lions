package com.lionsclub.springboot.thymeleaf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@PostMapping("/InterLocalUpdate")
	public String InterLocalUpdate()
	{
		return "SuccessPOST";
	}
	
	@GetMapping("/InterLocalUpdate")
	public String InterLocalUpdateget()
	{
		return "SuccessGet";
	}
}
