package com.tus.easyfare.DAO;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserDAO {
	
	@NotBlank(message = "firstname is mandatory")
	private String firstName;
	private String secondName;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dob;
	@Size(max = 10,min = 10, message = "mobile number must be 10 digits")
	private String mobNo;
	@Email(message = "not a valid email id")
	private String emailId;
	@Size(min = 14,max = 14,message = "not a valid card number")
	private String cardNumber;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dateOfReg;
	private int balance;
	private String cardStatus;
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Date getDateOfReg() {
		return dateOfReg;
	}
	public void setDateOfReg(Date dateOfReg) {
		this.dateOfReg = dateOfReg;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
}
