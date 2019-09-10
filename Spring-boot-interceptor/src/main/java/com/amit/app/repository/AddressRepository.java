package com.amit.app.repository;

import org.springframework.stereotype.Repository;

import com.amit.app.models.Address;

/**
*
* @author Amit Patil
*
**/
@Repository
public interface AddressRepository extends AddressBaseRepository<Address, String> {

}
