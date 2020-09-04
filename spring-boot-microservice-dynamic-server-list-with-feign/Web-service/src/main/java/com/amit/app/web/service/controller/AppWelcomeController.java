package com.amit.app.web.service.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1.0")
public class AppWelcomeController {

	@RequestMapping(path = "/greeting/{userName}")
	public String greeting(@PathVariable("userName") String userName) {
		System.out.println("userName: " + userName);
		return "Welcome " + userName;
	}
}
