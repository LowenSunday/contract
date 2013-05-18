package org.sic.contract.persistence;

import org.sic.contract.entity.User;

public interface UserMapper {
	
	User findById(String userName);
	
	User findByName(String userName);
	
	void insert(User user);
	
	void update(User user);
	
	void deleteById(Long id);
}
