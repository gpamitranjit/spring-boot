package com.amit.app.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amit.app.managed.model.Product;

/**
*
* @author Amit Patil
*
**/
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
