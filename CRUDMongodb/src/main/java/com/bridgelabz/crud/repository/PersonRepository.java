package com.bridgelabz.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.bridgelabz.crud.model.Person;

/**
 * @author bridgelabz
 *
 */
@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
	public Person findByFirstName(String firstName);
	// public List<Person>findbyAge(int age);

}
