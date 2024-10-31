package com.spring_boot.rest_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring_boot.rest_api.dto.UserDTO;
import com.spring_boot.rest_api.entity.User;
import com.spring_boot.rest_api.exception.ResourceNotFoundException;
import com.spring_boot.rest_api.mapper.UserMapper;
import com.spring_boot.rest_api.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		// convert UserDTO into User JPA Entity
		User user = UserMapper.mapToUserJPAEntity(userDTO);

		User savedUser = userRepo.save(user);

		// convert JPA entity to userDTO
		UserDTO savedUserDTO = UserMapper.mapToUserDTO(savedUser);

		return savedUserDTO;
	}

	@Override
	public UserDTO getUserById(Long user_id) {
		User getUserById = userRepo.findById(user_id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", user_id));
		return UserMapper.mapToUserDTO(getUserById);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> getAllUsers = userRepo.findAll();
		return getAllUsers.stream().map(UserMapper::mapToUserDTO).collect(Collectors.toList());
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO) {
		User existingUser = userRepo.findById(userDTO.getUser_id()).orElseThrow(
				() -> new ResourceNotFoundException("User", "id", userDTO.getUser_id())
				);
		existingUser.setUser_first_name(userDTO.getUser_first_name());
		existingUser.setUser_last_name(userDTO.getUser_last_name());
		existingUser.setUser_email(userDTO.getUser_email());
		User updatedUser = userRepo.save(existingUser);
		return UserMapper.mapToUserDTO(updatedUser);
	}

	@Override
	public void deleteUser(Long user_id) {
		User existingUser = userRepo.findById(user_id).orElseThrow(
				() -> new ResourceNotFoundException("User", "id", user_id)
				);
		userRepo.deleteById(user_id);
	}

}
