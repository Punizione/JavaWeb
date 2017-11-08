package com.delitto.service;

import com.delitto.domain.User;


public interface UserService {
	User selectUserById(Integer userId);
}
