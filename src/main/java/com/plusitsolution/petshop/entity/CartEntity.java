package com.plusitsolution.petshop.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.plusitsolution.petshop.domain.CartItem;

@Document (indexName = "cart-index")
public class CartEntity {
	
	@Id
	@ReadOnlyProperty
	private String cartId;
	@Field (type = FieldType.Keyword)
	private String customerId;
	private double totalPrice;
	private List<CartItem> cartItem;
	
	public void calculateTotalPrice() {
		this.totalPrice = 0;
		if(cartItem != null) {
			for (CartItem cartItem : cartItem) {
				this.totalPrice += (cartItem.getPrice() * cartItem.getAmount());
			}
		}
		
	}
	
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
	public List<CartItem> getCartItem() {
		calculateTotalPrice();
		return cartItem;
	}
	
	public void addCartItem(String productID,int amount,double price,String productOption) {
		CartItem cartItems = new CartItem();
		cartItems.setAmount(amount);
		cartItems.setPrice(price);
		cartItems.setProductID(productID);
		cartItems.setProductOption(productOption);
		calculateTotalPrice();
		if(this.cartItem == null)
		{
			this.cartItem = new ArrayList<CartItem>(); 
			this.cartItem.add(cartItems);
		}
		else
		{
			this.cartItem.add(cartItems);
		}
	
	}
	
	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}
	
	public void clearCartItem() {
		this.cartItem = null;
	}

	

}
