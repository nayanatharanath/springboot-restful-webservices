package com.spring_boot.rest_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot.rest_api.entity.User;
import com.spring_boot.rest_api.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
	
	private UserService userServ;
	
	// build create user rest API
	@PostMapping("/add")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User savedUser = userServ.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	// build get user rest API
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long user_id){
		User user = userServ.getUserById(user_id);
		return new ResponseEntity<>(user, HttpStatus.FOUND);
	}
	
	// build get all users REST API
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUsers = userServ.getAllUsers();
		return new ResponseEntity<>(allUsers, HttpStatus.FOUND);
	}
	
	// build update users REST API
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long user_id, @RequestBody User user){
		user.setUser_id(user_id);
		User updatedUser = userServ.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	// build delete users REST API
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long user_id){
		userServ.deleteUser(user_id);
		return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
	}
	
}
