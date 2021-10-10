package com.plusitsolution.petshop.domain;


import com.plusitsolution.petshop.entity.PetProductEntity;

public class PetProductDomain {

	private String petProductId;
	private String petProductName;
	private String petProductCategory;
	private double petProductRetailPrice;
	private String petProductInfo;
	private String petProductBrand;
	private int inStockAmount;

	
	public String getPetProductBrand() {
		return petProductBrand;
	}
	public void setPetProductBrand(String petProductBrand) {
		this.petProductBrand = petProductBrand;
	}
	public int getInStockAmount() {
		return inStockAmount;
	}
	public void setInStockAmount(int inStockAmount) {
		this.inStockAmount = inStockAmount;
	}
	public void setPetProductRetailPrice(double petProductRetailPrice) {
		this.petProductRetailPrice = petProductRetailPrice;
	}
	public String getPetProductId() {
		return petProductId;
	}
	public void setPetProductId(String petProductId) {
		this.petProductId = petProductId;
	}
	public String getPetProductName() {
		return petProductName;
	}
	public void setPetProductName(String petProductName) {
		this.petProductName = petProductName;
	}
	public String getPetProductCategory() {
		return petProductCategory;
	}
	public void setPetProductCategory(String petProductCategory) {
		this.petProductCategory = petProductCategory;
	}
	public String getPetProductInfo() {
		return petProductInfo;
	}
	public double getPetProductRetailPrice() {
		return petProductRetailPrice;
	}
	public void setPetProductInfo(String petProductInfo) {
		this.petProductInfo = petProductInfo;
	}
	
	public PetProductEntity toEntity() {
		PetProductEntity entity = new PetProductEntity();
		entity.setPetProductName(petProductName);
		entity.setPetProductCategory(petProductCategory);
		entity.setPetProductRetailPrice(petProductRetailPrice);
		entity.setPetProductInfo(petProductInfo);
		entity.setPetProductBrand(petProductBrand);
		entity.setInStockAmount(inStockAmount);
		return entity;
	}
	
	
}
