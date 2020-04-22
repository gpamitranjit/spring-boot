package com.amit.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
*
* @author Amit Patil
*
**/
@Configuration
public class AppConfiguration {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
