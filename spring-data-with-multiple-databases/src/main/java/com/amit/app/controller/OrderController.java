package com.amit.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.datasource2.model.Order;
import com.amit.app.service.OrderService;

/**
*
* @author Amit Patil
*
**/
@RestController
@RequestMapping("/v1")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public Order saveOrder(@RequestBody Order order) {
		return orderService.saveOrder(order);
	}
	
	@RequestMapping(value = "/order/{orderId}")
	public Order retrieveOrderById(@PathVariable("orderId") Long orderId) {
		return orderService.findOrderById(orderId);
	}
	
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public List<Order> retrieveAllOrders() {
		return orderService.retrieveAllOrders();
	}
}
