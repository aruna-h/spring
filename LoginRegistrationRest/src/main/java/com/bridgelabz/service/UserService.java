package com.bridgelabz.service;

import java.sql.SQLException;

import com.bridgelabz.model.User;

/**
 * @author bridgelabz
 *
 */
public interface UserService {

	public int verifyUser(User user) throws ClassNotFoundException, SQLException;

	public boolean verifyEmail(User user) throws ClassNotFoundException, SQLException;

	public void saveUser(User user) throws ClassNotFoundException, SQLException;

}
