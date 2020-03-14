package com.amit.app.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.service.MyService;

/**
*
* @author Amit Patil
*
**/
@RestController
@RequestMapping("/v1")
public class AppController {

	@Autowired
	private MyService myService;
	
	@RequestMapping("/greeting/{user}")
	public String greeting(@PathVariable String user) {
		return myService.greeting(user);
	}
	
	@RequestMapping("/current/user")
	public Principal getPrincipal(Principal principal) {
		return principal;
	}
}
