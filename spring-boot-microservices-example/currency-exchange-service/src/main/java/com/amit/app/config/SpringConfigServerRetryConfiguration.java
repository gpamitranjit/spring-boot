package com.amit.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.interceptor.RetryInterceptorBuilder;
import org.springframework.retry.interceptor.RetryOperationsInterceptor;

/**
*
* @author Amit Patil
*
**/
//@Configuration
public class SpringConfigServerRetryConfiguration {

// Disabled the manual registration spring-retry configuration
// Kept this configuration just for reference that one can do the programatic configuration
// of spring-rety
	
//	@Bean
	public RetryOperationsInterceptor configServerRetryInterceptor() {
		return RetryInterceptorBuilder.stateless()
					.backOffOptions(2000, 3, 20000)
					.maxAttempts(10)
					.build();
	}
}
