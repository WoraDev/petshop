package com.plusitsolution.petshop.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document (indexName = "petproductcategory-index")
public class CategoryEntity {
	
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
	
	public void setPetProductSubCategory(List<String> petProductSubCategory) {
		this.petProductSubCategory = petProductSubCategory;
	}
	
	public void addPetProductSubCategory(String petProductSubCategory) {
		this.petProductSubCategory.add(petProductSubCategory);
	}
	
	public void removePetProductSubCategory(String petProductSubCategory) {
		this.petProductSubCategory.remove(petProductSubCategory);
	}
	
	public boolean checkPetProductSubCategory(String petProductSubCategory) {
		if(this.petProductSubCategory.contains(petProductSubCategory))
			{
			return true;
			}
		return false;
	}
	
	

}
