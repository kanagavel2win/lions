package com.lionsclub.springboot.thymeleaf.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lionsclub.springboot.thymeleaf.dao.ServiceRepository;
import com.lionsclub.springboot.thymeleaf.dao.UserRepository;
import com.lionsclub.springboot.thymeleaf.entity.Member;
import com.lionsclub.springboot.thymeleaf.entity.ServiceMaster;
import com.lionsclub.springboot.thymeleaf.entity.User;
import com.lionsclub.springboot.thymeleaf.service.ServiceInterf;

@Controller
public class ServiceController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ServiceInterf serviceRepository;
	
	

	@ModelAttribute
	public void addAttributes(Model themodel, HttpSession session, HttpServletRequest request) {

		String dataLoginEmailID = "";
		String dataLoginClubID = "";
		try {

			try {
				if (request.getSession().getAttribute("dataLoginEmailID").toString().equals(null)) {
					dataLoginClubID = getLoginClubID();
					request.getSession().setAttribute("dataLoginClubID", dataLoginClubID);
					dataLoginEmailID = getLoginemailID();
					request.getSession().setAttribute("dataLoginEmailID", dataLoginEmailID);
				}
			} catch (NullPointerException e) {
				dataLoginClubID = getLoginClubID();
				request.getSession().setAttribute("dataLoginClubID", dataLoginClubID);
				dataLoginEmailID = getLoginemailID();
				request.getSession().setAttribute("dataLoginEmailID", dataLoginEmailID);
			}

			dataLoginEmailID = request.getSession().getAttribute("dataLoginEmailID").toString();
			dataLoginClubID = request.getSession().getAttribute("dataLoginClubID").toString();

		} catch (Exception e) {

		} finally {
			themodel.addAttribute("dataLoginEmailID", dataLoginEmailID);
			themodel.addAttribute("dataLoginClubID", dataLoginClubID);
		}

	}

	@GetMapping("ServiceMaster")
	public String ServiceMaster(Model model) {
		
		List<ServiceMaster> li=serviceRepository.findAll();
		model.addAttribute("services",li);
		return "MemberService";
	}
	
	@GetMapping("Serviceadd")
	public String ServiceMasteradd(Model model,@RequestParam("id") int serid) {
		ServiceMaster serObj;
		if(serid>0)
		{
			serObj=serviceRepository.findById(serid);
		}
		else
		{
			serObj=new ServiceMaster();	
		}
		
		
		model.addAttribute("service",serObj);
		return "serviceadd";
	}
	@PostMapping("Serviceadd")
	public String ServiceMasteraddsave(@ModelAttribute("members") ServiceMaster serviceMaster,Model model) {
		
		serviceRepository.save(serviceMaster);
		model.addAttribute("savestatus", true);
		model.addAttribute("service",serviceMaster);
		return "serviceadd";
	}
	
	
	
	public String getLoginemailID() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user2 = userRepository.findByEmail(currentPrincipalName);
		return user2.getEmail();

	}

	public String getLoginMemberID() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user2 = userRepository.findByEmail(currentPrincipalName);
		return user2.getmemberID();

	}

	public String getLoginClubID() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user2 = userRepository.findByEmail(currentPrincipalName);
		return user2.getClubID();

	}
}
