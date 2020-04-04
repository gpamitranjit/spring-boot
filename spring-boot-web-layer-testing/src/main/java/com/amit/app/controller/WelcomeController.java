package com.amit.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amit.app.service.GreetingService;

/**
*
* @author Amit Patil
*
**/
@Controller
public class WelcomeController {

	private GreetingService greetingService;
	
	@Autowired
	WelcomeController(GreetingService welcomeService) {
		this.greetingService = welcomeService;
	}
	
	@RequestMapping("/welcome")
	@ResponseBody
	public String welcomeMessage() {
		return greetingService.retrieveGreeting();
	}
}
