package com.amit.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.datasource1.model.Customer;
import com.amit.app.service.CustomerService;

/**
*
* @author Amit Patil
*
**/
@RestController
@RequestMapping("/v1")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
	public Customer retrieveCustomerById(@PathVariable("customerId") Long customerId) {
		return customerService.findCustomerById(customerId);
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public List<Customer> retrieveAllCustomers() {
		return customerService.retrieveAllCustomers();
	}
}
