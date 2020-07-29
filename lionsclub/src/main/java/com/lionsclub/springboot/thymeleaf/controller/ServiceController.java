package com.lionsclub.springboot.thymeleaf.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lionsclub.springboot.thymeleaf.dao.UserRepository;
import com.lionsclub.springboot.thymeleaf.entity.ServiceData;
import com.lionsclub.springboot.thymeleaf.entity.ServiceMaster;
import com.lionsclub.springboot.thymeleaf.entity.User;
import com.lionsclub.springboot.thymeleaf.service.ServiceDataInterf;
import com.lionsclub.springboot.thymeleaf.service.ServiceInterf;

@Controller
public class ServiceController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ServiceInterf serviceRepository;

	@Autowired
	private ServiceDataInterf serviceDataRepository;

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

		List<ServiceMaster> li = serviceRepository.findAll();
		model.addAttribute("services", li);
		return "MemberService";
	}

	@GetMapping("Serviceadd")
	public String ServiceMasteradd(Model model, @RequestParam("id") int serid) {
		ServiceMaster serObj;
		if (serid > 0) {
			serObj = serviceRepository.findById(serid);
		} else {
			serObj = new ServiceMaster();
		}

		model.addAttribute("service", serObj);
		return "serviceadd";
	}

	@PostMapping("Serviceadd")
	public String ServiceMasteraddsave(@ModelAttribute("members") ServiceMaster serviceMaster, Model model) {

		serviceRepository.save(serviceMaster);
		model.addAttribute("savestatus", true);
		model.addAttribute("service", serviceMaster);
		return "serviceadd";
	}

	@GetMapping("serviceupload")
	public String SeriveUploadcsv() {

		return "serviceuploadcsv";
	}

	@PostMapping("serviceupload")
	public String servicepostUploadcsv(@RequestParam("file") MultipartFile file, Model model,
			RedirectAttributes redirectAttributes) {

		int newMemberIDdetailsCount = 0;
		// validate file
		if (file.isEmpty()) {
			model.addAttribute("message", "Please select a CSV file to upload.");
			model.addAttribute("status", false);
		} else {

			serviceDataRepository.deleteAll();

			try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
				String line = br.readLine(); // Reading header, Ignoring
				while ((line = br.readLine()) != null && !line.isEmpty()) {


					String[] fields = new String[47];
					fields = line.split(",");
					// ------------------------------------------------------------------------------------
					// ------------------------------------------------------------------------------------
					// Split data from csv field level
					String TotalRowCount = fields[0];
					String VisionCount = fields[1];
					String HungerCount = fields[2];
					String EnvironmentCount = fields[3];
					String DiabetesCount = fields[4];
					String PediatricCancerActivityCount = fields[5];
					String PediatricCancerNumberOfPeopleServed = fields[6];
					String OverallActivityCount = fields[7];
					String OverallNumberOfPeopleServed = fields[8];
					String VisionCountCampaignNumberOfPeopleServed = fields[9];
					String HungerCountCampaignNumberOfPeopleServed = fields[10];
					String EnvironmentCountCampaignNumberOfPeopleServed = fields[11];
					String DiabetesCountCampaignNumberOfPeopleServed = fields[12];
					String NonCampaignActivityCount = fields[13];
					String NonCampaignNumberOfPeopleServed = fields[14];
					String CompanyId = fields[15];
					String CompanyName = fields[16];
					String OverallVolunteerHours = fields[17];
					String DiabetesVolunteerHours = fields[18];
					String EnvironmentVolunteerHours = fields[19];
					String PediatricCancerVolunteerHours = fields[20];
					String HungerVolunteerHours = fields[21];
					String VisionVolunteerHours = fields[22];
					String NonCampaignVolunteerHours = fields[23];
					String OverallNumberOfPeopleServedPerMember = fields[24];
					String DiabetesCountCampaignNumberOfPeopleServedPerMember = fields[25];
					String EnvironmentCountCampaignNumberOfPeopleServedPerMember = fields[26];
					String PediatricCancerNumberOfPeopleServedPerMember = fields[27];
					String HungerCountCampaignNumberOfPeopleServedPerMember = fields[28];
					String VisionCountCampaignNumberOfPeopleServedPerMember = fields[29];
					String NonCampaignNumberOfPeopleServedPerMember = fields[30];
					String CompanyMembership = fields[31];
					String FundsDonated = fields[32];
					String VisionFundsDonated = fields[33];
					String HungerFundsDonated = fields[34];
					String EnvironmentFundsDonated = fields[35];
					String DiabetesFundsDonated = fields[36];
					String PediatricCancerFundsDonated = fields[37];
					String OverallFundsDonated = fields[38];
					String VisionFundsRaised = fields[39];
					String HungerFundsRaised = fields[40];
					String EnvironmentFundsRaised = fields[41];
					String DiabetesFundsRaised = fields[42];
					String PediatricCancerFundsRaised = fields[43];
					String OverallFundsRaised = fields[44];
					String NonCampaignFundsDonated = fields[45];
					String NonCampaignFundsRaised = fields[46];
					
					ServiceData serObj= new ServiceData();
					serObj.setTotalRowCount(TotalRowCount);
					serObj.setVisionCount(VisionCount);
					serObj.setHungerCount(HungerCount);
					serObj.setEnvironmentCount(EnvironmentCount);
					serObj.setDiabetesCount(DiabetesCount);
					serObj.setPediatricCancerActivityCount(PediatricCancerActivityCount);
					serObj.setPediatricCancerNumberOfPeopleServed(PediatricCancerNumberOfPeopleServed);
					serObj.setOverallActivityCount(OverallActivityCount);
					serObj.setOverallNumberOfPeopleServed(OverallNumberOfPeopleServed);
					serObj.setVisionCountCampaignNumberOfPeopleServed(VisionCountCampaignNumberOfPeopleServed);
					serObj.setHungerCountCampaignNumberOfPeopleServed(HungerCountCampaignNumberOfPeopleServed);
					serObj.setEnvironmentCountCampaignNumberOfPeopleServed(EnvironmentCountCampaignNumberOfPeopleServed);
					serObj.setDiabetesCountCampaignNumberOfPeopleServed(DiabetesCountCampaignNumberOfPeopleServed);
					serObj.setNonCampaignActivityCount(NonCampaignActivityCount);
					serObj.setNonCampaignNumberOfPeopleServed(NonCampaignNumberOfPeopleServed);
					serObj.setCompanyId(CompanyId);
					serObj.setCompanyName(CompanyName);
					serObj.setOverallVolunteerHours(OverallVolunteerHours);
					serObj.setDiabetesVolunteerHours(DiabetesVolunteerHours);
					serObj.setEnvironmentVolunteerHours(EnvironmentVolunteerHours);
					serObj.setPediatricCancerVolunteerHours(PediatricCancerVolunteerHours);
					serObj.setHungerVolunteerHours(HungerVolunteerHours);
					serObj.setVisionVolunteerHours(VisionVolunteerHours);
					serObj.setNonCampaignVolunteerHours(NonCampaignVolunteerHours);
					serObj.setOverallNumberOfPeopleServedPerMember(OverallNumberOfPeopleServedPerMember);
					serObj.setDiabetesCountCampaignNumberOfPeopleServedPerMember(DiabetesCountCampaignNumberOfPeopleServedPerMember);
					serObj.setEnvironmentCountCampaignNumberOfPeopleServedPerMember(EnvironmentCountCampaignNumberOfPeopleServedPerMember);
					serObj.setPediatricCancerNumberOfPeopleServedPerMember(PediatricCancerNumberOfPeopleServedPerMember);
					serObj.setHungerCountCampaignNumberOfPeopleServedPerMember(HungerCountCampaignNumberOfPeopleServedPerMember);
					serObj.setVisionCountCampaignNumberOfPeopleServedPerMember(VisionCountCampaignNumberOfPeopleServedPerMember);
					serObj.setNonCampaignNumberOfPeopleServedPerMember(NonCampaignNumberOfPeopleServedPerMember);
					serObj.setCompanyMembership(CompanyMembership);
					serObj.setFundsDonated(FundsDonated);
					serObj.setVisionFundsDonated(VisionFundsDonated);
					serObj.setHungerFundsDonated(HungerFundsDonated);
					serObj.setEnvironmentFundsDonated(EnvironmentFundsDonated);
					serObj.setDiabetesFundsDonated(DiabetesFundsDonated);
					serObj.setPediatricCancerFundsDonated(PediatricCancerFundsDonated);
					serObj.setOverallFundsDonated(OverallFundsDonated);
					serObj.setVisionFundsRaised(VisionFundsRaised);
					serObj.setHungerFundsRaised(HungerFundsRaised);
					serObj.setEnvironmentFundsRaised(EnvironmentFundsRaised);
					serObj.setDiabetesFundsRaised(DiabetesFundsRaised);
					serObj.setPediatricCancerFundsRaised(PediatricCancerFundsRaised);
					serObj.setOverallFundsRaised(OverallFundsRaised);
					serObj.setNonCampaignFundsDonated(NonCampaignFundsDonated);
					serObj.setNonCampaignFundsRaised(NonCampaignFundsRaised);
					serviceDataRepository.save(serObj);
				}
				br.close();
			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

			model.addAttribute("status", true);

		}

		return "serviceuploadcsv";
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
