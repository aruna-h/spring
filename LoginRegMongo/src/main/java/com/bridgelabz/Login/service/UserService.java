
package com.bridgelabz.Login.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.Login.model.User;
import com.bridgelabz.Login.repository.Repository;

/**
 * @author bridgelabz
 *
 */
@Service
public class UserService {
	@Autowired
	Repository repository;

	/**
	 * Method to validate the user
	 * 
	 * @param user
	 * @return
	 */
	public boolean validateUser(User user) {
		String email = user.getEmail();
		String password = user.getPassword();
		System.out.println("Validating user");
		if (repository.getByEmail(email).isPresent()) {
			System.out.println("Validating email");
			Optional<User> user1 = repository.getByEmail(email);
			if (password.equals(user1.get().getPassword())) {
				System.out.println("Validating password");
				return true;
			}
		}
		return false;
	}

	/**
	 * Method to check the email if present or not in the database
	 * 
	 * @param user
	 * @return
	 */
	public boolean checkEmail(User user) {
		String email = user.getEmail();
		System.out.println("Check email method");
		if (repository.getByEmail(email).isPresent()) {
			System.out.println("checking email");
			return true;
		}
		return false;
	}

	/**
	 * Method to update the user in the database
	 * 
	 * @param user
	 */
	public void updateUser(User user) {
		System.out.println("Update user");
		repository.save(user);
		System.out.println("Successfulle updated");
	}

}
