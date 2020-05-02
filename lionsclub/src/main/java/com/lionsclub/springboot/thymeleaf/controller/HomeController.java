package com.lionsclub.springboot.thymeleaf.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lionsclub.springboot.thymeleaf.entity.Member;
import com.lionsclub.springboot.thymeleaf.entity.MemberFamily;
import com.lionsclub.springboot.thymeleaf.service.MemberFamilyService;
import com.lionsclub.springboot.thymeleaf.service.MemberService;

@Controller

public class HomeController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberFamilyService memberFamilyService;
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
	public String internationalLions() {
		return "internationlionssite";
	}

	@GetMapping("/memberview")
	public String rptMemberview(@RequestParam("id") int memberid, Model theModel) {
		Member editmemberDetails = memberService.findById(memberid);
		theModel.addAttribute("member", editmemberDetails);
		return "rptMemberview";
	}

	@GetMapping("/memberedit")
	public String memberadd(@RequestParam("id") int memberid, Model theModel) {

		Member editmemberDetails = memberService.findById(memberid);
		List<Member> FamilymemberDetails = memberService.findFamilyMemberDetails(editmemberDetails.getMemberID());
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

		return "memberadd";
	}

	@PostMapping("/memberedit")
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

		List<Member> FamilymemberDetails = memberService.findFamilyMemberDetails(String.valueOf(member.getMemberID()));
		themodel.addAttribute("FamilymemberDetails", FamilymemberDetails);

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

	@GetMapping("/membersearch")
	public String memberIdsearch(@RequestParam("id") String memberid, Model theModel) {

		List<Member> editmemberDetails = memberService.findByMemberID(memberid.toString());

		theModel.addAttribute("members", editmemberDetails.get(0));
		theModel.addAttribute("savestatus", false);

		return "memberadd";
	}

	@GetMapping("/memberupload")
	public String memberUploadcsv() {

		return "memberuploadcsv";
	}

	@PostMapping("/memberupload")
	public String memberUploadSavecsv(@RequestParam("file") MultipartFile file, Model model,
			RedirectAttributes redirectAttributes) {

		int newMemberIDdetailsCount = 0;
		// validate file
		if (file.isEmpty()) {
			model.addAttribute("message", "Please select a CSV file to upload.");
			model.addAttribute("status", false);
		} else {

			try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
				String line = br.readLine(); // Reading header, Ignoring
				while ((line = br.readLine()) != null && !line.isEmpty()) {

					// line=line.replace("\"", "");
					String[] fields = new String[49];
					fields = line.split(",");
					String memberIDcvs = fields[7].replace("\"", "");
					// ------------------------------------------------------------------------------------
					// ------------------------------------------------------------------------------------
					// Split data from csv field level
					String Multiple_District_Name = fields[0].replace("\"", "");
					String District_Name = fields[1].replace("\"", "");
					String Region_Name = fields[2].replace("\"", "");
					String Zone_Name = fields[3].replace("\"", "");
					String Title = fields[4].replace("\"", "");
					String Club_ID = fields[5].replace("\"", "");
					String Club_Name = fields[6].replace("\"", "");
					String MemberID = fields[7].replace("\"", "");
					String Prefix = fields[8].replace("\"", "");
					String First_Name = fields[9].replace("\"", "");
					String Middle_Name = fields[10].replace("\"", "");
					String Last_Name = fields[11].replace("\"", "");
					String Suffix = fields[12].replace("\"", "");
					String Invalid_Member_Address_Flag = fields[13].replace("\"", "");
					String Member_Address_Line_1 = fields[14].replace("\"", "");
					String Member_Address_Line_2 = fields[15].replace("\"", "");
					String Member_Address_Line_3 = fields[16].replace("\"", "");
					String Member_Address_Line_4 = fields[17].replace("\"", "");
					String Member_Address_City = fields[18].replace("\"", "");
					String Member_Address_State = fields[19].replace("\"", "");
					String Member_Address_Postal_Code = fields[20].replace("\"", "");
					String Member_Address_Country = fields[21].replace("\"", "");
					String Invalid_Officer_Address_Flag = fields[22].replace("\"", "");
					String Officer_Address_Line_1 = fields[23].replace("\"", "");
					String Officer_Address_Line_2 = fields[24].replace("\"", "");
					String Officer_Address_Line_3 = fields[25].replace("\"", "");
					String Officer_Address_Line_4 = fields[26].replace("\"", "");
					String Officer_Address_City = fields[27].replace("\"", "");
					String Officer_Address_State = fields[28].replace("\"", "");
					String Officer_Address_Postal_Code = fields[29].replace("\"", "");
					String Officer_Address_Country = fields[30].replace("\"", "");
					String Email = fields[31].replace("\"", "");
					String Home_Phone = fields[32].replace("\"", "");
					String Cell_Phone = fields[33].replace("\"", "");
					String Fax_Number = fields[34].replace("\"", "");
					String Work_Phone = fields[35].replace("\"", "");
					String Spouse_Name = fields[36].replace("\"", "");
					String Membership_Type = fields[37].replace("\"", "");
					String Date_of_Birth = fields[38].replace("\"", "");
					String Gender = fields[39].replace("\"", "");
					String Nick_Name = fields[40].replace("\"", "");
					String Occupation = fields[41].replace("\"", "");
					String Join_Date = fields[42].replace("\"", "");
					String Life_Member = fields[43].replace("\"", "");
					String Family_Unit = fields[44].replace("\"", "");
					String Sponsor_Name = fields[45].replace("\"", "");
					String Club_Branch_Name = fields[46].replace("\"", "");
					String International_Discount = fields[47].replace("\"", "");
					String International_Discount_Reason = "";
					if (fields.length == 49) {
						International_Discount_Reason = fields[48].replace("\"", "");
					}

					// Report Priority Order
					int ReportPriorityOrder = Integer.parseInt(MemberID);

					// ------------------------------------------------------------------------------------
					// ------------------------------------------------------------------------------------
					Member newMember;
					List<Member> editmemberDetails = memberService.findByMemberID(memberIDcvs);

					if (editmemberDetails.isEmpty()) {
						newMember = new Member();
						newMemberIDdetailsCount = newMemberIDdetailsCount + 1;
					} else {

						newMember = editmemberDetails.get(0);
					}

					// - Remove 12:00:00 AM time from Date of birth

					Date_of_Birth = Date_of_Birth.replaceAll("12:00:00 AM", "");
					Join_Date = Join_Date.replaceAll("12:00:00 AM", "");
					// Cell Numb
					
					// name Upper Case
					if (First_Name.length() > 1) {
						First_Name = First_Name.substring(0, 1).toUpperCase() + First_Name.substring(1).toLowerCase();
					}
					if (Middle_Name.length() > 1) {
						Middle_Name = Middle_Name.substring(0, 1).toUpperCase() + Middle_Name.substring(1).toLowerCase();
					}
					if (Last_Name.length() > 1) {
						Last_Name = Last_Name.substring(0, 1).toUpperCase() + Last_Name.substring(1).toLowerCase();
					}
					if (Spouse_Name.length() > 1) {
						Spouse_Name = First_Name.substring(0, 1).toUpperCase() + Spouse_Name.substring(1).toLowerCase();
					}
					if (Sponsor_Name.length() > 1) {
						Sponsor_Name = First_Name.substring(0, 1).toUpperCase() + Sponsor_Name.substring(1).toLowerCase();
					}

					
					
					
					
					

					// ------------------------------------------------------
					newMember.setMultiple_District_Name(Multiple_District_Name);
					newMember.setDistrict_Name(District_Name);
					newMember.setRegion_Name(Region_Name);
					newMember.setZone_Name(Zone_Name);
					newMember.setTitle(Title);
					newMember.setClub_ID(Club_ID);
					newMember.setClub_Name(Club_Name);
					newMember.setMemberID(MemberID);
					newMember.setPrefix(Prefix);
					newMember.setFirst_Name(First_Name);
					newMember.setMiddle_Name(Middle_Name);
					newMember.setLast_Name(Last_Name);
					newMember.setSuffix(Suffix);
					newMember.setInvalid_Member_Address_Flag(Invalid_Member_Address_Flag);
					newMember.setMember_Address_Line_1(Member_Address_Line_1);
					newMember.setMember_Address_Line_2(Member_Address_Line_2);
					newMember.setMember_Address_Line_3(Member_Address_Line_3);
					newMember.setMember_Address_Line_4(Member_Address_Line_4);
					newMember.setMember_Address_City(Member_Address_City);
					newMember.setMember_Address_State(Member_Address_State);
					newMember.setMember_Address_Postal_Code(Member_Address_Postal_Code);
					newMember.setMember_Address_Country(Member_Address_Country);
					newMember.setInvalid_Officer_Address_Flag(Invalid_Officer_Address_Flag);
					newMember.setOfficer_Address_Line_1(Officer_Address_Line_1);
					newMember.setOfficer_Address_Line_2(Officer_Address_Line_2);
					newMember.setOfficer_Address_Line_3(Officer_Address_Line_3);
					newMember.setOfficer_Address_Line_4(Officer_Address_Line_4);
					newMember.setOfficer_Address_City(Officer_Address_City);
					newMember.setOfficer_Address_State(Officer_Address_State);
					newMember.setOfficer_Address_Postal_Code(Officer_Address_Postal_Code);
					newMember.setOfficer_Address_Country(Officer_Address_Country);
					newMember.setEmail(Email);
					newMember.setHome_Phone(Home_Phone);
					newMember.setCell_Phone(Cell_Phone);
					newMember.setFax_Number(Fax_Number);
					newMember.setWork_Phone(Work_Phone);
					newMember.setSpouse_Name(Spouse_Name);
					newMember.setMembership_Type(Membership_Type);
					newMember.setDate_of_Birth(Date_of_Birth);
					newMember.setGender(Gender);
					newMember.setNick_Name(Nick_Name);
					newMember.setOccupation(Occupation);
					newMember.setJoin_Date(Join_Date);
					newMember.setLife_Member(Life_Member);
					newMember.setFamily_Unit(Family_Unit);
					newMember.setSponsor_Name(Sponsor_Name);
					newMember.setClub_Branch_Name(Club_Branch_Name);
					newMember.setInternational_Discount(International_Discount);
					newMember.setInternational_Discount_Reason(International_Discount_Reason);

					if (newMember.getReportPriorityOrder() == 0) {
						newMember.setReportPriorityOrder(ReportPriorityOrder);
					}
					if (newMember.getBgColorValue() == "" || newMember.getBgColorValue() == null) {
						newMember.setBgColorValue("#004b93");
					}

					if (newMember.getTextColorValue() == "" || newMember.getTextColorValue() == null) {
						newMember.setTextColorValue("White");
					}
					memberService.save(newMember);

				}

				br.close();
			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

			model.addAttribute("status", true);
			model.addAttribute("newMemberIDdetails", newMemberIDdetailsCount);

		}

		model.addAttribute("savestatus", false);

		return "memberuploadcsv";
	}

	@GetMapping("MemberPendingInfo")
	public String rptMemberPendingdetails(Model model) {
		try {
			List<Member> NotfilledMandatoryFieldsmemberDetails = memberService.getNotfilledMandatoryFields();

			model.addAttribute("NotfilledMandatoryFieldsmemberDetails", NotfilledMandatoryFieldsmemberDetails);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "rptMemberPendingdetails";

	}

	public static boolean compare(String str1, String str2) {
		return (str1 == null ? str2 == null : str1.equals(str2));
	}

	@SuppressWarnings("finally")
	@GetMapping("ReportAllmemberdetails")
	public String rptMemberDetailsFullA4(Model model) {
		try {

			List<Member> ReportAllmemberdetails = memberService.findAll();
			List<Member> RptMemberDetails = memberService.getRptMemberDetails();
			List<Member> RptTopMemberDetails = memberService.getRptTopMemberDetails();

			// Start Member Details process--------------------------------------------
			// --------------------------------------------------------------------------
			List<Member> houseHolder = memberService.getHouseholderdetails();

			TreeMap<Member, List<MemberFamily>> Familymap = new TreeMap<Member, List<MemberFamily>>();
			for (int hhi = 0; hhi < houseHolder.size(); hhi++) {
				List<MemberFamily> MemberFamilyList = memberFamilyService
						.FamilymemberSpecific(houseHolder.get(hhi).getMemberID());
				Familymap.put(houseHolder.get(hhi), MemberFamilyList);

			}

			// End Member Details process----------------------------------------------
			// --------------------------------------------------------------------------
			model.addAttribute("ReportAllmemberdetails", ReportAllmemberdetails);
			model.addAttribute("RptMemberDetails", RptMemberDetails);
			model.addAttribute("RptTopMemberDetails", RptTopMemberDetails);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return "rptMemberFullDetails";
		}

	}

	@SuppressWarnings("finally")
	@GetMapping("ReportAllmemberdetailswithFamily")
	public String ReportAllmemberdetailswithFamily1(Model model) {
		try {

			List<Member> ReportAllmemberdetails = memberService.findAll();
			List<Member> RptMemberDetails = memberService.getRptMemberDetails();
			List<Member> RptTopMemberDetails = memberService.getRptTopMemberDetails();

			// Start Member Details process--------------------------------------------
			// --------------------------------------------------------------------------
			// List<Member> houseHolder = memberService.getHouseholderdetails();

			TreeMap<Member, List<Member>> Familymap = new TreeMap<Member, List<Member>>();
			for (int hhi = 0; hhi < RptTopMemberDetails.size(); hhi++) {
				List<MemberFamily> MemberFamilyList = memberFamilyService
						.FamilymemberSpecific(RptTopMemberDetails.get(hhi).getMemberID());

				ArrayList<Member> MemberFamilyListDetails = new ArrayList<Member>();

				for (int hhif = 0; hhif < MemberFamilyList.size(); hhif++) {
					
					Member m1=memberService.findByMemberID(MemberFamilyList.get(hhif).getMemberID()).get(0);
					m1.setSpouse_Name(MemberFamilyList.get(hhif).getRelationship());
					MemberFamilyListDetails
							.add(m1);
				}

				Familymap.put(RptTopMemberDetails.get(hhi), MemberFamilyListDetails);

			}

			// End Member Details process----------------------------------------------
			// --------------------------------------------------------------------------
			model.addAttribute("ReportAllmemberdetails", ReportAllmemberdetails);
			model.addAttribute("RptMemberDetails", RptMemberDetails);
			model.addAttribute("RptTopMemberDetails", RptTopMemberDetails);
			model.addAttribute("Familymap", Familymap);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return "rptMemberFullDetailsWithfamily";
		}

	}

	@GetMapping("ReportOthers")
	public String ReportOthers(Model model) {
		return "rptOthers";
	}

	@GetMapping("Color")
	public String Color(Model model) {
		return "Color";
	}

	@GetMapping("ReportDOB")
	public String rptMemberDOB(Model model) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("M/d");

		String dobDate = dateFormat.format(new Date());
		// dobDate="1/1";
		List<Member> membersDOBlist = memberService.findDOBReport(dobDate);
		model.addAttribute("members", membersDOBlist);
		model.addAttribute("dobDate", java.time.LocalDate.now());
		return "rptMemberDOB";
	}

	@PostMapping("ReportDOB")
	public String rptMemberDOBPost(Model model, @RequestParam("DOB") String dobDate) {

		// ----------------------------------------
		Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dobDate);
			SimpleDateFormat dateFormat = new SimpleDateFormat("M/d");
			String dobDateStr = dateFormat.format(date1);
			List<Member> membersDOBlist = memberService.findDOBReport(dobDateStr);
			model.addAttribute("members", membersDOBlist);
			model.addAttribute("dobDate", dobDate);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ----------------------------------------
		return "rptMemberDOB";
	}

	@GetMapping("ReportWedd")
	public String rptMemberWedding(Model model) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("M-d");

		String wobDate = dateFormat.format(new Date());
		// dobDate="1/1";
		List<Member> membersWOBlist = memberService.findWOBReport(wobDate);
		model.addAttribute("members", membersWOBlist);
		model.addAttribute("wobDate", java.time.LocalDate.now());
		return "rptMemberWedding";
	}

	@PostMapping("ReportWedd")
	public String rptMemberWeddingPost(Model model, @RequestParam("WOD") String wobDate) {
		// ----------------------------------------
		Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(wobDate);
			SimpleDateFormat dateFormat = new SimpleDateFormat("M-d");
			String wobDateStr = dateFormat.format(date1);
			List<Member> membersWOBlist = memberService.findWOBReport(wobDateStr);
			model.addAttribute("members", membersWOBlist);
			model.addAttribute("wobDate", wobDate);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ----------------------------------------
		return "rptMemberWedding";
	}

	@GetMapping("ReportBloodGroup")
	public String rptMemberBloodGrp(Model model) {

		return "rptMemberBloodGrp";
	}

	@PostMapping("ReportBloodGroup")
	public String rptMemberBloodGrpPost(Model model, @RequestParam("bloodGroup") String bloodGroup) {

		try {

			List<Member> membersWOBlist = memberService.findBloodGReport(bloodGroup);
			model.addAttribute("members", membersWOBlist);
			model.addAttribute("bloodGroup", bloodGroup);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ----------------------------------------
		return "rptMemberBloodGrp";
	}

	@GetMapping("login")
	public String login(Model model) {

		return "login";
	}

}
