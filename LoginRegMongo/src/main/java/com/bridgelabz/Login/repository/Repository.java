package com.bridgelabz.Login.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bridgelabz.Login.model.User;

/**
 * @author bridgelabz
 *
 */
@org.springframework.stereotype.Repository
public interface Repository extends MongoRepository<User, String> {
	public Optional<User> getByEmail(String email);

}
