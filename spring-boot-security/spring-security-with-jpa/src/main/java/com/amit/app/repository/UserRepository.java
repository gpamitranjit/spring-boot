package com.amit.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amit.app.managed.model.MyUser;

/**
*
* @author Amit Patil
*
**/
@Repository
public interface UserRepository extends JpaRepository<MyUser, Long> {
	
	public Optional<MyUser> findByUsername(String userName);
}
