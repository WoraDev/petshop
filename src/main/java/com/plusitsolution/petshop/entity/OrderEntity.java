package com.plusitsolution.petshop.entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document (indexName = "order-index")
public class OrderEntity {
	
	@Id
	@ReadOnlyProperty
	private String OrderId;
	@ManyToOne
	@JoinColumn(name = "petProductId")
	@Field (type = FieldType.Keyword)
	private int customerId;
	
	@ManyToOne
	@JoinColumn(name = "customerID")
	private PetProductEntity product;
	
	public String getOrderId() {
		return OrderId;
	}

	public void setOrderId(String orderId) {
		OrderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public PetProductEntity getProduct() {
		return product;
	}

	public void setProduct(PetProductEntity product) {
		this.product = product;
	}

}
