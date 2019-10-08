package com.amit.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.amit.app.models.Address;
import com.amit.app.models.User;
import com.amit.app.repository.AddressRepository;
import com.amit.app.repository.UserRepository;

/**
*
* @author Amit Patil
*
**/
@Service
public class FirstUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SecondUserService secondUserService;
	
	@Autowired
	private AddressRepository addressRepository;
	
	public User getUserById(String id) {
		return userRepository.getEntityById(id);
	}
	
	@Transactional
	public User saveUserDetails(User user) {
		return this.anotherInternalMethodSaveUserDetails(user);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public User anotherInternalMethodSaveUserDetails(User user) {
		return userRepository.save(user);
	}
	
	public Address getAddressById(String id) {
		return addressRepository.getEntityById(id);
	}
}
