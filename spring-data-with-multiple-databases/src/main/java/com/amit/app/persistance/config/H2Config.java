package com.amit.app.persistance.config;

import org.h2.server.web.WebServlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
*
* @author Amit Patil
*
**/
@Configuration
public class H2Config {

	@Bean
	public ServletRegistrationBean<WebServlet> h2servletRegistration() {
	    ServletRegistrationBean<WebServlet> registration = new ServletRegistrationBean<WebServlet>(new WebServlet());
	    registration.addUrlMappings("/console/*");
//	    registration.addInitParameter("webAllowOthers", "true");
	    return registration;
	}
}
