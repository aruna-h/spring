package com.bridgelabz.model;

/**
 * @author bridgelabz
 *
 */
public class User {
	String UserName;
	String Password;
	String Email;
	String FirstName;
	String LastName;
	String MobNumber;

	public User() {

	}

	public User(String userName, String password, String email, String firstName, String lastName, String mobNumber) {
		this.UserName = userName;
		this.Password = password;
		this.Email = email;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.MobNumber = mobNumber;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		this.UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		this.LastName = lastName;
	}

	public String getMobNumber() {
		return MobNumber;
	}

	public void setMobNumber(String mobNumber) {
		this.MobNumber = mobNumber;
	}
}
