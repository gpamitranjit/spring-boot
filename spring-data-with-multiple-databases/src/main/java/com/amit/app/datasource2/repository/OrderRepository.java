package com.amit.app.datasource2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amit.app.datasource2.model.Order;

/**
*
* @author Amit Patil
*
**/
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
