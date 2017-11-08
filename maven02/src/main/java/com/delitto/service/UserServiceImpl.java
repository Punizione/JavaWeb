package com.delitto.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delitto.dao.UserDao;
import com.delitto.domain.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	public User selectUserById(Integer userId) {
		return userDao.selectUserById(userId);
	}
}

