package com.plusitsolution.petshop.domain;

import java.util.List;

import com.plusitsolution.petshop.entity.PetProductCategoryEntity;

public class PetProductCategoryDomain {

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
	
	public PetProductCategoryEntity toEntity() {
		PetProductCategoryEntity entity = new PetProductCategoryEntity();
		entity.setPetProductMainCategory(petProductMainCategory);
		entity.setPetProductSubCategory(petProductSubCategory);
		return entity;
	}
	
}
