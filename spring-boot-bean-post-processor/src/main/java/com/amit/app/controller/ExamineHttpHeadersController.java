package com.amit.app.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*
* @author Amit Patil
*
**/
@RestController
public class ExamineHttpHeadersController {

	@RequestMapping("/process/headers")
	public Map<String, String> extractAllHttpHeadersHandler(@RequestHeader Map<String, String> headers) {
		return headers;
	}
}
