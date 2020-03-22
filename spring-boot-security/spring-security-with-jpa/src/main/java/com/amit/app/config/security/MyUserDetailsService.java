package com.amit.app.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.amit.app.managed.model.MyUser;
import com.amit.app.repository.UserRepository;

/**
*
* @author Amit Patil
*
**/
@Component
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<MyUser> myUser = userRepository.findByUsername(userName);
		return new MyUserDetails(myUser.get());
	}

}
