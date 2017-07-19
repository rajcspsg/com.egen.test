package com.egen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.egen.dao.UserRepository;
import com.egen.entities.User;

@Component
public class UserService {
	
	UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public boolean addUser(User user) {
		Optional<User> existingUser = userRepository.findByFirstname(user.getFirstname());
		if(!existingUser.isPresent()) {
			userRepository.save(user);
		}
		return existingUser.isPresent();
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public boolean updateUser(User user) {
		Optional<User> existingUser = userRepository.findByFirstnameAndLastname(user.getFirstname(), user.getLastname());
		if(!existingUser.isPresent()) {
			return false;
		}
		userRepository.save(user);
		return true;
	}

}
