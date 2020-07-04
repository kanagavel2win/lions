package com.lionsclub.springboot.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lionsclub.springboot.thymeleaf.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	@Query("SELECT m FROM Member m WHERE m.MemberID = ?1")
	public List<Member> getMemberID(String MemberID);

	// @Query("Select m From Member m where m.First_Name is null or m.Last_Name is
	// null or m.Date_of_Birth is null or m.Join_Date is null or
	// m.Member_Address_Country is null or m.Club_Name is null or
	// m.Member_Address_Line_1 is null or m.Member_Address_Line_2 is null or
	// m.Member_Address_Line_3 is null or m.Member_Address_City is null or
	// m.Cell_Phone is null or m.Email is null or m.WeddingDate is null or
	// m.Sponsor_Name is null or m.NoofDaughter is null or m.NoofSon is null or
	// m.Member_BloodGroup is null")
	@Query("Select m From Member m where m.First_Name is NULL or  m.First_Name = '' or m.Last_Name is NULL or  m.Last_Name = '' or m.Date_of_Birth is NULL or  m.Date_of_Birth = '' or m.Join_Date is NULL or  m.Join_Date = '' or m.Member_Address_Country is NULL or  m.Member_Address_Country = '' or m.Club_Name is NULL or  m.Club_Name = '' or m.Member_Address_Line_1 is NULL or  m.Member_Address_Line_1 = '' or m.Member_Address_Line_2 is NULL or  m.Member_Address_Line_2 = '' or m.Member_Address_Line_3 is NULL or  m.Member_Address_Line_3 = '' or m.Member_Address_City is NULL or  m.Member_Address_City = '' or m.Cell_Phone is NULL or  m.Cell_Phone = '' or m.Email is NULL or  m.Email = '' or m.WeddingDate is NULL or  m.WeddingDate = '' or m.Sponsor_Name is NULL or  m.Sponsor_Name = '' or m.NoofDaughter is NULL or  m.NoofDaughter = '' or m.NoofSon is NULL or  m.NoofSon = '' or m.Member_BloodGroup is NULL or  m.Member_BloodGroup = ''")
	public List<Member> getNotfilledMandatoryFields();

	@Query("Select m From Member m where m.Title != '' Order By ReportPriorityOrder")
	public List<Member> getRptTopMemberDetails();

	@Query("Select m From Member m where m.Title = '' Order By First_Name asc")
	public List<Member> getRptMemberDetails();

	@Query("Select m From Member m where m.Date_of_Birth LIKE CONCAT('%' ,:dobDate, '%')")
	public List<Member> getRptMemberDetailsDOB(@Param("dobDate") String dobDate);

	@Query("Select m From Member m where m.WeddingDate LIKE CONCAT('%' ,:wobDate, '%')")
	public List<Member> getRptMemberDetailsWOB(@Param("wobDate") String wobDate);

	@Query("Select m From Member m where m.Member_BloodGroup LIKE CONCAT('%' ,:bloodGroup, '%')")
	public List<Member> getRptMemberDetailsBloodGroup(@Param("bloodGroup") String bloodGroup);

	@Query("Select m From Member m where m.Family_Unit ='Family Unit Member'")
	public List<Member> getFamilyMemberDetails(@Param("MemberID") String MemberID);

	@Query("Select m From Member m where m.Family_Unit ='Head of Household'")
	public List<Member> getHouseholderdetails();
	
	@Query("Select m.MemberID From Member m")
	public List<String>  getAllMemberID();
}
