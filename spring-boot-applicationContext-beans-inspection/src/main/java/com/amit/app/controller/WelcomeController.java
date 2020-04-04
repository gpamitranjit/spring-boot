package com.amit.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
*
* @author Amit Patil
*
**/
@RestController
public class WelcomeController {

	@RequestMapping("/")
	public String retrieveGreeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
		return "Hello " + name;
	}
}
