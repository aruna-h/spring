package com.bridgelabz.Login.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.Login.model.User;
import com.bridgelabz.Login.service.UserService;
import com.bridgelabz.Login.util.CustomErrorType;

/**
 * @author bridgelabz
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> loginUser(@RequestBody User user) {

		if (!userService.verifyUser(user)) {
			return new ResponseEntity("Welcome " + user.getUserName(), HttpStatus.OK);
		}

		return new ResponseEntity(new CustomErrorType("Username doesnot not exist"), HttpStatus.CONFLICT);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		System.out.println(user.getEmail());
		System.out.println(user.getMobNumber());
		System.out.println(user.getPassword());
		if (!userService.verifyEmail(user)) {
			// userService.saveUser(user);
			return new ResponseEntity(userService.saveUser(user) + user.toString() + "User successfully registered",
					HttpStatus.OK);
		}
		return new ResponseEntity(new CustomErrorType("Email-id already exist!!"), HttpStatus.CONFLICT);
	}

	@RequestMapping("/hello")
	public String printHello() {
		return "Hello";
	}
}
