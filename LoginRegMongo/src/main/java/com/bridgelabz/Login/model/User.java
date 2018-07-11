
package com.bridgelabz.Login.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author bridgelabz
 *
 */
@Document
public class User {
	@Id
	private String id;
	private String userName;
	private String email;
	private String password;

	/**
	 * Constructor
	 */
	public User() {
		super();
	}

	/**
	 * Method to get the id of userid
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Method to set the id of the user
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Method to get the username.
	 * 
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Method to set the userName
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Method to get the email from the user
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Method to set the email
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Method to get the password of the user
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Method to set the password of the user
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
