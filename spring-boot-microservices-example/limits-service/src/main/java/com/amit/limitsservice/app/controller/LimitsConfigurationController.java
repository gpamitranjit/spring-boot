package com.amit.limitsservice.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.limitsservice.app.config.LimitsConfiguration;

/**
*
* @author Amit Patil
*
**/
@RestController
@RequestMapping("/v1")
public class LimitsConfigurationController {

	@Autowired
	private LimitsConfiguration limitsConfiguration;
	
	@RequestMapping(path = "/limits-service/configuration")
	public LimitsConfiguration serveServiceConfiguration() {
		return limitsConfiguration;
	}
}
