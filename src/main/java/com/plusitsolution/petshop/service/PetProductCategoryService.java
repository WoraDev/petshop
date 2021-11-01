package com.plusitsolution.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.plusitsolution.petshop.domain.CategoryDomain;
import com.plusitsolution.petshop.entity.CategoryEntity;
import com.plusitsolution.petshop.repository.PetProductCategoryRepo;

@Service
public class PetProductCategoryService {
	
	@Autowired
	private PetProductCategoryRepo petProductCategoryRepo;
	
	public CategoryEntity addCategory(String catergoryName, List<String> petProductSubCategory) {
		
		
		if (catergoryName == null || catergoryName.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please input product's name");
		}
		
		if (petProductSubCategory == null || petProductSubCategory.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please input sub-category");
		}
		
		CategoryEntity newCategoryEnitity = petProductCategoryRepo.findBypetProductMainCategory(catergoryName);
		
		if (newCategoryEnitity != null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This category already exist");
		}
		
		CategoryDomain domain = new CategoryDomain();
		domain.setPetProductMainCategory(catergoryName);
		domain.setPetProductSubCategory(petProductSubCategory);
		return petProductCategoryRepo.save(domain.toEntity());
	}
	
	public void deleteCategory(String MainCategory) {
		CategoryEntity deleteEntity = petProductCategoryRepo.findBypetProductMainCategory(MainCategory);
		
		if (deleteEntity == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This category doesn't exist");
		}
		petProductCategoryRepo.deleteById(deleteEntity.getPetProductCategoryId());
	}

	public List<CategoryEntity> getProductCategories(){
		return petProductCategoryRepo.findAll();
	}
	
	public void addSubCategory(String MainCategory, String SubCategory) {
		
		if (MainCategory == null || MainCategory.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please input product's name");
		}
		
		if (SubCategory == null || SubCategory.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please input sub-category");
		}
		
		CategoryEntity addSubCategory = petProductCategoryRepo.findBypetProductMainCategory(MainCategory);
		
		if (addSubCategory == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This category doesn't exist");
		}
		
		if(addSubCategory.checkPetProductSubCategory(SubCategory)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This sub-category already exist");
		}
		addSubCategory.addPetProductSubCategory(SubCategory);
		petProductCategoryRepo.save(addSubCategory);
		
	}
	
	public void deleteSubCategory(String MainCategory, String SubCategory) {

		if (MainCategory == null || MainCategory.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please input product's name");
		}
		
		if (SubCategory == null || SubCategory.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please input sub-category");
		}
		
		CategoryEntity deleteSubCategory = petProductCategoryRepo.findBypetProductMainCategory(MainCategory);
		
		if (deleteSubCategory == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This category doesn't exist");
		}
		
		if(!deleteSubCategory.checkPetProductSubCategory(SubCategory)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This sub-category doesn't exist");
		}
		
		deleteSubCategory.removePetProductSubCategory(SubCategory);
		petProductCategoryRepo.save(deleteSubCategory);
	}
	
}
