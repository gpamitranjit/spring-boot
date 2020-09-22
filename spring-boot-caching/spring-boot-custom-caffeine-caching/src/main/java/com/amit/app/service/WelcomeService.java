package com.amit.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
	
	private static final Logger logger = LoggerFactory.getLogger(WelcomeService.class);

	@Cacheable(cacheNames = "greetings", cacheManager = "customCacheManager")
	public String greeting(String userName) {
		
		logger.info("[WelcomeService] greeting({}) called", userName);
		
		if(userName == null) {
			return "Welcome Guest!";
		}
		
		return "welcome " + userName;		
	}
}
