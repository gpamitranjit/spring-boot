package com.amit.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.amit.app.interceptors.LoginInterceptor;

/**
*
* @author Amit Patil
*
**/
@Configuration
public class AppWebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		//Registering LoginInterceptor and configure it to be applied to all the incoming requests
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}

}
