package com.lionsclub.springboot.thymeleaf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "serviceDataNew")
public class ServiceDataNew {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column
	private String name;
	@Column
	private String clubID;
	@Column
	private String clubType;
	@Column
	private String clubSpecialty;
	@Column
	private String activityType;
	@Column
	private double numberOfActivities;
	@Column
	private double peopleServed;
	@Column
	private double totalVolunteers;
	@Column
	private double totalVolunteerHours;
	@Column
	private double fundsDonatedUSD;
	@Column
	private double fundsRaisedUSD;
	

	public ServiceDataNew() {

	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClubID() {
		return clubID;
	}

	public void setClubID(String clubID) {
		this.clubID = clubID;
	}

	public String getClubType() {
		return clubType;
	}

	public void setClubType(String clubType) {
		this.clubType = clubType;
	}

	public String getClubSpecialty() {
		return clubSpecialty;
	}

	public void setClubSpecialty(String clubSpecialty) {
		this.clubSpecialty = clubSpecialty;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public double getNumberOfActivities() {
		return numberOfActivities;
	}

	public void setNumberOfActivities(double numberOfActivities) {
		this.numberOfActivities = numberOfActivities;
	}

	public double getPeopleServed() {
		return peopleServed;
	}

	public void setPeopleServed(double peopleServed) {
		this.peopleServed = peopleServed;
	}

	public double getTotalVolunteers() {
		return totalVolunteers;
	}

	public void setTotalVolunteers(double totalVolunteers) {
		this.totalVolunteers = totalVolunteers;
	}

	public double getTotalVolunteerHours() {
		return totalVolunteerHours;
	}

	public void setTotalVolunteerHours(double totalVolunteerHours) {
		this.totalVolunteerHours = totalVolunteerHours;
	}

	public double getFundsDonatedUSD() {
		return fundsDonatedUSD;
	}

	public void setFundsDonatedUSD(double fundsDonatedUSD) {
		this.fundsDonatedUSD = fundsDonatedUSD;
	}

	public double getFundsRaisedUSD() {
		return fundsRaisedUSD;
	}

	public void setFundsRaisedUSD(double fundsRaisedUSD) {
		this.fundsRaisedUSD = fundsRaisedUSD;
	}

	@Override
	public String toString() {
		return "ServiceDataNew [id=" + id + ", name=" + name + ", clubID=" + clubID + ", clubType=" + clubType
				+ ", clubSpecialty=" + clubSpecialty + ", activityType=" + activityType + ", numberOfActivities="
				+ numberOfActivities + ", peopleServed=" + peopleServed + ", totalVolunteers=" + totalVolunteers
				+ ", totalVolunteerHours=" + totalVolunteerHours + ", fundsDonatedUSD=" + fundsDonatedUSD
				+ ", fundsRaisedUSD=" + fundsRaisedUSD + "]";
	}

	public ServiceDataNew(int id, String name, String clubID, String clubType, String clubSpecialty,
			String activityType, double numberOfActivities, double peopleServed, double totalVolunteers,
			double totalVolunteerHours, double fundsDonatedUSD, double fundsRaisedUSD) {
		super();
		this.id = id;
		this.name = name;
		this.clubID = clubID;
		this.clubType = clubType;
		this.clubSpecialty = clubSpecialty;
		this.activityType = activityType;
		this.numberOfActivities = numberOfActivities;
		this.peopleServed = peopleServed;
		this.totalVolunteers = totalVolunteers;
		this.totalVolunteerHours = totalVolunteerHours;
		this.fundsDonatedUSD = fundsDonatedUSD;
		this.fundsRaisedUSD = fundsRaisedUSD;
		
	}

	

}
