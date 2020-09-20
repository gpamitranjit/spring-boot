package com.amit.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.service.WelcomeService;

@RestController
@RequestMapping("/v1.0")
public class AppWelcomeController {

	private static final Logger logger = LoggerFactory.getLogger(AppWelcomeController.class);
	@Autowired
	private WelcomeService welcomeService;
	
	@RequestMapping(path = "/welcome")
	public String welcome(@RequestParam(required = false) String userName) {
		logger.info("[AppWelcomeController] caling WelcomeService.greeting({})", userName);
		return welcomeService.greeting(userName);
	}
}
