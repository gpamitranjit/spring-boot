package com.amit.app.repository;

import org.springframework.stereotype.Repository;

import com.amit.app.models.User;

/**
*
* @author Amit Patil
*
**/
@Repository
public interface UserRepository extends UserBaseRespository<User, String> {
	
}
