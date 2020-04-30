package com.lionsclub.springboot.thymeleaf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "memberFamily")
public class MemberFamily {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int mFamilyid;
	@Column
	private String houseofHeadMemberID;
	@Column
	private String MemberID;
	@Column
	private String relationship;

	@Column
	private int orderID;
	
	public MemberFamily() {

	}

	public int getmFamilyid() {
		return mFamilyid;
	}

	public void setmFamilyid(int mFamilyid) {
		this.mFamilyid = mFamilyid;
	}

	public String getHouseofHeadMemberID() {
		return houseofHeadMemberID;
	}

	public void setHouseofHeadMemberID(String houseofHeadMemberID) {
		this.houseofHeadMemberID = houseofHeadMemberID;
	}

	public String getMemberID() {
		return MemberID;
	}

	public void setMemberID(String memberID) {
		MemberID = memberID;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	@Override
	public String toString() {
		return "MemberFamily [mFamilyid=" + mFamilyid + ", houseofHeadMemberID=" + houseofHeadMemberID + ", MemberID="
				+ MemberID + ", relationship=" + relationship + ", orderID=" + orderID + "]";
	}

	public MemberFamily(int mFamilyid, String houseofHeadMemberID, String memberID, String relationship, int orderID) {
		super();
		this.mFamilyid = mFamilyid;
		this.houseofHeadMemberID = houseofHeadMemberID;
		MemberID = memberID;
		this.relationship = relationship;
		this.orderID = orderID;
	}

	

}
