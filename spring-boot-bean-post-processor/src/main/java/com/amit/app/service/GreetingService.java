package com.amit.app.service;

/**
*
* @author Amit Patil
*
**/
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
