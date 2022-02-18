package com.tus.easyfare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tus.easyfare.entity.SmartCardEntity;
import com.tus.easyfare.repository.CardRepository;

public class SmartCardController {
	
	@Autowired
	private CardRepository cardRepo;

	@RequestMapping(value = "/cards", method = RequestMethod.GET)
	public ResponseEntity<List<SmartCardEntity>> getCardDetails() {
		List<SmartCardEntity> smList=cardRepo.findAll();
		 return new ResponseEntity<List<SmartCardEntity>>(smList, HttpStatus.OK);
	}
}
