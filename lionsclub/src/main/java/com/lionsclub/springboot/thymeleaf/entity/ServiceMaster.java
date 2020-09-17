package com.lionsclub.springboot.thymeleaf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "serviceMaster")
public class ServiceMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column
	private String activityName;

	@Column
	private String activityPoint;

	@Column
	private String lionshours;

	@Column
	private String beneficiary;

	@Column
	private String volunteers;

	@Column
	private String donate;

	public ServiceMaster() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityPoint() {
		return activityPoint;
	}

	public void setActivityPoint(String activityPoint) {
		this.activityPoint = activityPoint;
	}

	public String getLionshours() {
		return lionshours;
	}

	public void setLionshours(String lionshours) {
		this.lionshours = lionshours;
	}

	public String getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(String beneficiary) {
		this.beneficiary = beneficiary;
	}

	public String getVolunteers() {
		return volunteers;
	}

	public void setVolunteers(String volunteers) {
		this.volunteers = volunteers;
	}

	public String getDonate() {
		return donate;
	}

	public void setDonate(String donate) {
		this.donate = donate;
	}

	@Override
	public String toString() {
		return "ServiceMaster [id=" + id + ", activityName=" + activityName + ", activityPoint=" + activityPoint
				+ ", lionshours=" + lionshours + ", beneficiary=" + beneficiary + ", volunteers=" + volunteers
				+ ", donate=" + donate + "]";
	}

	public ServiceMaster(int id, String activityName, String activityPoint, String lionshours, String beneficiary,
			String volunteers, String donate) {
		super();
		this.id = id;
		this.activityName = activityName;
		this.activityPoint = activityPoint;
		this.lionshours = lionshours;
		this.beneficiary = beneficiary;
		this.volunteers = volunteers;
		this.donate = donate;
	}

}
