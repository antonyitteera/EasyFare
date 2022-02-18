package com.tus.easyfare.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import com.tus.easyfare.DAO.UserDAO;
import com.tus.easyfare.DTO.UserDTO;
import com.tus.easyfare.entity.SmartCardEntity;
import com.tus.easyfare.entity.UserEntity;
import com.tus.easyfare.repository.CardRepository;
import com.tus.easyfare.repository.UserRepository;

@Service
@Validated
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	CardRepository cardRepository;
	
	
	public UserDTO insertUser(@RequestBody UserDAO user) {
		String ageGroup=FindAgeGroup(user.getDob());
		UserEntity saveUser= new UserEntity();
		saveUser.setFirstName(user.getFirstName());
		saveUser.setSecondName(user.getSecondName());
		saveUser.setDob((java.sql.Date) user.getDob());
		saveUser.setMobNo(user.getMobNo());
		System.out.println("age Group is :"+ageGroup);
		saveUser.setAgeGroup(ageGroup);
		saveUser.setEmailId(user.getEmailId());
		System.out.println("Card Number is: "+user.getCardNumber());
		LocalDate expDateLocal=user.getDateOfReg().toLocalDate().plusYears(2); 
		SmartCardEntity cardEntity = new SmartCardEntity(user.getCardNumber(), user.getDateOfReg(), Date.valueOf(expDateLocal), user.getBalance(), user.getCardStatus());
		saveUser.setSmartCard(cardEntity);
		UserEntity savedUser=userRepo.save(saveUser);
		//cardEntity.setUserEntity(saveUser);
		//cardRepository.save(cardEntity);
		return new UserDTO(saveUser);
	}
	
	private String FindAgeGroup(Date dob) {
		String ageGroup;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String current_date_str=sdf.format(Calendar.getInstance().getTime());
		LocalDate curr_date= LocalDate.parse(current_date_str);
		LocalDate dob_date=dob.toLocalDate();
		Period period= dob_date.until(curr_date);
		int age=period.getYears();
		if(age<=18) {
			ageGroup="STUDENT";
		}else if(age>18 && age<=59) {
			ageGroup="ADULT";
		}else {
			ageGroup="SENIOR";
		}
		return ageGroup;
	}
}