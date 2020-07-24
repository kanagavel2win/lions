package com.lionsclub.springboot.thymeleaf.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lionsclub.springboot.thymeleaf.dao.UserRepository;
import com.lionsclub.springboot.thymeleaf.entity.Member;
import com.lionsclub.springboot.thymeleaf.entity.MemberAsperInternational;
import com.lionsclub.springboot.thymeleaf.entity.MemberFamily;
import com.lionsclub.springboot.thymeleaf.entity.User;
import com.lionsclub.springboot.thymeleaf.service.MemberAsperInternationalService;
import com.lionsclub.springboot.thymeleaf.service.MemberFamilyService;
import com.lionsclub.springboot.thymeleaf.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberFamilyService memberFamilyService;

	@Autowired
	private MemberAsperInternationalService memberInternationalService;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("memberFamilyDelete")
	@ResponseBody
	public String MemberFamilyDelete(@RequestParam("deleteId") int deleteId) {
		memberFamilyService.deleteById(deleteId);
		return " Family Member Removed Successfully";

	}

	@PostMapping("memberDelete")
	@ResponseBody
	public String MemberDelete(@RequestParam("deleteId") int deleteId) {
		memberService.deleteById(deleteId);
		return "Member Removed Successfully";

	}

	@GetMapping("/MemberviewRoleMember")
	public String rptMemberview(Model theModel) {
		Member editmemberDetails = memberService.findByMemberID(getLoginMemberID()).get(0);
		List<MemberFamily> MemberFamilyList = memberFamilyService.FamilymemberSpecific(editmemberDetails.getMemberID());

		// Set office or home address

		ArrayList<Member> MemberFamilyListDetails = new ArrayList<Member>();
		for (int hhif = 0; hhif < MemberFamilyList.size(); hhif++) {
			Member m1 = memberService.findByMemberID(MemberFamilyList.get(hhif).getMemberID()).get(0);
			MemberFamilyListDetails.add(m1);
		}

		theModel.addAttribute("member", editmemberDetails);
		theModel.addAttribute("memberfamilyinfo", MemberFamilyListDetails);
		return "rptMemberviewRoleMember";
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

	@GetMapping("/membereditRoleMember")
	public String memberadd(Model theModel) {

		Member editmemberDetails = memberService.findByMemberID(getLoginMemberID()).get(0);
		List<Member> FamilymemberDetails = memberService.findFamilyMemberDetails(editmemberDetails.getMemberID(),getLoginClubID());
		theModel.addAttribute("FamilymemberDetails", FamilymemberDetails);

		List<MemberFamily> FamilymemberSpecific = memberFamilyService
				.FamilymemberSpecific(editmemberDetails.getMemberID());

		for (int fmsi = 0; fmsi < FamilymemberSpecific.size(); fmsi++) {
			String tempMemberID = FamilymemberSpecific.get(fmsi).getMemberID();
			String tempname = memberService.findByMemberID(tempMemberID).get(0).getFirst_Name() + ' '
					+ memberService.findByMemberID(tempMemberID).get(0).getLast_Name() + " (" + tempMemberID + ")";
			FamilymemberSpecific.get(fmsi).setMemberID(tempname);
		}
		theModel.addAttribute("FamilymemberSpecific", FamilymemberSpecific);

		theModel.addAttribute("members", editmemberDetails);
		theModel.addAttribute("savestatus", false);
		MemberAsperInternational meminter = memberInternationalService.findMemberID(editmemberDetails.getMemberID())
				.get(0);
		theModel.addAttribute("meminter", meminter);

		return "memberaddRoleMember";
	}

	@PostMapping("/membereditRoleMember")
	public String membersave(HttpServletRequest request, @ModelAttribute("members") Member member,
			@RequestParam("profilepicture") MultipartFile profilepicture,
			@RequestParam("fa_member_id") String[] fa_member_id,
			@RequestParam("fa_member_relation") String[] fa_member_relation,
			@RequestParam("fa_member_orderid") int[] fa_member_orderid, Model themodel) {

		// Start image Upload area----------------------------------------
		String uploadRootPath = request.getServletContext().getRealPath("profilepic");
		System.out.println("uploadRootPath=" + uploadRootPath);

		File uploadRootDir = new File(uploadRootPath);
		// Create directory if it not exists.
		if (!uploadRootDir.exists()) {
			uploadRootDir.mkdirs();
		}

		StringBuilder filename = new StringBuilder();
		Path fileNameandPath = Paths.get(uploadRootPath, profilepicture.getOriginalFilename());
		filename.append(profilepicture.getOriginalFilename());

		try {
			Files.write(fileNameandPath, profilepicture.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// End image Upload area----------------------------------------
		// Start family Member Details adding---------------------------

		for (int farr = 0; farr < fa_member_id.length; farr++) {
			if (fa_member_id[farr].length() > 0) {
				MemberFamily memFamliy = new MemberFamily();
				memFamliy.setHouseofHeadMemberID((member.getMemberID()));
				String[] tempFamilymemberID = fa_member_id[farr].split("-");
				memFamliy.setMemberID(tempFamilymemberID[1]);
				memFamliy.setRelationship(fa_member_relation[farr]);
				memFamliy.setOrderID(fa_member_orderid[farr]);
				memberFamilyService.save(memFamliy);
			}
		}
		// End family Member Details adding---------------------------
		// -------------------------------------------------------------
		// System.out.println(fileNameandPath);
		member.setProfileImg("profilepic/" + filename);
		memberService.save(member);
		themodel.addAttribute("members", member);
		themodel.addAttribute("savestatus", true);

		List<MemberFamily> FamilymemberSpecific = memberFamilyService.FamilymemberSpecific(member.getMemberID());

		for (int fmsi = 0; fmsi < FamilymemberSpecific.size(); fmsi++) {
			String tempMemberID = FamilymemberSpecific.get(fmsi).getMemberID();
			String tempname = memberService.findByMemberID(tempMemberID).get(0).getFirst_Name() + ' '
					+ memberService.findByMemberID(tempMemberID).get(0).getLast_Name() + " (" + tempMemberID + ")";
			FamilymemberSpecific.get(fmsi).setMemberID(tempname);
		}
		themodel.addAttribute("FamilymemberSpecific", FamilymemberSpecific);

		List<Member> FamilymemberDetails = memberService.findFamilyMemberDetails(String.valueOf(member.getMemberID()),getLoginClubID());
		themodel.addAttribute("FamilymemberDetails", FamilymemberDetails);

		MemberAsperInternational meminter = memberInternationalService.findMemberID(member.getMemberID()).get(0);
		themodel.addAttribute("meminter", meminter);

		return "memberaddRoleMember";
	}

	@GetMapping("ReportDifferentIntvslocalRoleMember")
	public String ReportDifferentIntvslocalRoleMember(Model model) {

		List<MemberAsperInternational> internationmemberList = memberInternationalService.findAll(getLoginClubID());

		TreeMap<MemberAsperInternational, Member> compareMember = new TreeMap<MemberAsperInternational, Member>();

		String tempMemberID = getLoginMemberID();
		for (int i = 0; i < internationmemberList.size(); i++) {

			if (internationmemberList.get(i).getMemberID().equalsIgnoreCase(tempMemberID)) {

				Member m1 = memberService.findByMemberID(internationmemberList.get(i).getMemberID()).get(0);

				// if (compareLocalAndInter(internationmemberList.get(i), m1)) {
				compareMember.put(internationmemberList.get(i), m1);
				// }
			}
		}

		model.addAttribute("compareMember", compareMember);

		return "rptMemberDiffDBRoleMember";
	}
}
