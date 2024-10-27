package com.spring_boot.rest_api.service;

import java.util.List;

import com.spring_boot.rest_api.entity.User;

public interface UserService {
	
	User createUser(User user);
	
	User getUserById(Long user_id);
	
	List<User> getAllUsers();
	
	User updateUser(User user);
	
	void deleteUser(Long user_id);
}
