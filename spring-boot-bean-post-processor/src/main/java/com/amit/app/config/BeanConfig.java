package com.amit.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.amit.app.service.GreetingService;

/**
*
* @author Amit Patil
*
**/
@Configuration
public class BeanConfig {

	@Bean(name = {"greetingService"})
	@Scope("prototype")
	public GreetingService greetingService() {
		return new GreetingService();
	}
}
