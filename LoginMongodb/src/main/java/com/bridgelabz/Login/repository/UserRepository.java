package com.bridgelabz.Login.repository;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.bridgelabz.Login.model.User;

/**
 * @author bridgelabz
 *
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

	public Optional<User> getByEmail(String email);
	public Optional<User> getByUserName(String userName);
}
