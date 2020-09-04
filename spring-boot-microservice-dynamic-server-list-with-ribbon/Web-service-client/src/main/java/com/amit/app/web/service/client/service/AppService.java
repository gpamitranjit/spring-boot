package com.amit.app.web.service.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.app.web.service.client.feign.WebServiceFeignClient;

@Service
public class AppService {

	@Autowired
	private WebServiceFeignClient webServiceFeignClient;
	
	public String retrieveGreetingMessage(String userName) {

		System.out.println("[web-service-client] [AppService] userName: " + userName);
		
		String greetingMessage = webServiceFeignClient.greeting(userName);
		
		return greetingMessage;
	}
}
