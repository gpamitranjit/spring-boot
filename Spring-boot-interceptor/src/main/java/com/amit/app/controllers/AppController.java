package com.amit.app.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.models.User;

@RestController
@RequestMapping("/v1")
public class AppController {

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserDetails(@PathVariable("userId") String id) {
		User user = new User(id, "Amit", "Patil", null);
		return user;
	}
}
