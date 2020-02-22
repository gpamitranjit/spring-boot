package com.amit.app.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*
* @author Amit Patil
*
**/
@RestController
@RequestMapping(value = "/v1")
public class Controller {

	@RequestMapping(value = "/greeting/{user}")
	public String greeting(@PathVariable("user") String user) {
		return "Hello " + user;
	}
}
