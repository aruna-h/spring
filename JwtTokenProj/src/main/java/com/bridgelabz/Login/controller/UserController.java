package com.bridgelabz.Login.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.Login.model.User;
import com.bridgelabz.Login.service.UserService;

/**
 * @author bridgelabz
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	@Autowired
	UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public String regiterUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/get")
	public Optional<User> getUser(HttpServletRequest request) {
		ObjectId userId = (ObjectId) request.getAttribute("name");
		return userService.getUser(userId);
	}
}