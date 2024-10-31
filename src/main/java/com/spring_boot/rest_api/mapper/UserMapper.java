package com.spring_boot.rest_api.mapper;

import com.spring_boot.rest_api.dto.UserDTO;
import com.spring_boot.rest_api.entity.User;

public class UserMapper {

	// convert JPA entity to USerDTO object
	public static UserDTO mapToUserDTO(User user) {
		UserDTO userDTO = new UserDTO(user.getUser_id(), user.getUser_first_name(), user.getUser_last_name(),
				user.getUser_email());
		return userDTO;
	}

	// Convert DTO object into JPA entity
	public static User mapToUserJPAEntity(UserDTO userDTO) {
		User user = new User(userDTO.getUser_id(), userDTO.getUser_first_name(), userDTO.getUser_last_name(),
				userDTO.getUser_email());
		return user;
	}

}
