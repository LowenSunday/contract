package org.sic.contract.service;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.sic.contract.ContractBaseTest;
import org.sic.contract.entity.User;
import org.sic.contract.exception.SicException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = {"classpath:contract-spring/contract-mapper.xml",
									"classpath:contract-spring/contract-service.xml",})
public class UserServiceTest extends ContractBaseTest{
	private static Logger logger = Logger.getLogger(UserServiceTest.class);
	@Autowired
	private UserService userSerivce;
	
	@Test
	public void testAddUser(){
		User user = new User();
		user.setUserName("Test");
		user.setPassword("12345678");
		try {
			User old = userSerivce.findUserByName(user.getUserName());
			if(old != null){
				userSerivce.deleteUserById(old.getId());
			}
			userSerivce.addUser(user);
			logger.info(user.getId());
		} catch (SicException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
