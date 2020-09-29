package com.amit.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.model.managed.User;
import com.amit.app.repository.UserRepository;

@RestController
@RequestMapping("/v1")
public class UsersController {

	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(path = "/users/{userId}")
	@Cacheable(cacheNames = "users", key = "#userId", unless = "#result.followers < 80")
	public User getUser(@PathVariable("userId") Long userId) {
		logger.info("Getting the user with ID {}", userId);
		return userRepository.getOne(userId);
	}
}
