package com.amit.app.repository;

import org.springframework.stereotype.Repository;

import com.amit.app.models.User;

@Repository
public interface UserRepository	 extends UserBaseRespository<User, String> {
	
}
