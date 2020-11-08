package com.lionsclub.springboot.thymeleaf.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import com.lionsclub.springboot.thymeleaf.entity.ServiceCategory;
import com.lionsclub.springboot.thymeleaf.entity.ServiceDataNew;
import com.lionsclub.springboot.thymeleaf.entity.ServiceMaster;
import com.lionsclub.springboot.thymeleaf.entity.User;
import com.lionsclub.springboot.thymeleaf.service.ServiceCategoryInterf;
import com.lionsclub.springboot.thymeleaf.service.ServiceDataNewInterf;
import com.lionsclub.springboot.thymeleaf.service.ServiceInterf;

@Controller
public class ServiceController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ServiceInterf serviceRepository;

	@Autowired
	private ServiceDataNewInterf ServiceDataNewRepository;

	@Autowired
	private ServiceCategoryInterf serviceCategoryRepository;

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


	@PostMapping("servicereportJS")
	public String servicereportJS(Model model, @RequestParam("filterData") String filterData) {
		List<String> clubIDList = serviceCategoryRepository.getClubIDListUsingCateg(filterData);

		

		ArrayList<ServiceDataNew> tMapServiceData=new ArrayList< ServiceDataNew>();
		List<ServiceDataNew> serviceData = ServiceDataNewRepository.findAll();
		
		ServiceMaster serviceMaster = serviceRepository.findAll().get(0);

		int beneficiaryPoint = Integer.parseInt(serviceMaster.getBeneficiary());
		int donatePoint = Integer.parseInt(serviceMaster.getDonate());
		int volunteersPoint = Integer.parseInt(serviceMaster.getVolunteers());
		int activity_pointPoint = Integer.parseInt(serviceMaster.getActivityPoint());
		int lionshoursPoint = Integer.parseInt(serviceMaster.getLionshours());
		double totalPoint = 1;

		
		for (ServiceDataNew serviceData2 : serviceData) {
			if (clubIDList.contains(serviceData2.getClubID())) {

				totalPoint = (serviceData2.getPeopleServed() * beneficiaryPoint)
						+ (serviceData2.getFundsDonatedUSD() * donatePoint)
						+ (serviceData2.getTotalVolunteers() * volunteersPoint)
						+ (serviceData2.getNumberOfActivities() * activity_pointPoint)
						+ (serviceData2.getTotalVolunteerHours() * lionshoursPoint);
				
				serviceData2.setTotalPoints((int)totalPoint);
				tMapServiceData.add(serviceData2);
			}
		}
		Collections.sort(tMapServiceData, Collections.reverseOrder());
		model.addAttribute("services", tMapServiceData);

		return "servicereportJS";
	}
	@GetMapping("servicereport")
	public String servicereport(Model model) {

		List<ServiceDataNew> serviceDataList = ServiceDataNewRepository.findAll();
		ServiceMaster serviceMaster = serviceRepository.findAll().get(0);

		int beneficiaryPoint = Integer.parseInt(serviceMaster.getBeneficiary());
		int donatePoint = Integer.parseInt(serviceMaster.getDonate());
		int volunteersPoint = Integer.parseInt(serviceMaster.getVolunteers());
		int activity_pointPoint = Integer.parseInt(serviceMaster.getActivityPoint());
		int lionshoursPoint = Integer.parseInt(serviceMaster.getLionshours());
		double totalPoint = 1;

		ArrayList<ServiceDataNew> services=new ArrayList< ServiceDataNew>(); 
		for (ServiceDataNew serviceDataNew : serviceDataList) {
			totalPoint = (serviceDataNew.getPeopleServed() * beneficiaryPoint)
					+ (serviceDataNew.getFundsDonatedUSD() * donatePoint)
					+ (serviceDataNew.getTotalVolunteers() * volunteersPoint)
					+ (serviceDataNew.getNumberOfActivities() * activity_pointPoint)
					+ (serviceDataNew.getTotalVolunteerHours() * lionshoursPoint);
			
			serviceDataNew.setTotalPoints((int)totalPoint);
			services.add(serviceDataNew);
		}
		Collections.sort(services, Collections.reverseOrder());

		model.addAttribute("services", services);
		return "servicereport";
	}

	@PostMapping("serviceupload")
	public String servicepostUploadcsv(@RequestParam("file") MultipartFile fileSrc, Model model,
			RedirectAttributes redirectAttributes) {

		// validate file
		if (fileSrc.isEmpty()) {
			model.addAttribute("message", "Please select a CSV file to upload.");
			model.addAttribute("status", false);
		} else {

			ServiceDataNewRepository.deleteAll();
			HashMap<String, ServiceDataNew> ServiceDataMap = new HashMap<String, ServiceDataNew>();
			try {

				XSSFWorkbook wb = new XSSFWorkbook(fileSrc.getInputStream());
				XSSFSheet sheet = wb.getSheetAt(0);
				Iterator<Row> itr = sheet.iterator();
				itr.next();
				while (itr.hasNext()) {
					Row row = itr.next();
					Iterator<Cell> cellIterator = row.cellIterator();

					int cellLooper = 1;
					String Name = "";
					String ID = "";
					String Club_Type = "";
					String Club_Specialty = "";
					String Activity_Type = "";
					double Number_of_Activities = 0;
					double People_Served = 0;
					double Total_Volunteers = 0;
					double Total_Volunteer_Hours = 0;
					double Funds_Donated_USD = 0;
					double Funds_Raised_USD = 0;

					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						switch (cellLooper) {
						case 1:
							Name = cell.getStringCellValue().toString();
							break;
						case 2:
							ID = getExcelCellValues(cell);
							break;
						case 3:
							Club_Type = getExcelCellValues(cell);
							break;
						case 4:
							Club_Specialty = getExcelCellValues(cell);
							break;
						case 5:
							Activity_Type = getExcelCellValues(cell);
							break;
						case 6:
							Number_of_Activities = Double.parseDouble(getExcelCellValues(cell));
							break;
						case 7:
							People_Served = Double.parseDouble(getExcelCellValues(cell));
							break;
						case 8:
							Total_Volunteers = Double.parseDouble(getExcelCellValues(cell));
							break;
						case 9:
							Total_Volunteer_Hours = Double.parseDouble(getExcelCellValues(cell));
							break;
						case 10:
							Funds_Donated_USD = (int) cell.getNumericCellValue();
							break;
						case 11:
							Funds_Raised_USD = (int) cell.getNumericCellValue();
							break;

						default:
						}
						cellLooper++;
					}

					if (ServiceDataMap.containsKey(ID)) {
						ServiceDataNew serObj = ServiceDataMap.get(ID);
						serObj.setNumberOfActivities(serObj.getNumberOfActivities() + Number_of_Activities);
						serObj.setPeopleServed(serObj.getPeopleServed() + People_Served);
						serObj.setTotalVolunteers(serObj.getTotalVolunteers() + Total_Volunteers);
						serObj.setTotalVolunteerHours(serObj.getTotalVolunteerHours() + Total_Volunteer_Hours);
						serObj.setFundsDonatedUSD(serObj.getFundsDonatedUSD() + Funds_Donated_USD);
						serObj.setFundsRaisedUSD(serObj.getFundsRaisedUSD() + Funds_Raised_USD);
						ServiceDataMap.replace(ID, serObj);

					} else {
						ServiceDataNew serObj = new ServiceDataNew();
						serObj.setName(Name);
						serObj.setClubID(ID);
						serObj.setClubType(Club_Type);
						serObj.setClubSpecialty(Club_Specialty);
						serObj.setActivityType(Activity_Type);
						serObj.setNumberOfActivities(Number_of_Activities);
						serObj.setPeopleServed(People_Served);
						serObj.setTotalVolunteers(Total_Volunteers);
						serObj.setTotalVolunteerHours(Total_Volunteer_Hours);
						serObj.setFundsDonatedUSD(Funds_Donated_USD);
						serObj.setFundsRaisedUSD(Funds_Raised_USD);
						ServiceDataMap.put(ID, serObj);
					}

				}
				wb.close();

				// Save
				for (Map.Entry<String, ServiceDataNew> SerObj : ServiceDataMap.entrySet()) {
					ServiceDataNewRepository.save(SerObj.getValue());

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			model.addAttribute("status", true);
		}

		return "serviceuploadcsv";
	}

	public String getExcelCellValues(Cell cell) {

		Object str = "";
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_BOOLEAN:
			str = cell.getBooleanCellValue();
			break;
		case Cell.CELL_TYPE_NUMERIC:
			str = cell.getNumericCellValue();
			break;
		case Cell.CELL_TYPE_STRING:
			str = cell.getRichStringCellValue();
			break;
		default:
		}
		return String.valueOf(str);
	}

	@GetMapping("serviceClubCategory")
	public String serviceClubCategory(Model model) {

		List<ServiceDataNew> servicemaster = ServiceDataNewRepository.findAll();

		List<ServiceDataNew> servicemastertemp = new ArrayList<ServiceDataNew>();
		for (ServiceDataNew ServiceDataNew : servicemaster) {

			List<ServiceCategory> serviceCategorylist = serviceCategoryRepository
					.getServiceUsingClubID(ServiceDataNew.getClubID());
			if (serviceCategorylist.size() > 0) {
				ServiceDataNew.setClubSpecialty(serviceCategorylist.get(0).getClubCatogery());

			} else {
				ServiceDataNew.setClubSpecialty("Not_in_AnyCategory");
			}

			servicemastertemp.add(ServiceDataNew);
		}

		model.addAttribute("servicemaster", servicemastertemp);

		return "serviceClubCategory";
	}

	@PostMapping("serviceClubCategory")
	public String serviceClubCategoryPost(Model model, @RequestParam("name") String[] CompanyIdArr,
			@RequestParam("ClubCategory") String[] ClubCategoryArr) {

		
		  for (int i = 0; i < ClubCategoryArr.length; i++) {
		  
		  String clubIDtemp = CompanyIdArr[i]; String clubCategoryTemp =
		  ClubCategoryArr[i];
		  
		  List<ServiceCategory> serviceCategorylist =
		  serviceCategoryRepository.getServiceUsingClubID(clubIDtemp); if
		  (serviceCategorylist.size() > 0) {
		  
		  ServiceCategory obj = serviceCategorylist.get(0);
		  obj.setClubCatogery(clubCategoryTemp); serviceCategoryRepository.save(obj); }
		  else { ServiceCategory obj = new ServiceCategory();
		  obj.setClubCatogery(clubCategoryTemp); obj.setClubID(clubIDtemp);
		  serviceCategoryRepository.save(obj); }
		  
		  }
		  
		  List<ServiceDataNew> servicemaster = ServiceDataNewRepository.findAll();
		  List<ServiceDataNew> servicemastertemp = new ArrayList<ServiceDataNew>(); for
		  (ServiceDataNew ServiceDataNew : servicemaster) {
		  
		  List<ServiceCategory> serviceCategorylist = serviceCategoryRepository
		  .getServiceUsingClubID(ServiceDataNew.getClubID()); if
		  (serviceCategorylist.size() > 0) {
		  ServiceDataNew.setClubSpecialty(serviceCategorylist.get(0).
		  getClubCatogery());
		  
		  } else { ServiceDataNew.setClubSpecialty("Not_in_AnyCategory"); }
		  
		  servicemastertemp.add(ServiceDataNew); } model.addAttribute("savestatus",
		  true); model.addAttribute("servicemaster", servicemastertemp);
		 
		return "serviceClubCategory";
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
