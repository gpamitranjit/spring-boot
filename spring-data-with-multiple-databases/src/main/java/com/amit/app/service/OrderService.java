package com.amit.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.app.datasource1.repository.CustomerRepository;
import com.amit.app.datasource2.model.Order;
import com.amit.app.datasource2.repository.OrderRepository;

/**
*
* @author Amit Patil
*
**/
@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CustomerService customerService;
	
	public Order saveOrder(Order order) {
		
		Boolean customerNotExists = !customerService.customerWithIdExists(order.getCustomerId());
		
		if(customerNotExists)
			throw new EntityNotFoundException("Can't create order with Non-existent customer!");
		
		return orderRepository.save(order);
	}
	
	public Order findOrderById(Long orderId) {
		Optional<Order> order = orderRepository.findById(orderId);
		
		if(!order.isPresent())
			throw new EntityNotFoundException("Order with id: " + orderId + " doesn't exist!");
		
		return order.get();
	}
	
	public List<Order> retrieveAllOrders() {
		List<Order> orderList = new ArrayList<>();
		
		orderRepository.findAll()
			.forEach(order -> {
				orderList.add(order);
			});
		
		return orderList;
	}
}
