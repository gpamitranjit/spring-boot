package com.amit.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.app.models.User;
import com.amit.app.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUserById(String id) {
		return userRepository.getEntityById(id);
	}
	
	public User saveUserDetails(User user) {
		return userRepository.save(user);
	}
}
