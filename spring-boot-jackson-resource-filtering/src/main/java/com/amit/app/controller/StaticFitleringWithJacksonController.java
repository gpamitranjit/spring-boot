package com.amit.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.model.SomeOtherBean;
import com.amit.app.service.SomeOtherBeanFilterService;

/**
*
* @author Amit Patil
*
**/
@RestController
@RequestMapping("/v1")
public class StaticFitleringWithJacksonController {

	@Autowired
	private SomeOtherBeanFilterService someOtherBeanFilterService;
	
	@RequestMapping(path = "/someOtherBean/filter/firstName")
	public SomeOtherBean retriveSomeOtherBean() {
		return someOtherBeanFilterService.filteroutfirstNameService();
	}
}
