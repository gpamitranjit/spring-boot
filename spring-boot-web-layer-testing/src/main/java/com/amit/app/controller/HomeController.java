package com.amit.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
*
* @author Amit Patil
*
**/
@Controller
public class HomeController {

	@RequestMapping("/")
	@ResponseBody
	public String greeting() {
		return "Hello, World";
	}
}
