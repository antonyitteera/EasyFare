package com.tus.easyfare.DTO;

import java.util.Date;

import com.tus.easyfare.entity.UserEntity;

public class UserDTO {

	private int userid;
	private String firstName;
	private String secondName;
	private Date dob;
	private String mobNo;
	private String ageGroup;
	private String emailId;
	
	public int getUserid() {
		return userid;
	}
	
	public UserDTO() {
		
	}
	
	
	public UserDTO(UserEntity user) {
		super();
		this.userid = user.getUserid();
		this.firstName = user.getFirstName();
		this.secondName = user.getSecondName();
		this.dob = user.getDob();
		this.mobNo = user.getMobNo();
		this.ageGroup = user.getAgeGroup();
		this.emailId=user.getEmailId();
	}

	
	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}
	
	
	
}
