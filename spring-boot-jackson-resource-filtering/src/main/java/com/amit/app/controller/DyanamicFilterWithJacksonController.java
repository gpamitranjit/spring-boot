package com.amit.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.service.SomeBeanFilterService;

/**
*
* @author Amit Patil
*
**/
@RestController
@RequestMapping("/v1")
public class DyanamicFilterWithJacksonController {

	@Autowired
	private SomeBeanFilterService someBeanFilterService;
	
	@RequestMapping(value = "/someBean/filter/field1Andfield2")
	public MappingJacksonValue getFilteredSomeBeans() {
		return someBeanFilterService.filteroutField1AndField2Service();
	}
	
	@RequestMapping(value = "/someBean/filter/field1Andfield3")
	public MappingJacksonValue getFilteredSomeBeans2() {
		return someBeanFilterService.filteroutField1AndField3Service();
	}
	
}
