package com.plusitsolution.petshop.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.plusitsolution.petshop.entity.PetProductEntity;

public class ProductDomain {

	private String petProductId;
	private String petProductName;
	private String petProductSubCategory;
	private double petProductRetailPrice;
	private String petProductInfo;
	private String petProductBrand;
	private int inStockAmount;
	private HashMap<String ,ProductOptionDomain> productionOption;
	
	
	public void setProductionOption(HashMap<String, ProductOptionDomain> productionOption) {
		this.productionOption = productionOption;
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


	public String getPetProductSubCategory() {
		return petProductSubCategory;
	}


	public void setPetProductSubCategory(String petProductCategory) {
		this.petProductSubCategory = petProductCategory;
	}


	public double getPetProductRetailPrice() {
		return petProductRetailPrice;
	}


	public void setPetProductRetailPrice(double petProductRetailPrice) {
		this.petProductRetailPrice = petProductRetailPrice;
	}


	public String getPetProductInfo() {
		return petProductInfo;
	}


	public void setPetProductInfo(String petProductInfo) {
		this.petProductInfo = petProductInfo;
	}


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


	public HashMap<String, ProductOptionDomain> getProductionOption() {
		return productionOption;
	}


	public void setProductionOption(String optionName, ProductOptionDomain productionOption) {
		this.productionOption.put(optionName, productionOption);
	}


	public PetProductEntity toEntity() {
		PetProductEntity entity = new PetProductEntity();
		entity.setPetProductName(petProductName);
		entity.setPetProductSubCategory(petProductSubCategory);
		entity.setPetProductRetailPrice(petProductRetailPrice);
		entity.setPetProductInfo(petProductInfo);
		entity.setPetProductBrand(petProductBrand);
		entity.setInStockAmount(inStockAmount);
		entity.setProductionOption(productionOption);
		return entity;
	}

	
	
}
