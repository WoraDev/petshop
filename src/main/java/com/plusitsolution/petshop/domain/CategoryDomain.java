package com.plusitsolution.petshop.domain;

import java.util.List;

import com.plusitsolution.petshop.entity.CategoryEntity;

public class CategoryDomain {

	private String petProductCategoryId;
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
	
	public CategoryEntity toEntity() {
		CategoryEntity entity = new CategoryEntity();
		entity.setPetProductMainCategory(petProductMainCategory);
		entity.setPetProductSubCategory(petProductSubCategory);
		return entity;
	}
	
}
