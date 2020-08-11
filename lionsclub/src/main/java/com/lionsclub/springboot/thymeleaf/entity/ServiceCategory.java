package com.lionsclub.springboot.thymeleaf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "serviceCategory")
public class ServiceCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	int id;
	@Column
	String ClubID;
	@Column
	String ClubCatogery;
	
	public ServiceCategory() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClubID() {
		return ClubID;
	}

	public void setClubID(String clubID) {
		ClubID = clubID;
	}

	public String getClubCatogery() {
		return ClubCatogery;
	}

	public void setClubCatogery(String clubCatogery) {
		ClubCatogery = clubCatogery;
	}

	@Override
	public String toString() {
		return "ServiceCatogery [id=" + id + ", ClubID=" + ClubID + ", ClubCatogery=" + ClubCatogery + "]";
	}

	public ServiceCategory(int id, String clubID, String clubCatogery) {
		super();
		this.id = id;
		ClubID = clubID;
		ClubCatogery = clubCatogery;
	}
	
	
}
