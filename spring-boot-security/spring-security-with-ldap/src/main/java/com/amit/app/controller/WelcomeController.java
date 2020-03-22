package com.amit.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*
* @author Amit Patil
*
**/
@RestController
public class WelcomeController {

	@GetMapping("/")
	public String welcomeHandler() {
		return "Welcome";
	}
}
