package com.amit.app.web.service.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AppService {

	@Autowired
	private RestTemplate restTemplate;
	
	private final String EUREKA_ZUUL_API_GATEWAY_NAME = "zuul-api-gateway";
	
	public String retrieveGreetingMessage(String userName) {

		System.out.println("[web-service-client] [AppService] userName: " + userName);
		
		String greetingMessage = restTemplate.getForObject("http://"+EUREKA_ZUUL_API_GATEWAY_NAME + "/web-service/v1.0/greeting/" + userName, String.class);
		
		return greetingMessage;
	}
}
