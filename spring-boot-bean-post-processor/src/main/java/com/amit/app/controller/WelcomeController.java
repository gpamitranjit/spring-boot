package com.amit.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.service.GreetingService;

/**
*
* @author Amit Patil
*
**/
// Intentionally kept as prototype scope
@RestController
@Scope("prototype")
public class WelcomeController {

	@Autowired
	private GreetingService greetingService;
	
	@RequestMapping("/")
	public String greeting() {
		return greetingService.retrieveGreeting();
	}

	@Override
	public String toString() {
		return "WelcomeController [greetingService=" + greetingService + "]";
	}
}
