
package com.bridgelabz.Login.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.Login.model.User;
import com.bridgelabz.Login.service.UserService;
import com.bridgelabz.Login.tokens.TokenGenerator;

/**
 * @author bridgelabz
 *
 */
@RestController
public class UserController {
	@Autowired
	UserService userService;

	TokenGenerator token = new TokenGenerator();

	/**
	 * Method to print hello on "/hello" call
	 * 
	 * @return
	 */
	@RequestMapping("/hello")
	public String printHello() {
		return "Hello";
	}

	/**
	 * Method to login into the application on "/login" url call
	 * 
	 * @param user
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> logIn(@RequestBody User user) {
		System.out.println("userName" + user.getUserName());
		if (userService.validateUser(user) == true) {
			String validToken = token.generator(user);
			System.out.println(validToken + "****************************************");
			token.parseJWT(validToken);
			return new ResponseEntity("Welcome " + user.getUserName() + "Token generated is: " + validToken,
					HttpStatus.OK);
		}
		return new ResponseEntity("User Or Password Incorrect. Therefore no token generated. " + user.getUserName(),
				HttpStatus.CONFLICT);
	}

	/**
	 * Method to register a new user into the application on "/signup" url call"
	 * 
	 * @param user
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<User> signUp(@RequestBody User user) {
		if (userService.checkEmail(user) == true) {
			return new ResponseEntity("User Allready Present " + user.getUserName(), HttpStatus.CONFLICT);
		}
		userService.updateUser(user);
		String validToken = token.generator(user);
		System.out.println(validToken + "****************************************");
		token.parseJWT(validToken);
		return new ResponseEntity(
				"User successfully registered " + user.getUserName() + "Token generated is: " + validToken,
				HttpStatus.OK);
	}
}
