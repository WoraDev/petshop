package com.plusitsolution.petshop.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document (indexName = "petproduct-index")
public class PetProductEntity {
	
	@Id
	@ReadOnlyProperty
	private String petProductId;
	@Field (type = FieldType.Keyword)
	private String petProductName;
	@Field (type = FieldType.Keyword)
	private String petProductSubCategory;
	private double petProductRetailPrice;
	@Field (type = FieldType.Keyword)
	private String petProductInfo;
	@Field (type = FieldType.Keyword)
	private String petProductBrand;
	private int inStockAmount;
	
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
		return petProductSubCategory;
	}
	public void setPetProductCategory(String  petProductSubCategory) {
		this.petProductSubCategory = petProductSubCategory;
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
	public void setPetProductBrand(String brand) {
		petProductBrand = brand;
	}
	public int getInStockAmount() {
		return inStockAmount;
	}
	public void setInStockAmount(int inStockAmount) {
		this.inStockAmount = inStockAmount;
	}
	
	

}
