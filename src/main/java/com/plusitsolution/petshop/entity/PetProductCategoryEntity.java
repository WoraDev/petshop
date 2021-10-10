package com.plusitsolution.petshop.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document (indexName = "petproductcategory-index")
public class PetProductCategoryEntity {
	
	@Id 
	@ReadOnlyProperty
	private String petProductCategoryId;
	@Field (type = FieldType.Keyword)
	private String petProductMainCategory;
	private List<String> petProductSubCategory;
	
	
	public String getPetProductCategoryId() {
		return petProductCategoryId;
	}
	public void setPetProductCategoryId(String petProductCategoryId) {
		this.petProductCategoryId = petProductCategoryId;
	}
	public String getPetProductMainCategory() {
		return petProductMainCategory;
	}
	public void setPetProductMainCategory(String petProductMainCategory) {
		this.petProductMainCategory = petProductMainCategory;
	}
	public List<String> getPetProductSubCategory() {
		return petProductSubCategory;
	}
	public void setPetProductSubCategory(List<String> petProductMainCategory) {
		this.petProductSubCategory = petProductMainCategory;
	}
	
	

}
