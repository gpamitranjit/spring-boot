package com.amit.limitsservice.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.limitsservice.app.config.LimitsConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

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
	
	@RequestMapping("/limits-service/fault-tolarance-example")
	@HystrixCommand(fallbackMethod = "fallbackForFaultToleranceConfiguration")
	public LimitsConfiguration faultToleranceConfiguration() {
		throw new RuntimeException("Service Not Available");
	}

	public LimitsConfiguration fallbackForFaultToleranceConfiguration() {
		return new LimitsConfiguration(2, 222);
	}
	
}
