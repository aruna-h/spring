package com.bridgelabz.Login.service;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.Login.model.User;
import com.bridgelabz.Login.repository.UserRepository;

/**
 * @author bridgelabz
 *
 */
@Service
public class UserService {

	private UserRepository userRepository;
	private TokenService tokenService;

	@Autowired
	UserService(UserRepository userRepository, TokenService tokenService) {
		this.userRepository = userRepository;
		this.tokenService = tokenService;
	}

	public Optional<User> getUser(ObjectId userId) {
		return userRepository.findById(userId);
	}

	public String saveUser(User user) {
		User savedUser = userRepository.save(user);
		return tokenService.createToken(savedUser.getId());
	}
}