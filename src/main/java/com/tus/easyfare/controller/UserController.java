package com.tus.easyfare.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tus.easyfare.DAO.UserDAO;
import com.tus.easyfare.DTO.UserDTO;
import com.tus.easyfare.entity.SmartCardEntity;
import com.tus.easyfare.entity.UserEntity;
import com.tus.easyfare.repository.CardRepository;
import com.tus.easyfare.repository.UserRepository;
import com.tus.easyfare.service.UserService;

@RestController
@Validated
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepo;
	
	// to insert into user table
	@RequestMapping(value = "/user",method = RequestMethod.POST)
	public ResponseEntity<UserDTO> insertUser(@RequestBody @Valid UserDAO user)
	{
		UserDTO userDetails=userService.insertUser(user);
		return new ResponseEntity<UserDTO>(userDetails, HttpStatus.CREATED);
	}
	
	//to fetch all the user
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<UserEntity>> getUserDetails() {
		List<UserEntity> ueList=userRepo.findAll();
		 return new ResponseEntity<List<UserEntity>>(ueList, HttpStatus.OK);
	}
	
	//to fetch the user according to the id
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<UserEntity>> getUserDetailsById(@PathVariable Integer id) {
		Optional<UserEntity> userList=userRepo.findById(id);
		 return new ResponseEntity<Optional<UserEntity>>(userList, HttpStatus.OK);
	}
	//to update the user
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UserDTO> updateUserDetailsById(@PathVariable Integer id,@RequestBody @Valid UserDAO user) {
		Optional<UserEntity> userList=userRepo.findById(id);
		UserDTO userDetails=userService.updateUser(userList,user);
		 return new ResponseEntity<UserDTO>(userDetails, HttpStatus.OK);
	}

	//to delete the user
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserEntity> deleteUserDetailsById(@PathVariable Integer id) {
		Optional<UserEntity> userList=userRepo.findById(id);
		UserEntity existingUser= userList.get();
		userRepo.delete(existingUser);
		return new ResponseEntity<UserEntity>(existingUser, HttpStatus.OK);
	}

	
}
