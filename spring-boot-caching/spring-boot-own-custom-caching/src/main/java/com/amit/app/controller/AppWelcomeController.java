package com.amit.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.annotations.MethodCacheable;
import com.amit.app.model.Person;
import com.amit.app.service.WelcomeService;

@RestController
@RequestMapping("/v1.0")
public class AppWelcomeController {

	private static final Logger logger = LoggerFactory.getLogger(AppWelcomeController.class);
	@Autowired
	private WelcomeService welcomeService;
	
	@RequestMapping(path = "/{country}/welcome")
	@MethodCacheable(key = "country + userName")
	public Person welcome(@PathVariable("country") String country, @RequestParam(required = false) String userName) {
		logger.info("[AppWelcomeController] greeting({}) calling", userName);
		return welcomeService.greeting(userName);
	}
	
	
	@RequestMapping(path = {"/{country}/{state}/welcome"})
	@MethodCacheable(key = "country + state + userName")
	public Person welcome2(@PathVariable("country") String country, @PathVariable("state") String state, @RequestParam(value = "userName", required = false) String userName) {
		logger.info("[AppWelcomeController] welcome2({}, {}, {})", country, state, userName);
		return new Person(userName);
	}
}
