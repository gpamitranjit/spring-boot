package com.amit.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*
* @author Amit Patil
*
**/
@RestController
public class ExamineIncorrectHttpServletContextAutowiringController {

	private static final String MY_CUSTOM_HEADER_NAME = "MyCustomHeader";
	private HttpServletRequest httpServletRequest;
	
	@Autowired
	public ExamineIncorrectHttpServletContextAutowiringController(HttpServletRequest httpRequest) {
		this.httpServletRequest = httpRequest;
	}
	
	@RequestMapping("/process/httprequest")
	public String processHttpServleRequestHeaders() {
//		Here null value indicates that the corresponding header doesn't exit in the httpRequest!
		System.out.println("HttpServletRequest obj hashCode: " + this.httpServletRequest.hashCode() + ", with MyCustomHeader value: " + getHttpHeader(MY_CUSTOM_HEADER_NAME));
		return "processed HttpServletRequest object contains MyCustomHeader with value " + getHttpHeader(MY_CUSTOM_HEADER_NAME); 
	}
	
	private String getHttpHeader(String headerName) {
		return this.httpServletRequest.getHeader(headerName) == null ? null : this.httpServletRequest.getHeader(headerName);
	}

//	Deliberately added toString() method representation for tracing the object Instantiation
//	With BeanPostProcessor
	@Override
	public String toString() {
		return "ExamineHttpServletContextController [httpRequest=" + httpServletRequest + "]";
	}
}
