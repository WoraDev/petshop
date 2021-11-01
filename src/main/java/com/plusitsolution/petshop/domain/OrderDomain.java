package com.plusitsolution.petshop.domain;

import java.time.LocalDate;
import java.util.List;

import com.plusitsolution.petshop.entity.CartEntity;
import com.plusitsolution.petshop.entity.OrderEntity;

public class OrderDomain {
	

    private LocalDate dateCreated;
    private orderStatus status;
    private CartEntity orderInfo;
    private String customerID;
    
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	public orderStatus getStatus() {
		return status;
	}
	public void setStatus(orderStatus status) {
		this.status = status;
	}
	public CartEntity getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(CartEntity orderInfo) {
		this.orderInfo = orderInfo;
	}

	public OrderEntity toEntity() {
		OrderEntity entity = new OrderEntity();
		entity.setDateCreated(dateCreated);
		entity.setStatus(status);
		entity.setOrderInfo(orderInfo);
		entity.setCustomerID(customerID);
		return entity;
	}
	
}
