package com.amit.app.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1")
public class WelcomeController {

	
	@RequestMapping(path = "/welcome/{userName}", method = RequestMethod.GET)
	@Cacheable(cacheManager = "customCacheManager", cacheNames = "customer")
	public String greetingMessage(@PathVariable("userName") String userName) {
		return "Welcome " + userName;
	}
}
