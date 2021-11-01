package com.plusitsolution.petshop.domain;


import com.plusitsolution.petshop.entity.CartEntity;

public class CartDomain{
	
	private String cartId;
	private String customerId;
	private double totalPrice;
	
	
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	public CartEntity toEntity() {
		CartEntity entity = new CartEntity();
		entity.setCartId(cartId);
		entity.setCustomerId(customerId);
		entity.setTotalPrice(totalPrice);
		return entity;
	}
	
 
}
