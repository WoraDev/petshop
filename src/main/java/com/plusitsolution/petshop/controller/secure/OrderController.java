package com.plusitsolution.petshop.controller.secure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plusitsolution.petshop.entity.OrderEntity;
import com.plusitsolution.petshop.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/order")
	public OrderEntity submitOrder(@RequestParam("customerID") String customerID) {
		return orderService.submitOrder(customerID);
		
	}
	
	@PutMapping("/order")
	public OrderEntity updateOrderStatus(@RequestParam("orderID") String orderID) {
		return orderService.updateOrderStatus(orderID);
		
	}
	
	@GetMapping("/orders")
	public List<OrderEntity> getOrders() {
		return orderService.getOrders();
		
	}
	
	@GetMapping("/order")
	public List<OrderEntity> getOrder(@RequestParam("customerID") String customerID) {
		return orderService.getOrder(customerID);
		
	}

}
