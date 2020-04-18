package com.amit.app.service;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import com.amit.app.model.SomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
*
* @author Amit Patil
*
**/
@Service
public class SomeBeanFilterService {

	
	public MappingJacksonValue filteroutField1AndField2Service() {
		
		SomeBean someBeanObject = new SomeBean("value1", "value2", "value3");
		
		MappingJacksonValue mappingjacksonValue = new MappingJacksonValue(someBeanObject);
		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("propertyEliminaterFilter", simpleBeanPropertyFilter);
		mappingjacksonValue.setFilters(filters );
		return mappingjacksonValue;
	}
	
	public MappingJacksonValue filteroutField1AndField3Service() {
		SomeBean someBeanObject = new SomeBean("value1", "value2", "value3");
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBeanObject);
		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("propertyEliminaterFilter", simpleBeanPropertyFilter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
}

