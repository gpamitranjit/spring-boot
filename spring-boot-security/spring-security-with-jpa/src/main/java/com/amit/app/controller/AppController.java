package com.amit.app.controller;

import java.security.Principal;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
*
* @author Amit Patil
*
**/
@RestController
public class AppController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomeHandler() {
		return ("Welcome");
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userHandler(@AuthenticationPrincipal Principal principal) {
		if(principal == null)
			return "Welcome user";
		else
		return "Welcome " + principal.getName();
	}
}
