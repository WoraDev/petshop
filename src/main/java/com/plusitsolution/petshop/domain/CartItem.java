package com.plusitsolution.petshop.domain;


import org.springframework.data.annotation.Id;

public class CartItem {
	
	private String productID;
	private int amount;
	private double price;
	private double totalPrice;
	private String productOption;
	
	public double calculateTotalPrice() {
		this.totalPrice = this.price * this.amount;
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public int getAmount() {
		return amount;
	}
	
	public int addAmount(int amount) {
		this.amount += amount;
		calculateTotalPrice();
		return this.amount;
	}
	
	public void setAmount(int amount) {
		calculateTotalPrice();
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProductOption() {
		return productOption;
	}
	public void setProductOption(String productOption) {
		this.productOption = productOption;
	}
	
	
	

}
