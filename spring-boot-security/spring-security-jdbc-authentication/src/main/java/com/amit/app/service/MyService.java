package com.amit.app.service;

import org.springframework.stereotype.Component;

/**
*
* @author Amit Patil
*
**/
@Component
public class MyService {

	public String greeting(String user) {
		return "Hello " + user;
	}
}
