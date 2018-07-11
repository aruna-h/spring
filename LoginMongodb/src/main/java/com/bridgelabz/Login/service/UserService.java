package com.bridgelabz.Login.service;

import java.util.Optional;

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
	// @Autowired
	private UserRepository userRepository;
	private TokenService tokenService;

	@Autowired
	UserService(UserRepository userRepository, TokenService tokenService) {
		this.userRepository = userRepository;
		this.tokenService = tokenService;
	}

	public boolean verifyUser(User user) {
		System.out.println("Verify user");
		String userName = user.getUserName();
		if (userRepository.getByEmail(userName).isPresent()) {
			System.out.println("Verify user email");
			Optional<User> user1 = userRepository.getByEmail(userName);
			if (user1.get().getPassword().equals(user.getPassword()))
				System.out.println("Verify user password");
			return true;
		}
		return false;

	}

	public boolean verifyEmail(User user) {
		System.out.println("Verify email");
		System.out.println(user.getEmail());
		if (userRepository.getByEmail(user.getEmail()).isPresent()) {
			System.out.println("Verify email true");
			return true;
		}
		System.out.println("Verify email false");
		return false;
	}

	public Optional<User> getUser(String userId) {
		return userRepository.findById(userId);
	}

	public String saveUser(User user) {
		System.out.println("saveUser");
		User savedUser = userRepository.save(user);
		System.out.println("saveUser successfull");
		return tokenService.createToken(savedUser.getId());
	}

}
