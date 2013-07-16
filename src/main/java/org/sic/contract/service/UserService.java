package org.sic.contract.service;

import org.sic.contract.entity.User;
import org.sic.contract.exception.SicException;

public interface UserService {
	void addUser(User user) throws SicException;
	
	User findUserByName(String userName);
	
	void updateUser(User user);
	
	void deleteUserById(Long id);
	
	boolean exists(String userName);
	
}
