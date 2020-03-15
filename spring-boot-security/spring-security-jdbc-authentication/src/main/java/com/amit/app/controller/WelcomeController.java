package com.amit.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*
* @author Amit Patil
*
**/
@RestController
public class WelcomeController {

	@RequestMapping("/")
	public String getGreeting() {
		return "Welcome";
	}
}
