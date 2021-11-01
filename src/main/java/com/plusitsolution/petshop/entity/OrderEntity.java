package com.plusitsolution.petshop.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.plusitsolution.petshop.domain.orderStatus;

@Document (indexName = "order-index")
public class OrderEntity {
	
    @Id
    @ReadOnlyProperty
    private String orderId;

    @JsonFormat(pattern = "dd/MM/yyyy")
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

	public CartEntity getOrderInfo() {
		return orderInfo;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	
	public void setOrderInfo(CartEntity orderInfo) {
		this.orderInfo = orderInfo;
	}

	public String getOrderId() {
		return orderId;
	}

}
