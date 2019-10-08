package com.amit.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amit.app.models.User;
import com.amit.app.repository.UserRepository;

/**
*
* Amit Patil
*
**/
@Service
public class SecondUserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public User saveUserDetails(User user) {
		return userRepository.save(user);
	}
}
