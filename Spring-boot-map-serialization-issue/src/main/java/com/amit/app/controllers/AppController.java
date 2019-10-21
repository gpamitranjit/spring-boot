package com.amit.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.models.Person;
import com.amit.app.repository.PersonRepository;

/**
*
* @author Amit Patil
*
**/
@RestController
@RequestMapping("/v1")
public class AppController {

	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public Person storePersonData(@RequestBody Person person) {
		return personRepository.save(person);
	}
}
