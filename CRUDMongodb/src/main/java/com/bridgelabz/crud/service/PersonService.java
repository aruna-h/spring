package com.bridgelabz.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.crud.model.Person;
import com.bridgelabz.crud.repository.PersonRepository;

/**
 * @author bridgelabz
 *
 */
@Repository
public class PersonService {
	@Autowired
	private PersonRepository personRepository;

	public Person Create(String firstName, String lastName, int age) {
		return personRepository.save(new Person(firstName, lastName, age));
	}

	public List<Person> getAll() {
		return personRepository.findAll();
	}

	public Person getByFirstName(String firstName) {
		return personRepository.findByFirstName(firstName);
	}

	public Person update(String firstName, String lastName, int age) {
		Person p = personRepository.findByFirstName(firstName);
		p.setLastName(lastName);
		p.setAge(age);
		return personRepository.save(p);
	}

	public void deleteAll() {
		personRepository.deleteAll();
	}

	public void delete(String firstName) {
		Person p = personRepository.findByFirstName(firstName);
		personRepository.delete(p);
	}
}
