package com.amit.app.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*
* @author Amit Patil
*
**/
@RestController
@RequestMapping("/v1")
public class AppController {

	@RequestMapping("/greeting/{userName}")
	public String retrieveGreeting(@PathVariable("userName") String userName) {
		return "Welcome " + userName;
	}
}
