package com.lionsclub.springboot.thymeleaf.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.util.TextUtils;

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
	public String internationalLions() {
		return "internationlionssite";
	}

	@GetMapping("/memberedit")
	public String memberadd(@RequestParam("id") int memberid, Model theModel) {

		Member editmemberDetails = memberService.findById(memberid);

		theModel.addAttribute("members", editmemberDetails);
		theModel.addAttribute("savestatus", false);

		return "memberadd";
	}

	@PostMapping("/memberedit")
	public String membersave(HttpServletRequest request, @ModelAttribute("members") Member member,
			@RequestParam("profilepicture") MultipartFile profilepicture, Model themodel) {

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
		try
		{
		List<Member> NotfilledMandatoryFieldsmemberDetails = memberService.getNotfilledMandatoryFields();

		/*ArrayList<String> emptyFieldList = new ArrayList<>();

		for (int i = 0; i < NotfilledMandatoryFieldsmemberDetails.size(); i++) {
			Member mDetails = NotfilledMandatoryFieldsmemberDetails.get(i);
			String emptyFieldName="";
			
			if (String.valueOf(mDetails.getFirst_Name()) == "null" ||String.valueOf(mDetails.getFirst_Name()) == "" ) {
				emptyFieldName= emptyFieldName + "First_Name, ";
			}
			if (String.valueOf(mDetails.getLast_Name()) == "null" ||mDetails.getLast_Name().isEmpty()) {
				emptyFieldName= emptyFieldName + "Last_Name, ";
			}
			if (String.valueOf(mDetails.getDate_of_Birth()) == "null" ||String.valueOf(mDetails.getDate_of_Birth()) == "" ) {
				emptyFieldName= emptyFieldName + "Date_of_Birth, ";
			}
			if (String.valueOf(mDetails.getJoin_Date()) == "null" ||String.valueOf(mDetails.getJoin_Date()) == "" ) {
				emptyFieldName= emptyFieldName + "Join_Date, ";
			}
			if (String.valueOf(mDetails.getMember_Address_Country()) == "null" ||String.valueOf(mDetails.getMember_Address_Country()) == "" ) {
				emptyFieldName= emptyFieldName + "Member_Address_Country, ";
			}
			if (String.valueOf(mDetails.getClub_Name()) == "null" ||String.valueOf(mDetails.getClub_Name()) == "" ) {
				emptyFieldName= emptyFieldName + "Club_Name, ";
			}
			if (String.valueOf(mDetails.getMember_Address_Line_1()) == "null" ||String.valueOf(mDetails.getMember_Address_Line_1()) == "" ) {
				emptyFieldName= emptyFieldName + "Member_Address_Line_1, ";
			}
			if (String.valueOf(mDetails.getMember_Address_Line_2()) == "null" ||String.valueOf(mDetails.getMember_Address_Line_2()) == "" ) {
				emptyFieldName= emptyFieldName + "Member_Address_Line_2, ";
			}
			if (String.valueOf(mDetails.getMember_Address_Line_3()) == "null" ||String.valueOf(mDetails.getMember_Address_Line_3()) == "" ) {
				emptyFieldName= emptyFieldName + "Member_Address_Line_3, ";
			}
			if (String.valueOf(mDetails.getMember_Address_City()) == "null" ||String.valueOf(mDetails.getMember_Address_City()) == "" ) {
				emptyFieldName= emptyFieldName + "Member_Address_City, ";
			}
			if (String.valueOf(mDetails.getCell_Phone()) == "null" ||String.valueOf(mDetails.getCell_Phone()) == "" ) {
				emptyFieldName= emptyFieldName + "Cell_Phone, ";
			}
			if (String.valueOf(mDetails.getEmail()) == "null" ||String.valueOf(mDetails.getEmail()) == "" ) {
				emptyFieldName= emptyFieldName + "Email, ";
			}
			
			if (String.valueOf(mDetails.getWeddingDate()) == "null" ||String.valueOf(mDetails.getWeddingDate()) == "" ) {
				emptyFieldName= emptyFieldName + "WeddingDate, ";
			}
			if (String.valueOf(mDetails.getSponsor_Name()) == "null" ||String.valueOf(mDetails.getSponsor_Name()) == "" ) {
				emptyFieldName= emptyFieldName + "Sponsor_Name, ";
			}
			if (String.valueOf(mDetails.getNoofDaughter()) == "null" || String.valueOf(mDetails.getNoofDaughter()) == "" ) {
				emptyFieldName= emptyFieldName + "NoofDaughter, ";
			}
			if (String.valueOf(mDetails.getNoofSon()) == "null" ||String.valueOf(mDetails.getNoofSon()) == "" ) {
				emptyFieldName= emptyFieldName + "NoofSon	, ";
			}
			if (String.valueOf(mDetails.getMember_BloodGroup()) == "null" ||String.valueOf(mDetails.getMember_BloodGroup()) == "" ) {
				emptyFieldName= emptyFieldName + "Member_BloodGroup, ";
			}
			
			emptyFieldList.add(emptyFieldName);
			emptyFieldName="";
		}
		model.addAttribute("emptyFieldList", emptyFieldList);*/
		model.addAttribute("NotfilledMandatoryFieldsmemberDetails", NotfilledMandatoryFieldsmemberDetails);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return "rptMemberPendingdetails";
		
		
	}
	public static boolean compare(String str1, String str2) {
	    return (str1 == null ? str2 == null : str1.equals(str2));
	}

}
