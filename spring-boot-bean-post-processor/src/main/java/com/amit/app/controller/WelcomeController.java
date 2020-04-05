package com.amit.app.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.service.GreetingService;

/**
*
* @author Amit Patil
*
**/
// Injecting prototype scoped GreetingService bean into singleton scoped bean!
@RestController
public class WelcomeController implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	
	@RequestMapping("/")
	public String greeting() {
		return greetingService().retrieveGreeting();
	}

	private GreetingService greetingService() {
		return applicationContext.getBean(GreetingService.class);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
