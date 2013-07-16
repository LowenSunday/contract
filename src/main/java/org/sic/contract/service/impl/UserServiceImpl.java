package org.sic.contract.service.impl;

import org.apache.log4j.Logger;
import org.sic.contract.entity.Sequence;
import org.sic.contract.entity.User;
import org.sic.contract.exception.SicException;
import org.sic.contract.exception.SicUserException;
import org.sic.contract.persistence.SequenceMapper;
import org.sic.contract.persistence.UserMapper;
import org.sic.contract.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.jdbc.StringUtils;

public class UserServiceImpl implements UserService{
	
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private SequenceMapper sequenceMapper;

	@Override
	public void addUser(User user) throws SicException {
		if(!exists(user.getUserName())){
			try{
				Long id = sequenceMapper.getId("userId");
				user.setId(id);
				userMapper.insert(user);
				
				Sequence sequence = new Sequence();
				sequence.setName("userId");
				sequence.setValue(id + 1);
				sequenceMapper.setId(sequence);
			}catch(Exception e){
				logger.error("�û����ʧ��:\n" + e.getMessage());
				throw new SicUserException(e.getMessage());
			}
		}else{
			logger.error("用户已经存在:\n" + SicUserException.USER_EXIST_EXCEPTION.getMessage());
			throw SicUserException.USER_EXIST_EXCEPTION;
		}
	}

	@Override
	public User findUserByName(String userName){
		if(!StringUtils.isNullOrEmpty(userName)){
			return userMapper.findByName(userName);
		}
		return null;
	}

	@Override
	public void updateUser(User user){
		if(user != null){
			userMapper.update(user);
		}
	}

	@Override
	public void deleteUserById(Long id) {
		if(id != null){
			userMapper.deleteById(id);
		}
	}

	@Override
	public boolean exists(String userName) {
		return userMapper.findByName(userName) != null;
	}

}
