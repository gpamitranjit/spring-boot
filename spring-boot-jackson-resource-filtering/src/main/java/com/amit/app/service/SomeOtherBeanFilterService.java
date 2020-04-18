package com.amit.app.service;

import org.springframework.stereotype.Service;

import com.amit.app.model.SomeOtherBean;

/**
*
* @author Amit Patil
*
**/
@Service
public class SomeOtherBeanFilterService {

//	This service is just dummy to segregate the layers of calls
//	Actual work of filtering is done by the jackson,
//	when writing the response back to the response output stream from controller 
	public SomeOtherBean filteroutfirstNameService() {
		SomeOtherBean someOtherBean = new SomeOtherBean("Amit", "Patil");
		return someOtherBean;
	}
}
