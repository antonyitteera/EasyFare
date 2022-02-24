package com.tus.easyfare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tus.easyfare.DAO.TapDAO;
import com.tus.easyfare.service.TapService;

@RestController
public class TapController {
	@Autowired
	TapService tapService;

	@RequestMapping(value = "/tap",method = RequestMethod.POST)
	public ResponseEntity<String> tapCard(@RequestBody TapDAO tappedUser) {
		Integer userId=tappedUser.getUserId();
		System.out.println("UserId:"+userId);
		String resp;
		if(tapService.validateUserAndBalance(userId)) {
			System.out.println("Validation successful");
			resp= tapService.tapUser(tappedUser);
		}else {
			resp="User not authenticated to use bus service";
		}
		return new ResponseEntity<String>(resp, HttpStatus.OK);
	}
}
