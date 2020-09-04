package com.amit.app.web.service.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.web.service.client.service.AppService;

@RestController
@RequestMapping(path = "/v1.0")
public class WelcomeController {
	
	@Autowired
	private AppService appService;

	@RequestMapping(path = "/greeting/{userName}")
	public String greeting(@PathVariable("userName") String userName) {
		
		System.out.println("[web-service-client] [WelcomeController] userName: " + userName);
		
		return appService.retrieveGreetingMessage(userName);
	}
}
