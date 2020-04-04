package com.amit.app.service;

import org.springframework.stereotype.Service;

/**
*
* @author Amit Patil
*
**/
@Service
public class GreetingService {

	public String retrieveGreeting() {
		return "Welcome";
	}
}
