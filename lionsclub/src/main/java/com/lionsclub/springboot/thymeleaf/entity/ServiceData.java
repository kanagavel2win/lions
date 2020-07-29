package com.lionsclub.springboot.thymeleaf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "serviceData")
public class ServiceData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column
	private String TotalRowCount;
	@Column
	private String VisionCount;
	@Column
	private String HungerCount;
	@Column
	private String EnvironmentCount;
	@Column
	private String DiabetesCount;
	@Column
	private String PediatricCancerActivityCount;
	@Column
	private String PediatricCancerNumberOfPeopleServed;
	@Column
	private String OverallActivityCount;
	@Column
	private String OverallNumberOfPeopleServed;
	@Column
	private String VisionCountCampaignNumberOfPeopleServed;
	@Column
	private String HungerCountCampaignNumberOfPeopleServed;
	@Column
	private String EnvironmentCountCampaignNumberOfPeopleServed;
	@Column
	private String DiabetesCountCampaignNumberOfPeopleServed;
	@Column
	private String NonCampaignActivityCount;
	@Column
	private String NonCampaignNumberOfPeopleServed;
	@Column
	private String CompanyId;
	@Column
	private String CompanyName;
	@Column
	private String OverallVolunteerHours;
	@Column
	private String DiabetesVolunteerHours;
	@Column
	private String EnvironmentVolunteerHours;
	@Column
	private String PediatricCancerVolunteerHours;
	@Column
	private String HungerVolunteerHours;
	@Column
	private String VisionVolunteerHours;
	@Column
	private String NonCampaignVolunteerHours;
	@Column
	private String OverallNumberOfPeopleServedPerMember;
	@Column
	private String DiabetesCountCampaignNumberOfPeopleServedPerMember;
	@Column
	private String EnvironmentCountCampaignNumberOfPeopleServedPerMember;
	@Column
	private String PediatricCancerNumberOfPeopleServedPerMember;
	@Column
	private String HungerCountCampaignNumberOfPeopleServedPerMember;
	@Column
	private String VisionCountCampaignNumberOfPeopleServedPerMember;
	@Column
	private String NonCampaignNumberOfPeopleServedPerMember;
	@Column
	private String CompanyMembership;
	@Column
	private String FundsDonated;
	@Column
	private String VisionFundsDonated;
	@Column
	private String HungerFundsDonated;
	@Column
	private String EnvironmentFundsDonated;
	@Column
	private String DiabetesFundsDonated;
	@Column
	private String PediatricCancerFundsDonated;
	@Column
	private String OverallFundsDonated;
	@Column
	private String VisionFundsRaised;
	@Column
	private String HungerFundsRaised;
	@Column
	private String EnvironmentFundsRaised;
	@Column
	private String DiabetesFundsRaised;
	@Column
	private String PediatricCancerFundsRaised;
	@Column
	private String OverallFundsRaised;
	@Column
	private String NonCampaignFundsDonated;
	@Column
	private String NonCampaignFundsRaised;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTotalRowCount() {
		return TotalRowCount;
	}
	public void setTotalRowCount(String totalRowCount) {
		TotalRowCount = totalRowCount;
	}
	public String getVisionCount() {
		return VisionCount;
	}
	public void setVisionCount(String visionCount) {
		VisionCount = visionCount;
	}
	public String getHungerCount() {
		return HungerCount;
	}
	public void setHungerCount(String hungerCount) {
		HungerCount = hungerCount;
	}
	public String getEnvironmentCount() {
		return EnvironmentCount;
	}
	public void setEnvironmentCount(String environmentCount) {
		EnvironmentCount = environmentCount;
	}
	public String getDiabetesCount() {
		return DiabetesCount;
	}
	public void setDiabetesCount(String diabetesCount) {
		DiabetesCount = diabetesCount;
	}
	public String getPediatricCancerActivityCount() {
		return PediatricCancerActivityCount;
	}
	public void setPediatricCancerActivityCount(String pediatricCancerActivityCount) {
		PediatricCancerActivityCount = pediatricCancerActivityCount;
	}
	public String getPediatricCancerNumberOfPeopleServed() {
		return PediatricCancerNumberOfPeopleServed;
	}
	public void setPediatricCancerNumberOfPeopleServed(String pediatricCancerNumberOfPeopleServed) {
		PediatricCancerNumberOfPeopleServed = pediatricCancerNumberOfPeopleServed;
	}
	public String getOverallActivityCount() {
		return OverallActivityCount;
	}
	public void setOverallActivityCount(String overallActivityCount) {
		OverallActivityCount = overallActivityCount;
	}
	public String getOverallNumberOfPeopleServed() {
		return OverallNumberOfPeopleServed;
	}
	public void setOverallNumberOfPeopleServed(String overallNumberOfPeopleServed) {
		OverallNumberOfPeopleServed = overallNumberOfPeopleServed;
	}
	public String getVisionCountCampaignNumberOfPeopleServed() {
		return VisionCountCampaignNumberOfPeopleServed;
	}
	public void setVisionCountCampaignNumberOfPeopleServed(String visionCountCampaignNumberOfPeopleServed) {
		VisionCountCampaignNumberOfPeopleServed = visionCountCampaignNumberOfPeopleServed;
	}
	public String getHungerCountCampaignNumberOfPeopleServed() {
		return HungerCountCampaignNumberOfPeopleServed;
	}
	public void setHungerCountCampaignNumberOfPeopleServed(String hungerCountCampaignNumberOfPeopleServed) {
		HungerCountCampaignNumberOfPeopleServed = hungerCountCampaignNumberOfPeopleServed;
	}
	public String getEnvironmentCountCampaignNumberOfPeopleServed() {
		return EnvironmentCountCampaignNumberOfPeopleServed;
	}
	public void setEnvironmentCountCampaignNumberOfPeopleServed(String environmentCountCampaignNumberOfPeopleServed) {
		EnvironmentCountCampaignNumberOfPeopleServed = environmentCountCampaignNumberOfPeopleServed;
	}
	public String getDiabetesCountCampaignNumberOfPeopleServed() {
		return DiabetesCountCampaignNumberOfPeopleServed;
	}
	public void setDiabetesCountCampaignNumberOfPeopleServed(String diabetesCountCampaignNumberOfPeopleServed) {
		DiabetesCountCampaignNumberOfPeopleServed = diabetesCountCampaignNumberOfPeopleServed;
	}
	public String getNonCampaignActivityCount() {
		return NonCampaignActivityCount;
	}
	public void setNonCampaignActivityCount(String nonCampaignActivityCount) {
		NonCampaignActivityCount = nonCampaignActivityCount;
	}
	public String getNonCampaignNumberOfPeopleServed() {
		return NonCampaignNumberOfPeopleServed;
	}
	public void setNonCampaignNumberOfPeopleServed(String nonCampaignNumberOfPeopleServed) {
		NonCampaignNumberOfPeopleServed = nonCampaignNumberOfPeopleServed;
	}
	public String getCompanyId() {
		return CompanyId;
	}
	public void setCompanyId(String companyId) {
		CompanyId = companyId;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getOverallVolunteerHours() {
		return OverallVolunteerHours;
	}
	public void setOverallVolunteerHours(String overallVolunteerHours) {
		OverallVolunteerHours = overallVolunteerHours;
	}
	public String getDiabetesVolunteerHours() {
		return DiabetesVolunteerHours;
	}
	public void setDiabetesVolunteerHours(String diabetesVolunteerHours) {
		DiabetesVolunteerHours = diabetesVolunteerHours;
	}
	public String getEnvironmentVolunteerHours() {
		return EnvironmentVolunteerHours;
	}
	public void setEnvironmentVolunteerHours(String environmentVolunteerHours) {
		EnvironmentVolunteerHours = environmentVolunteerHours;
	}
	public String getPediatricCancerVolunteerHours() {
		return PediatricCancerVolunteerHours;
	}
	public void setPediatricCancerVolunteerHours(String pediatricCancerVolunteerHours) {
		PediatricCancerVolunteerHours = pediatricCancerVolunteerHours;
	}
	public String getHungerVolunteerHours() {
		return HungerVolunteerHours;
	}
	public void setHungerVolunteerHours(String hungerVolunteerHours) {
		HungerVolunteerHours = hungerVolunteerHours;
	}
	public String getVisionVolunteerHours() {
		return VisionVolunteerHours;
	}
	public void setVisionVolunteerHours(String visionVolunteerHours) {
		VisionVolunteerHours = visionVolunteerHours;
	}
	public String getNonCampaignVolunteerHours() {
		return NonCampaignVolunteerHours;
	}
	public void setNonCampaignVolunteerHours(String nonCampaignVolunteerHours) {
		NonCampaignVolunteerHours = nonCampaignVolunteerHours;
	}
	public String getOverallNumberOfPeopleServedPerMember() {
		return OverallNumberOfPeopleServedPerMember;
	}
	public void setOverallNumberOfPeopleServedPerMember(String overallNumberOfPeopleServedPerMember) {
		OverallNumberOfPeopleServedPerMember = overallNumberOfPeopleServedPerMember;
	}
	public String getDiabetesCountCampaignNumberOfPeopleServedPerMember() {
		return DiabetesCountCampaignNumberOfPeopleServedPerMember;
	}
	public void setDiabetesCountCampaignNumberOfPeopleServedPerMember(
			String diabetesCountCampaignNumberOfPeopleServedPerMember) {
		DiabetesCountCampaignNumberOfPeopleServedPerMember = diabetesCountCampaignNumberOfPeopleServedPerMember;
	}
	public String getEnvironmentCountCampaignNumberOfPeopleServedPerMember() {
		return EnvironmentCountCampaignNumberOfPeopleServedPerMember;
	}
	public void setEnvironmentCountCampaignNumberOfPeopleServedPerMember(
			String environmentCountCampaignNumberOfPeopleServedPerMember) {
		EnvironmentCountCampaignNumberOfPeopleServedPerMember = environmentCountCampaignNumberOfPeopleServedPerMember;
	}
	public String getPediatricCancerNumberOfPeopleServedPerMember() {
		return PediatricCancerNumberOfPeopleServedPerMember;
	}
	public void setPediatricCancerNumberOfPeopleServedPerMember(String pediatricCancerNumberOfPeopleServedPerMember) {
		PediatricCancerNumberOfPeopleServedPerMember = pediatricCancerNumberOfPeopleServedPerMember;
	}
	public String getHungerCountCampaignNumberOfPeopleServedPerMember() {
		return HungerCountCampaignNumberOfPeopleServedPerMember;
	}
	public void setHungerCountCampaignNumberOfPeopleServedPerMember(
			String hungerCountCampaignNumberOfPeopleServedPerMember) {
		HungerCountCampaignNumberOfPeopleServedPerMember = hungerCountCampaignNumberOfPeopleServedPerMember;
	}
	public String getVisionCountCampaignNumberOfPeopleServedPerMember() {
		return VisionCountCampaignNumberOfPeopleServedPerMember;
	}
	public void setVisionCountCampaignNumberOfPeopleServedPerMember(
			String visionCountCampaignNumberOfPeopleServedPerMember) {
		VisionCountCampaignNumberOfPeopleServedPerMember = visionCountCampaignNumberOfPeopleServedPerMember;
	}
	public String getNonCampaignNumberOfPeopleServedPerMember() {
		return NonCampaignNumberOfPeopleServedPerMember;
	}
	public void setNonCampaignNumberOfPeopleServedPerMember(String nonCampaignNumberOfPeopleServedPerMember) {
		NonCampaignNumberOfPeopleServedPerMember = nonCampaignNumberOfPeopleServedPerMember;
	}
	public String getCompanyMembership() {
		return CompanyMembership;
	}
	public void setCompanyMembership(String companyMembership) {
		CompanyMembership = companyMembership;
	}
	public String getFundsDonated() {
		return FundsDonated;
	}
	public void setFundsDonated(String fundsDonated) {
		FundsDonated = fundsDonated;
	}
	public String getVisionFundsDonated() {
		return VisionFundsDonated;
	}
	public void setVisionFundsDonated(String visionFundsDonated) {
		VisionFundsDonated = visionFundsDonated;
	}
	public String getHungerFundsDonated() {
		return HungerFundsDonated;
	}
	public void setHungerFundsDonated(String hungerFundsDonated) {
		HungerFundsDonated = hungerFundsDonated;
	}
	public String getEnvironmentFundsDonated() {
		return EnvironmentFundsDonated;
	}
	public void setEnvironmentFundsDonated(String environmentFundsDonated) {
		EnvironmentFundsDonated = environmentFundsDonated;
	}
	public String getDiabetesFundsDonated() {
		return DiabetesFundsDonated;
	}
	public void setDiabetesFundsDonated(String diabetesFundsDonated) {
		DiabetesFundsDonated = diabetesFundsDonated;
	}
	public String getPediatricCancerFundsDonated() {
		return PediatricCancerFundsDonated;
	}
	public void setPediatricCancerFundsDonated(String pediatricCancerFundsDonated) {
		PediatricCancerFundsDonated = pediatricCancerFundsDonated;
	}
	public String getOverallFundsDonated() {
		return OverallFundsDonated;
	}
	public void setOverallFundsDonated(String overallFundsDonated) {
		OverallFundsDonated = overallFundsDonated;
	}
	public String getVisionFundsRaised() {
		return VisionFundsRaised;
	}
	public void setVisionFundsRaised(String visionFundsRaised) {
		VisionFundsRaised = visionFundsRaised;
	}
	public String getHungerFundsRaised() {
		return HungerFundsRaised;
	}
	public void setHungerFundsRaised(String hungerFundsRaised) {
		HungerFundsRaised = hungerFundsRaised;
	}
	public String getEnvironmentFundsRaised() {
		return EnvironmentFundsRaised;
	}
	public void setEnvironmentFundsRaised(String environmentFundsRaised) {
		EnvironmentFundsRaised = environmentFundsRaised;
	}
	public String getDiabetesFundsRaised() {
		return DiabetesFundsRaised;
	}
	public void setDiabetesFundsRaised(String diabetesFundsRaised) {
		DiabetesFundsRaised = diabetesFundsRaised;
	}
	public String getPediatricCancerFundsRaised() {
		return PediatricCancerFundsRaised;
	}
	public void setPediatricCancerFundsRaised(String pediatricCancerFundsRaised) {
		PediatricCancerFundsRaised = pediatricCancerFundsRaised;
	}
	public String getOverallFundsRaised() {
		return OverallFundsRaised;
	}
	public void setOverallFundsRaised(String overallFundsRaised) {
		OverallFundsRaised = overallFundsRaised;
	}
	public String getNonCampaignFundsDonated() {
		return NonCampaignFundsDonated;
	}
	public void setNonCampaignFundsDonated(String nonCampaignFundsDonated) {
		NonCampaignFundsDonated = nonCampaignFundsDonated;
	}
	public String getNonCampaignFundsRaised() {
		return NonCampaignFundsRaised;
	}
	public void setNonCampaignFundsRaised(String nonCampaignFundsRaised) {
		NonCampaignFundsRaised = nonCampaignFundsRaised;
	}
	public ServiceData()
	{
		
	}
	public ServiceData(int id, String totalRowCount, String visionCount, String hungerCount, String environmentCount,
			String diabetesCount, String pediatricCancerActivityCount, String pediatricCancerNumberOfPeopleServed,
			String overallActivityCount, String overallNumberOfPeopleServed,
			String visionCountCampaignNumberOfPeopleServed, String hungerCountCampaignNumberOfPeopleServed,
			String environmentCountCampaignNumberOfPeopleServed, String diabetesCountCampaignNumberOfPeopleServed,
			String nonCampaignActivityCount, String nonCampaignNumberOfPeopleServed, String companyId,
			String companyName, String overallVolunteerHours, String diabetesVolunteerHours,
			String environmentVolunteerHours, String pediatricCancerVolunteerHours, String hungerVolunteerHours,
			String visionVolunteerHours, String nonCampaignVolunteerHours, String overallNumberOfPeopleServedPerMember,
			String diabetesCountCampaignNumberOfPeopleServedPerMember,
			String environmentCountCampaignNumberOfPeopleServedPerMember,
			String pediatricCancerNumberOfPeopleServedPerMember,
			String hungerCountCampaignNumberOfPeopleServedPerMember,
			String visionCountCampaignNumberOfPeopleServedPerMember, String nonCampaignNumberOfPeopleServedPerMember,
			String companyMembership, String fundsDonated, String visionFundsDonated, String hungerFundsDonated,
			String environmentFundsDonated, String diabetesFundsDonated, String pediatricCancerFundsDonated,
			String overallFundsDonated, String visionFundsRaised, String hungerFundsRaised,
			String environmentFundsRaised, String diabetesFundsRaised, String pediatricCancerFundsRaised,
			String overallFundsRaised, String nonCampaignFundsDonated, String nonCampaignFundsRaised) {
		super();
		this.id = id;
		TotalRowCount = totalRowCount;
		VisionCount = visionCount;
		HungerCount = hungerCount;
		EnvironmentCount = environmentCount;
		DiabetesCount = diabetesCount;
		PediatricCancerActivityCount = pediatricCancerActivityCount;
		PediatricCancerNumberOfPeopleServed = pediatricCancerNumberOfPeopleServed;
		OverallActivityCount = overallActivityCount;
		OverallNumberOfPeopleServed = overallNumberOfPeopleServed;
		VisionCountCampaignNumberOfPeopleServed = visionCountCampaignNumberOfPeopleServed;
		HungerCountCampaignNumberOfPeopleServed = hungerCountCampaignNumberOfPeopleServed;
		EnvironmentCountCampaignNumberOfPeopleServed = environmentCountCampaignNumberOfPeopleServed;
		DiabetesCountCampaignNumberOfPeopleServed = diabetesCountCampaignNumberOfPeopleServed;
		NonCampaignActivityCount = nonCampaignActivityCount;
		NonCampaignNumberOfPeopleServed = nonCampaignNumberOfPeopleServed;
		CompanyId = companyId;
		CompanyName = companyName;
		OverallVolunteerHours = overallVolunteerHours;
		DiabetesVolunteerHours = diabetesVolunteerHours;
		EnvironmentVolunteerHours = environmentVolunteerHours;
		PediatricCancerVolunteerHours = pediatricCancerVolunteerHours;
		HungerVolunteerHours = hungerVolunteerHours;
		VisionVolunteerHours = visionVolunteerHours;
		NonCampaignVolunteerHours = nonCampaignVolunteerHours;
		OverallNumberOfPeopleServedPerMember = overallNumberOfPeopleServedPerMember;
		DiabetesCountCampaignNumberOfPeopleServedPerMember = diabetesCountCampaignNumberOfPeopleServedPerMember;
		EnvironmentCountCampaignNumberOfPeopleServedPerMember = environmentCountCampaignNumberOfPeopleServedPerMember;
		PediatricCancerNumberOfPeopleServedPerMember = pediatricCancerNumberOfPeopleServedPerMember;
		HungerCountCampaignNumberOfPeopleServedPerMember = hungerCountCampaignNumberOfPeopleServedPerMember;
		VisionCountCampaignNumberOfPeopleServedPerMember = visionCountCampaignNumberOfPeopleServedPerMember;
		NonCampaignNumberOfPeopleServedPerMember = nonCampaignNumberOfPeopleServedPerMember;
		CompanyMembership = companyMembership;
		FundsDonated = fundsDonated;
		VisionFundsDonated = visionFundsDonated;
		HungerFundsDonated = hungerFundsDonated;
		EnvironmentFundsDonated = environmentFundsDonated;
		DiabetesFundsDonated = diabetesFundsDonated;
		PediatricCancerFundsDonated = pediatricCancerFundsDonated;
		OverallFundsDonated = overallFundsDonated;
		VisionFundsRaised = visionFundsRaised;
		HungerFundsRaised = hungerFundsRaised;
		EnvironmentFundsRaised = environmentFundsRaised;
		DiabetesFundsRaised = diabetesFundsRaised;
		PediatricCancerFundsRaised = pediatricCancerFundsRaised;
		OverallFundsRaised = overallFundsRaised;
		NonCampaignFundsDonated = nonCampaignFundsDonated;
		NonCampaignFundsRaised = nonCampaignFundsRaised;
	}
	@Override
	public String toString() {
		return "ServiceData [id=" + id + ", TotalRowCount=" + TotalRowCount + ", VisionCount=" + VisionCount
				+ ", HungerCount=" + HungerCount + ", EnvironmentCount=" + EnvironmentCount + ", DiabetesCount="
				+ DiabetesCount + ", PediatricCancerActivityCount=" + PediatricCancerActivityCount
				+ ", PediatricCancerNumberOfPeopleServed=" + PediatricCancerNumberOfPeopleServed
				+ ", OverallActivityCount=" + OverallActivityCount + ", OverallNumberOfPeopleServed="
				+ OverallNumberOfPeopleServed + ", VisionCountCampaignNumberOfPeopleServed="
				+ VisionCountCampaignNumberOfPeopleServed + ", HungerCountCampaignNumberOfPeopleServed="
				+ HungerCountCampaignNumberOfPeopleServed + ", EnvironmentCountCampaignNumberOfPeopleServed="
				+ EnvironmentCountCampaignNumberOfPeopleServed + ", DiabetesCountCampaignNumberOfPeopleServed="
				+ DiabetesCountCampaignNumberOfPeopleServed + ", NonCampaignActivityCount=" + NonCampaignActivityCount
				+ ", NonCampaignNumberOfPeopleServed=" + NonCampaignNumberOfPeopleServed + ", CompanyId=" + CompanyId
				+ ", CompanyName=" + CompanyName + ", OverallVolunteerHours=" + OverallVolunteerHours
				+ ", DiabetesVolunteerHours=" + DiabetesVolunteerHours + ", EnvironmentVolunteerHours="
				+ EnvironmentVolunteerHours + ", PediatricCancerVolunteerHours=" + PediatricCancerVolunteerHours
				+ ", HungerVolunteerHours=" + HungerVolunteerHours + ", VisionVolunteerHours=" + VisionVolunteerHours
				+ ", NonCampaignVolunteerHours=" + NonCampaignVolunteerHours + ", OverallNumberOfPeopleServedPerMember="
				+ OverallNumberOfPeopleServedPerMember + ", DiabetesCountCampaignNumberOfPeopleServedPerMember="
				+ DiabetesCountCampaignNumberOfPeopleServedPerMember
				+ ", EnvironmentCountCampaignNumberOfPeopleServedPerMember="
				+ EnvironmentCountCampaignNumberOfPeopleServedPerMember
				+ ", PediatricCancerNumberOfPeopleServedPerMember=" + PediatricCancerNumberOfPeopleServedPerMember
				+ ", HungerCountCampaignNumberOfPeopleServedPerMember="
				+ HungerCountCampaignNumberOfPeopleServedPerMember
				+ ", VisionCountCampaignNumberOfPeopleServedPerMember="
				+ VisionCountCampaignNumberOfPeopleServedPerMember + ", NonCampaignNumberOfPeopleServedPerMember="
				+ NonCampaignNumberOfPeopleServedPerMember + ", CompanyMembership=" + CompanyMembership
				+ ", FundsDonated=" + FundsDonated + ", VisionFundsDonated=" + VisionFundsDonated
				+ ", HungerFundsDonated=" + HungerFundsDonated + ", EnvironmentFundsDonated=" + EnvironmentFundsDonated
				+ ", DiabetesFundsDonated=" + DiabetesFundsDonated + ", PediatricCancerFundsDonated="
				+ PediatricCancerFundsDonated + ", OverallFundsDonated=" + OverallFundsDonated + ", VisionFundsRaised="
				+ VisionFundsRaised + ", HungerFundsRaised=" + HungerFundsRaised + ", EnvironmentFundsRaised="
				+ EnvironmentFundsRaised + ", DiabetesFundsRaised=" + DiabetesFundsRaised
				+ ", PediatricCancerFundsRaised=" + PediatricCancerFundsRaised + ", OverallFundsRaised="
				+ OverallFundsRaised + ", NonCampaignFundsDonated=" + NonCampaignFundsDonated
				+ ", NonCampaignFundsRaised=" + NonCampaignFundsRaised + "]";
	}


	
}
