package com.spring_boot.rest_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring_boot.rest_api.entity.User;
import com.spring_boot.rest_api.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

	private UserRepository userRepo;
	
	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User getUserById(Long user_id) {
		Optional<User> getUserById = userRepo.findById(user_id);
		return getUserById.get();
	}

	@Override
	public List<User> getAllUsers() {
		List<User> getAllUsers =  userRepo.findAll();
		return getAllUsers;
	}

	@Override
	public User updateUser(User user) {
		User existingUser = userRepo.findById(user.getUser_id()).get();
		existingUser.setUser_first_name(user.getUser_first_name());
		existingUser.setUser_last_name(user.getUser_last_name());
		existingUser.setUser_email(user.getUser_email());
		User updatedUser = userRepo.save(existingUser);
		return updatedUser;
	}

	@Override
	public void deleteUser(Long user_id) {
		userRepo.deleteById(user_id);
	}

}
