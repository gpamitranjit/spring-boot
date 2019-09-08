package com.amit.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.models.User;
import com.amit.app.service.UserService;

@RestController
@RequestMapping("/v1")
public class AppController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserDetails(@PathVariable("userId") String id) {
		User user = new User(id, "Amit", "Patil", null);
		return user;
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User saveUserDetails(@RequestBody @Validated User user) {
		
		return userService.saveUserDetails(user);
	}
}
