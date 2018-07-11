package com.bridgelabz.Login.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.Login.model.User;

/**
 * @author bridgelabz
 *
 */
@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
}