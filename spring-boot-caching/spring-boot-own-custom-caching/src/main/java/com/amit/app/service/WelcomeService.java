package com.amit.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.amit.app.model.Person;

@Service
public class WelcomeService {
	
	private static final Logger logger = LoggerFactory.getLogger(WelcomeService.class);

	public WelcomeService() {}
	
	public Person greeting(String userName) {
		
		logger.info("[WelcomeService] greeting({}) called", userName);
		
		if(userName == null) {
			return new Person("Welcome Guest!");
		}
		
		return new Person("welcome " + userName);		
	}
	
	public String sample() {
		return "DummyResponse";
	}
}
