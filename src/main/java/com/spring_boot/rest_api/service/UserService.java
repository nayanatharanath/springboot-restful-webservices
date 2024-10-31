package com.spring_boot.rest_api.service;

import java.util.List;

import com.spring_boot.rest_api.dto.UserDTO;

public interface UserService {
	
	UserDTO createUser(UserDTO userDTO);
	
	UserDTO getUserById(Long user_id);
	
	List<UserDTO> getAllUsers();
	
	UserDTO updateUser(UserDTO userDTO);
	
	void deleteUser(Long user_id);
}
