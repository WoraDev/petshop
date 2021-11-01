package com.plusitsolution.petshop.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.plusitsolution.petshop.domain.OrderDomain;
import com.plusitsolution.petshop.domain.ProductDomain;
import com.plusitsolution.petshop.domain.orderStatus;
import com.plusitsolution.petshop.entity.CartEntity;
import com.plusitsolution.petshop.entity.OrderEntity;
import com.plusitsolution.petshop.repository.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	CartService cartService;

	public OrderEntity submitOrder(String customerID) {
		if (customerID == null || customerID.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CustomerID required");
		}
		
		CartEntity cartEntity = cartService.getCart(customerID);
		
		if(cartEntity == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This customer cart doesn't exist");
		}
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setDateCreated(LocalDate.now());
		orderEntity.setStatus(orderStatus.PENDING);
		orderEntity.setOrderInfo(cartEntity);
		orderEntity.setCustomerID(customerID);
		
		System.out.println(cartService.getCart(customerID).getCartItem());
		
//		return orderRepo.save(orderEntity);
		return null;
	}

	public OrderEntity updateOrderStatus(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderEntity> getOrders() {
		return orderRepo.findAll();
	}

	public List<OrderEntity> getOrder(String customerID) {
		return orderRepo.findAllByCustomerID(customerID);
	}

}
