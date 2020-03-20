package com.lionsclub.springboot.thymeleaf.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	
	@GetMapping("/internationallionsclub")
	public String internationalLions()
	{
		return "internationlionssite";
	}
	
	
	@GetMapping("/memberedit")
	public String memberadd(@RequestParam("id") int memberid, Model theModel ) {
		
		Member editmemberDetails=memberService.findById(memberid);
		
		theModel.addAttribute("members", editmemberDetails);
		theModel.addAttribute("savestatus", false);
		
		return "memberadd";
	}
	
	@PostMapping("/memberedit")
	public String membersave(HttpServletRequest request,  @ModelAttribute("members") Member member, @RequestParam("profilepicture") MultipartFile profilepicture, Model themodel) {
		
		String uploadRootPath = request.getServletContext().getRealPath("profilepic");
		 System.out.println("uploadRootPath=" + uploadRootPath);
		 
	      File uploadRootDir = new File(uploadRootPath);
	      // Create directory if it not exists.
	      if (!uploadRootDir.exists()) {
	         uploadRootDir.mkdirs();
	      }
		
		StringBuilder filename=new StringBuilder();
		Path fileNameandPath =Paths.get(uploadRootPath,profilepicture.getOriginalFilename());
		filename.append(profilepicture.getOriginalFilename());
		
		try {
			Files.write(fileNameandPath,profilepicture.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(fileNameandPath);
		member.setProfileImg("profilepic/" + filename);
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
