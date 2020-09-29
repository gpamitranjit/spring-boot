package com.amit.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amit.app.model.managed.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
