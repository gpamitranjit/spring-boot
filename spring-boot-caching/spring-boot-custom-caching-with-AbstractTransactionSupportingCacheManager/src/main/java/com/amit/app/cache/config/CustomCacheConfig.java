package com.amit.app.cache.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amit.app.cache.manager.CustomCacheManager;

@Configuration
public class CustomCacheConfig {

	@Bean
	public CustomCacheManager customCacheManager() {
		return new CustomCacheManager();
	}
}
