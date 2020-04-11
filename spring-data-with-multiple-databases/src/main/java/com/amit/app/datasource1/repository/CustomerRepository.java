package com.amit.app.datasource1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amit.app.datasource1.model.Customer;

/**
*
* @author Amit Patil
*
**/
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
