package com.plusitsolution.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.plusitsolution.petshop.domain.PetProductCategoryDomain;
import com.plusitsolution.petshop.entity.PetProductCategoryEntity;
import com.plusitsolution.petshop.repository.PetProductCategoryRepo;

@Service
public class PetProductCategoryService {
	
	@Autowired
	private PetProductCategoryRepo petProductCategoryRepo;
	
	public PetProductCategoryEntity addCategory(String catergoryName, List<String> petProductSubCategory) {
		
		
		PetProductCategoryDomain domain = new PetProductCategoryDomain();
		domain.setPetProductMainCategory(catergoryName);
		domain.setPetProductSubCategory(petProductSubCategory);
		return petProductCategoryRepo.save(domain.toEntity());
	}
	
	public void deleteCategory(String MainCategory) {
		PetProductCategoryEntity deleteEntity = petProductCategoryRepo.findBypetProductMainCategory(MainCategory);
		
		if (deleteEntity == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This category doesn't exist");
		}
		petProductCategoryRepo.deleteById(deleteEntity.getPetProductCategoryId());
	}

	public List<PetProductCategoryEntity> getProductCategories(){
		return petProductCategoryRepo.findAll();
	}
	
	public void addSubCategory(String MainCategory, String SubCategory) {
		PetProductCategoryEntity deleteSubCategory = petProductCategoryRepo.findBypetProductMainCategory(MainCategory);
		
		if (deleteSubCategory == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This category doesn't exist");
		}
		
		if(!deleteSubCategory.getPetProductSubCategory().add(SubCategory)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This sub-category doesn't exist");
		}

		petProductCategoryRepo.save(deleteSubCategory);
		
		System.out.println(deleteSubCategory.getPetProductSubCategory());
		
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
		
		PetProductCategoryEntity deleteSubCategory = petProductCategoryRepo.findBypetProductMainCategory(MainCategory);
		
		if (deleteSubCategory == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This category doesn't exist");
		}
		
		if(!deleteSubCategory.getPetProductSubCategory().remove(SubCategory)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This sub-category doesn't exist");
		}

		petProductCategoryRepo.save(deleteSubCategory);
		
		System.out.println(deleteSubCategory.getPetProductSubCategory());
		
	}
	
}
