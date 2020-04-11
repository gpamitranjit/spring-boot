package com.amit.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.app.datasource1.model.Customer;
import com.amit.app.datasource1.repository.CustomerRepository;

/**
*
* @author Amit Patil
*
**/
@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Boolean customerWithIdExists(Long customerId) {
		return customerRepository.existsById(customerId);
	}
	
	public Customer findCustomerById(Long customerId) {
		Optional<Customer> customer = customerRepository.findById(customerId);

		if(customer.isEmpty())
			throw new EntityNotFoundException("Customer with id: " + customerId + " doesn't exist!");
		
		return customer.get();
	}
	
	public List<Customer> retrieveAllCustomers() {
		List<Customer> customerList = new ArrayList<>();
		customerRepository.findAll()
			.forEach(customer -> {
				customerList.add(customer);
			});
		
		return customerList;
	}
}
