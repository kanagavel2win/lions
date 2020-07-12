package com.lionsclub.springboot.thymeleaf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class Member implements Comparable<Member> {

	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column
	private String Multiple_District_Name;
	@Column
	private String District_Name;
	@Column
	private String Region_Name;
	@Column
	private String Zone_Name;
	@Column
	private String Title;
	@Column
	private String Club_ID;
	@Column
	private String Club_Name;
	@Column
	private String MemberID;
	@Column
	private String Prefix;
	@Column
	private String First_Name;
	@Column
	private String Middle_Name;
	@Column
	private String Last_Name;
	@Column
	private String Suffix;
	@Column
	private String Invalid_Member_Address_Flag;
	@Column
	private String Member_Address_Line_1;
	@Column
	private String Member_Address_Line_2;
	@Column
	private String Member_Address_Line_3;
	@Column
	private String Member_Address_Line_4;
	@Column
	private String Member_Address_City;
	@Column
	private String Member_Address_State;
	@Column
	private String Member_Address_Postal_Code;
	@Column
	private String Member_Address_Country;
	@Column
	private String Invalid_Officer_Address_Flag;
	@Column
	private String Officer_Address_Line_1;
	@Column
	private String Officer_Address_Line_2;
	@Column
	private String Officer_Address_Line_3;
	@Column
	private String Officer_Address_Line_4;
	@Column
	private String Officer_Address_City;
	@Column
	private String Officer_Address_State;
	@Column
	private String Officer_Address_Postal_Code;
	@Column
	private String Officer_Address_Country;
	@Column
	private String Email;
	@Column
	private String Home_Phone;
	@Column
	private String Cell_Phone;
	@Column
	private String Fax_Number;
	@Column
	private String Work_Phone;
	@Column
	private String Spouse_Name;
	@Column
	private String Membership_Type;
	@Column
	private String Date_of_Birth;
	@Column
	private String Gender;
	@Column
	private String Nick_Name;
	@Column
	private String Occupation;
	@Column
	private String Join_Date;
	@Column
	private String Life_Member;
	@Column
	private String Family_Unit;
	@Column
	private String Sponsor_Name;
	@Column
	private String Club_Branch_Name;
	@Column
	private String International_Discount;
	@Column
	private String International_Discount_Reason;
	@Column
	private String Member_BloodGroup;
	@Column
	private String WeddingDate;
	@Column
	private String Spouse_BloodGroup;
	@Column
	private String Spouse_DOB;
	@Column
	private String Designation;

	@Column
	private String ProfileImg;

	@Column
	private String NoofSon;

	@Column
	private String NoofDaughter;

	@Column(nullable = false)
	private int ReportPriorityOrder = 0;

	@Column(nullable = false)
	private String bgColorValue;

	@Column(nullable = false)
	private String TextColorValue;

	@Column
	private String BusinessLink;

	@Column
	private String Rptaddresstype;

	@Column
	private Boolean deletedStatus;

	// ------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------
	// define constructors
	public Member() {
	}

	@Override
	public int compareTo(Member o) {
		// TODO Auto-generated method stub

		return (this.getReportPriorityOrder() - o.getReportPriorityOrder());

	}

	public Member(int id, String multiple_District_Name, String district_Name, String region_Name, String zone_Name,
			String title, String club_ID, String club_Name, String memberID, String prefix, String first_Name,
			String middle_Name, String last_Name, String suffix, String invalid_Member_Address_Flag,
			String member_Address_Line_1, String member_Address_Line_2, String member_Address_Line_3,
			String member_Address_Line_4, String member_Address_City, String member_Address_State,
			String member_Address_Postal_Code, String member_Address_Country, String invalid_Officer_Address_Flag,
			String officer_Address_Line_1, String officer_Address_Line_2, String officer_Address_Line_3,
			String officer_Address_Line_4, String officer_Address_City, String officer_Address_State,
			String officer_Address_Postal_Code, String officer_Address_Country, String email, String home_Phone,
			String cell_Phone, String fax_Number, String work_Phone, String spouse_Name, String membership_Type,
			String date_of_Birth, String gender, String nick_Name, String occupation, String join_Date,
			String life_Member, String family_Unit, String sponsor_Name, String club_Branch_Name,
			String international_Discount, String international_Discount_Reason, String member_BloodGroup,
			String weddingDate, String spouse_BloodGroup, String spouse_DOB, String designation, String profileImg,
			String noofSon, String noofDaughter, int reportPriorityOrder, String bgColorValue, String textColorValue,
			String businessLink, String rptaddresstype, Boolean deletedStatus) {
		super();
		this.id = id;
		Multiple_District_Name = multiple_District_Name;
		District_Name = district_Name;
		Region_Name = region_Name;
		Zone_Name = zone_Name;
		Title = title;
		Club_ID = club_ID;
		Club_Name = club_Name;
		MemberID = memberID;
		Prefix = prefix;
		First_Name = first_Name;
		Middle_Name = middle_Name;
		Last_Name = last_Name;
		Suffix = suffix;
		Invalid_Member_Address_Flag = invalid_Member_Address_Flag;
		Member_Address_Line_1 = member_Address_Line_1;
		Member_Address_Line_2 = member_Address_Line_2;
		Member_Address_Line_3 = member_Address_Line_3;
		Member_Address_Line_4 = member_Address_Line_4;
		Member_Address_City = member_Address_City;
		Member_Address_State = member_Address_State;
		Member_Address_Postal_Code = member_Address_Postal_Code;
		Member_Address_Country = member_Address_Country;
		Invalid_Officer_Address_Flag = invalid_Officer_Address_Flag;
		Officer_Address_Line_1 = officer_Address_Line_1;
		Officer_Address_Line_2 = officer_Address_Line_2;
		Officer_Address_Line_3 = officer_Address_Line_3;
		Officer_Address_Line_4 = officer_Address_Line_4;
		Officer_Address_City = officer_Address_City;
		Officer_Address_State = officer_Address_State;
		Officer_Address_Postal_Code = officer_Address_Postal_Code;
		Officer_Address_Country = officer_Address_Country;
		Email = email;
		Home_Phone = home_Phone;
		Cell_Phone = cell_Phone;
		Fax_Number = fax_Number;
		Work_Phone = work_Phone;
		Spouse_Name = spouse_Name;
		Membership_Type = membership_Type;
		Date_of_Birth = date_of_Birth;
		Gender = gender;
		Nick_Name = nick_Name;
		Occupation = occupation;
		Join_Date = join_Date;
		Life_Member = life_Member;
		Family_Unit = family_Unit;
		Sponsor_Name = sponsor_Name;
		Club_Branch_Name = club_Branch_Name;
		International_Discount = international_Discount;
		International_Discount_Reason = international_Discount_Reason;
		Member_BloodGroup = member_BloodGroup;
		WeddingDate = weddingDate;
		Spouse_BloodGroup = spouse_BloodGroup;
		Spouse_DOB = spouse_DOB;
		Designation = designation;
		ProfileImg = profileImg;
		NoofSon = noofSon;
		NoofDaughter = noofDaughter;
		ReportPriorityOrder = reportPriorityOrder;
		this.bgColorValue = bgColorValue;
		TextColorValue = textColorValue;
		BusinessLink = businessLink;
		Rptaddresstype = rptaddresstype;
		this.deletedStatus = deletedStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMultiple_District_Name() {
		return Multiple_District_Name;
	}

	public void setMultiple_District_Name(String multiple_District_Name) {
		Multiple_District_Name = multiple_District_Name;
	}

	public String getDistrict_Name() {
		return District_Name;
	}

	public void setDistrict_Name(String district_Name) {
		District_Name = district_Name;
	}

	public String getRegion_Name() {
		return Region_Name;
	}

	public void setRegion_Name(String region_Name) {
		Region_Name = region_Name;
	}

	public String getZone_Name() {
		return Zone_Name;
	}

	public void setZone_Name(String zone_Name) {
		Zone_Name = zone_Name;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getClub_ID() {
		return Club_ID;
	}

	public void setClub_ID(String club_ID) {
		Club_ID = club_ID;
	}

	public String getClub_Name() {
		return Club_Name;
	}

	public void setClub_Name(String club_Name) {
		Club_Name = club_Name;
	}

	public String getMemberID() {
		return MemberID;
	}

	public void setMemberID(String memberID) {
		MemberID = memberID;
	}

	public String getPrefix() {
		return Prefix;
	}

	public void setPrefix(String prefix) {
		Prefix = prefix;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getMiddle_Name() {
		return Middle_Name;
	}

	public void setMiddle_Name(String middle_Name) {
		Middle_Name = middle_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public String getSuffix() {
		return Suffix;
	}

	public void setSuffix(String suffix) {
		Suffix = suffix;
	}

	public String getInvalid_Member_Address_Flag() {
		return Invalid_Member_Address_Flag;
	}

	public void setInvalid_Member_Address_Flag(String invalid_Member_Address_Flag) {
		Invalid_Member_Address_Flag = invalid_Member_Address_Flag;
	}

	public String getMember_Address_Line_1() {
		return Member_Address_Line_1;
	}

	public void setMember_Address_Line_1(String member_Address_Line_1) {
		Member_Address_Line_1 = member_Address_Line_1;
	}

	public String getMember_Address_Line_2() {
		return Member_Address_Line_2;
	}

	public void setMember_Address_Line_2(String member_Address_Line_2) {
		Member_Address_Line_2 = member_Address_Line_2;
	}

	public String getMember_Address_Line_3() {
		return Member_Address_Line_3;
	}

	public void setMember_Address_Line_3(String member_Address_Line_3) {
		Member_Address_Line_3 = member_Address_Line_3;
	}

	public String getMember_Address_Line_4() {
		return Member_Address_Line_4;
	}

	public void setMember_Address_Line_4(String member_Address_Line_4) {
		Member_Address_Line_4 = member_Address_Line_4;
	}

	public String getMember_Address_City() {
		return Member_Address_City;
	}

	public void setMember_Address_City(String member_Address_City) {
		Member_Address_City = member_Address_City;
	}

	public String getMember_Address_State() {
		return Member_Address_State;
	}

	public void setMember_Address_State(String member_Address_State) {
		Member_Address_State = member_Address_State;
	}

	public String getMember_Address_Postal_Code() {
		return Member_Address_Postal_Code;
	}

	public void setMember_Address_Postal_Code(String member_Address_Postal_Code) {
		Member_Address_Postal_Code = member_Address_Postal_Code;
	}

	public String getMember_Address_Country() {
		return Member_Address_Country;
	}

	public void setMember_Address_Country(String member_Address_Country) {
		Member_Address_Country = member_Address_Country;
	}

	public String getInvalid_Officer_Address_Flag() {
		return Invalid_Officer_Address_Flag;
	}

	public void setInvalid_Officer_Address_Flag(String invalid_Officer_Address_Flag) {
		Invalid_Officer_Address_Flag = invalid_Officer_Address_Flag;
	}

	public String getOfficer_Address_Line_1() {
		return Officer_Address_Line_1;
	}

	public void setOfficer_Address_Line_1(String officer_Address_Line_1) {
		Officer_Address_Line_1 = officer_Address_Line_1;
	}

	public String getOfficer_Address_Line_2() {
		return Officer_Address_Line_2;
	}

	public void setOfficer_Address_Line_2(String officer_Address_Line_2) {
		Officer_Address_Line_2 = officer_Address_Line_2;
	}

	public String getOfficer_Address_Line_3() {
		return Officer_Address_Line_3;
	}

	public void setOfficer_Address_Line_3(String officer_Address_Line_3) {
		Officer_Address_Line_3 = officer_Address_Line_3;
	}

	public String getOfficer_Address_Line_4() {
		return Officer_Address_Line_4;
	}

	public void setOfficer_Address_Line_4(String officer_Address_Line_4) {
		Officer_Address_Line_4 = officer_Address_Line_4;
	}

	public String getOfficer_Address_City() {
		return Officer_Address_City;
	}

	public void setOfficer_Address_City(String officer_Address_City) {
		Officer_Address_City = officer_Address_City;
	}

	public String getOfficer_Address_State() {
		return Officer_Address_State;
	}

	public void setOfficer_Address_State(String officer_Address_State) {
		Officer_Address_State = officer_Address_State;
	}

	public String getOfficer_Address_Postal_Code() {
		return Officer_Address_Postal_Code;
	}

	public void setOfficer_Address_Postal_Code(String officer_Address_Postal_Code) {
		Officer_Address_Postal_Code = officer_Address_Postal_Code;
	}

	public String getOfficer_Address_Country() {
		return Officer_Address_Country;
	}

	public void setOfficer_Address_Country(String officer_Address_Country) {
		Officer_Address_Country = officer_Address_Country;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getHome_Phone() {
		return Home_Phone;
	}

	public void setHome_Phone(String home_Phone) {
		Home_Phone = home_Phone;
	}

	public String getCell_Phone() {
		return Cell_Phone;
	}

	public void setCell_Phone(String cell_Phone) {
		Cell_Phone = cell_Phone;
	}

	public String getFax_Number() {
		return Fax_Number;
	}

	public void setFax_Number(String fax_Number) {
		Fax_Number = fax_Number;
	}

	public String getWork_Phone() {
		return Work_Phone;
	}

	public void setWork_Phone(String work_Phone) {
		Work_Phone = work_Phone;
	}

	public String getSpouse_Name() {
		return Spouse_Name;
	}

	public void setSpouse_Name(String spouse_Name) {
		Spouse_Name = spouse_Name;
	}

	public String getMembership_Type() {
		return Membership_Type;
	}

	public void setMembership_Type(String membership_Type) {
		Membership_Type = membership_Type;
	}

	public String getDate_of_Birth() {
		return Date_of_Birth;
	}

	public void setDate_of_Birth(String date_of_Birth) {
		Date_of_Birth = date_of_Birth;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getNick_Name() {
		return Nick_Name;
	}

	public void setNick_Name(String nick_Name) {
		Nick_Name = nick_Name;
	}

	public String getOccupation() {
		return Occupation;
	}

	public void setOccupation(String occupation) {
		Occupation = occupation;
	}

	public String getJoin_Date() {
		return Join_Date;
	}

	public void setJoin_Date(String join_Date) {
		Join_Date = join_Date;
	}

	public String getLife_Member() {
		return Life_Member;
	}

	public void setLife_Member(String life_Member) {
		Life_Member = life_Member;
	}

	public String getFamily_Unit() {
		return Family_Unit;
	}

	public void setFamily_Unit(String family_Unit) {
		Family_Unit = family_Unit;
	}

	public String getSponsor_Name() {
		return Sponsor_Name;
	}

	public void setSponsor_Name(String sponsor_Name) {
		Sponsor_Name = sponsor_Name;
	}

	public String getClub_Branch_Name() {
		return Club_Branch_Name;
	}

	public void setClub_Branch_Name(String club_Branch_Name) {
		Club_Branch_Name = club_Branch_Name;
	}

	public String getInternational_Discount() {
		return International_Discount;
	}

	public void setInternational_Discount(String international_Discount) {
		International_Discount = international_Discount;
	}

	public String getInternational_Discount_Reason() {
		return International_Discount_Reason;
	}

	public void setInternational_Discount_Reason(String international_Discount_Reason) {
		International_Discount_Reason = international_Discount_Reason;
	}

	public String getMember_BloodGroup() {
		return Member_BloodGroup;
	}

	public void setMember_BloodGroup(String member_BloodGroup) {
		Member_BloodGroup = member_BloodGroup;
	}

	public String getWeddingDate() {
		return WeddingDate;
	}

	public void setWeddingDate(String weddingDate) {
		WeddingDate = weddingDate;
	}

	public String getSpouse_BloodGroup() {
		return Spouse_BloodGroup;
	}

	public void setSpouse_BloodGroup(String spouse_BloodGroup) {
		Spouse_BloodGroup = spouse_BloodGroup;
	}

	public String getSpouse_DOB() {
		return Spouse_DOB;
	}

	public void setSpouse_DOB(String spouse_DOB) {
		Spouse_DOB = spouse_DOB;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getProfileImg() {
		return ProfileImg;
	}

	public void setProfileImg(String profileImg) {
		ProfileImg = profileImg;
	}

	public String getNoofSon() {
		return NoofSon;
	}

	public void setNoofSon(String noofSon) {
		NoofSon = noofSon;
	}

	public String getNoofDaughter() {
		return NoofDaughter;
	}

	public void setNoofDaughter(String noofDaughter) {
		NoofDaughter = noofDaughter;
	}

	public int getReportPriorityOrder() {
		return ReportPriorityOrder;
	}

	public void setReportPriorityOrder(int reportPriorityOrder) {
		ReportPriorityOrder = reportPriorityOrder;
	}

	public String getBgColorValue() {
		return bgColorValue;
	}

	public void setBgColorValue(String bgColorValue) {
		this.bgColorValue = bgColorValue;
	}

	public String getTextColorValue() {
		return TextColorValue;
	}

	public void setTextColorValue(String textColorValue) {
		TextColorValue = textColorValue;
	}

	public String getBusinessLink() {
		return BusinessLink;
	}

	public void setBusinessLink(String businessLink) {
		BusinessLink = businessLink;
	}

	public String getRptaddresstype() {
		return Rptaddresstype;
	}

	public void setRptaddresstype(String rptaddresstype) {
		Rptaddresstype = rptaddresstype;
	}

	public Boolean getDeletedStatus() {
		return deletedStatus;
	}

	public void setDeletedStatus(Boolean deletedStatus) {
		this.deletedStatus = deletedStatus;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", Multiple_District_Name=" + Multiple_District_Name + ", District_Name="
				+ District_Name + ", Region_Name=" + Region_Name + ", Zone_Name=" + Zone_Name + ", Title=" + Title
				+ ", Club_ID=" + Club_ID + ", Club_Name=" + Club_Name + ", MemberID=" + MemberID + ", Prefix=" + Prefix
				+ ", First_Name=" + First_Name + ", Middle_Name=" + Middle_Name + ", Last_Name=" + Last_Name
				+ ", Suffix=" + Suffix + ", Invalid_Member_Address_Flag=" + Invalid_Member_Address_Flag
				+ ", Member_Address_Line_1=" + Member_Address_Line_1 + ", Member_Address_Line_2="
				+ Member_Address_Line_2 + ", Member_Address_Line_3=" + Member_Address_Line_3
				+ ", Member_Address_Line_4=" + Member_Address_Line_4 + ", Member_Address_City=" + Member_Address_City
				+ ", Member_Address_State=" + Member_Address_State + ", Member_Address_Postal_Code="
				+ Member_Address_Postal_Code + ", Member_Address_Country=" + Member_Address_Country
				+ ", Invalid_Officer_Address_Flag=" + Invalid_Officer_Address_Flag + ", Officer_Address_Line_1="
				+ Officer_Address_Line_1 + ", Officer_Address_Line_2=" + Officer_Address_Line_2
				+ ", Officer_Address_Line_3=" + Officer_Address_Line_3 + ", Officer_Address_Line_4="
				+ Officer_Address_Line_4 + ", Officer_Address_City=" + Officer_Address_City + ", Officer_Address_State="
				+ Officer_Address_State + ", Officer_Address_Postal_Code=" + Officer_Address_Postal_Code
				+ ", Officer_Address_Country=" + Officer_Address_Country + ", Email=" + Email + ", Home_Phone="
				+ Home_Phone + ", Cell_Phone=" + Cell_Phone + ", Fax_Number=" + Fax_Number + ", Work_Phone="
				+ Work_Phone + ", Spouse_Name=" + Spouse_Name + ", Membership_Type=" + Membership_Type
				+ ", Date_of_Birth=" + Date_of_Birth + ", Gender=" + Gender + ", Nick_Name=" + Nick_Name
				+ ", Occupation=" + Occupation + ", Join_Date=" + Join_Date + ", Life_Member=" + Life_Member
				+ ", Family_Unit=" + Family_Unit + ", Sponsor_Name=" + Sponsor_Name + ", Club_Branch_Name="
				+ Club_Branch_Name + ", International_Discount=" + International_Discount
				+ ", International_Discount_Reason=" + International_Discount_Reason + ", Member_BloodGroup="
				+ Member_BloodGroup + ", WeddingDate=" + WeddingDate + ", Spouse_BloodGroup=" + Spouse_BloodGroup
				+ ", Spouse_DOB=" + Spouse_DOB + ", Designation=" + Designation + ", ProfileImg=" + ProfileImg
				+ ", NoofSon=" + NoofSon + ", NoofDaughter=" + NoofDaughter + ", ReportPriorityOrder="
				+ ReportPriorityOrder + ", bgColorValue=" + bgColorValue + ", TextColorValue=" + TextColorValue
				+ ", BusinessLink=" + BusinessLink + ", Rptaddresstype=" + Rptaddresstype + ", deletedStatus="
				+ deletedStatus + "]";
	}

}
