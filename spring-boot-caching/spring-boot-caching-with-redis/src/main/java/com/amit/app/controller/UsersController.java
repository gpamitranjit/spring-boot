package com.amit.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.model.managed.User;
import com.amit.app.repository.UserRepository;

@RestController
@RequestMapping("/v1")
public class UsersController {

	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(path = "/users/{userId}", method = RequestMethod.GET)
	@Cacheable(cacheNames = "users", key = "#userId", unless = "#result.followers < 80")
	public User getUser(@PathVariable("userId") Long userId) {
		logger.info("Getting the user with ID {}", userId);
		return userRepository.getOne(userId);
	}
	
	
	@RequestMapping(path = "/user", method = RequestMethod.PUT)
	@CachePut(cacheNames = "users", key = "#user.id")
	public User updateUser(@RequestBody User user) {
		logger.info("Updating the user with ID {}", user.getId());
		return userRepository.save(user);
	}
	
	@RequestMapping(path = "/users/{userId}", method = RequestMethod.DELETE)
	@CacheEvict(cacheNames = "users", key = "#root.args[0]")
	public void deleteUser(@PathVariable("userId") Long userId) {
		userRepository.deleteById(userId);
	}
}
