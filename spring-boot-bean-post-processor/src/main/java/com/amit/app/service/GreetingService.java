package com.amit.app.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
*
* @author Amit Patil
*
**/
//Intentionally kept as prototype scope
@Service
@Scope("prototype")
public class GreetingService {

//	Intentionally kept as instance variable
	private String greetingMessage = "Welcome";
	
	public String retrieveGreeting() {
		return greetingMessage;
	}

	@Override
	public String toString() {
		return "GreetingService [greetingMessage=" + greetingMessage + "]";
	}
}
