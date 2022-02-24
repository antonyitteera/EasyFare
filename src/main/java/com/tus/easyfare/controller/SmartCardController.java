package com.tus.easyfare.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tus.easyfare.DTO.ResponseDTO;
import com.tus.easyfare.DTO.SmartCardDTO;
import com.tus.easyfare.entity.SmartCardEntity;
import com.tus.easyfare.entity.UserEntity;
import com.tus.easyfare.repository.UserRepository;

@RestController
public class SmartCardController {
	
	@Autowired
	private UserRepository userRepo;

	//to get smartcard details using userid
	@RequestMapping(value = "/carddetail/{userid}", method = RequestMethod.GET)
	public ResponseEntity<SmartCardEntity> getCardDetails(@PathVariable Integer userid) {
		UserEntity userEntity=userRepo.findById(userid).get();
		SmartCardEntity smartCardDetails=userEntity.getSmartCard();
		 return new ResponseEntity<SmartCardEntity>(smartCardDetails, HttpStatus.OK);
	}
	
	//to update the smartcard details
	@RequestMapping(value = "/carddetail/{userid}", method = RequestMethod.PUT)
	public ResponseEntity<UserEntity> updateCardDetails(@PathVariable Integer userid,@RequestBody @Valid SmartCardDTO cardDetails) {
		UserEntity userEntity=userRepo.findById(userid).get();
		SmartCardEntity smartcardDetails= SmartCardEntity.builder().cardId(userEntity.getSmartCard().getCardId()).cardNum(cardDetails.getCardNum()).cardStatus(cardDetails.getCardStatus()).dateOfReg(cardDetails.getDateOfReg()).dateOfExp(cardDetails.getDateOfExp()).balance(cardDetails.getBalance()).build();
		userEntity.setSmartCard(smartcardDetails);
		UserEntity resp=userRepo.save(userEntity);
		return new ResponseEntity<UserEntity>(resp, HttpStatus.OK);
	}
	
	//to topup the user smartcard
	@RequestMapping(value = "/topup/{userid}", method = RequestMethod.PUT)
	public ResponseEntity<ResponseDTO> updateCardDetails(@PathVariable Integer userid,@RequestParam Integer amount) {
		UserEntity userEntity=userRepo.findById(userid).get();
		long currentBalance=userEntity.getSmartCard().getBalance();
		long newBalance=currentBalance+amount;
		userEntity.getSmartCard().setBalance(newBalance);
		UserEntity resp=userRepo.save(userEntity);
		String msg="User "+resp.getFirstName()+ " with user id "+userid+" successfully recharged with "+amount+".Current available balance:"+ resp.getSmartCard().getBalance();
		ResponseDTO respObj= new ResponseDTO(msg);
		return new ResponseEntity<ResponseDTO>(respObj, HttpStatus.OK);
	}
}
