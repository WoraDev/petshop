package com.plusitsolution.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.plusitsolution.petshop.domain.PetProductDomain;
import com.plusitsolution.petshop.entity.PetProductEntity;
import com.plusitsolution.petshop.repository.PetProductRepository;


@Service
public class PetShopServices {

	
	@Autowired
	private PetProductRepository petShopRepository;
	
	
	public PetProductEntity addProduct(String petProductName,
			String petProductCategory,
			double petProductPrice,
			String petProductInfo,
			String petProductBrand,
			int inStockAmount){
		PetProductDomain domain = new PetProductDomain();
		domain.setPetProductName(petProductName);
		domain.setPetProductCategory(petProductCategory);
		domain.setPetProductRetailPrice(petProductPrice);
		domain.setPetProductInfo(petProductInfo);
		domain.setPetProductBrand(petProductBrand);
		domain.setInStockAmount(inStockAmount);
		return petShopRepository.save(domain.toEntity());
		
	}
	
	public void deleteProduct(String ProductName) {
		PetProductEntity deleteEntity = petShopRepository.findBypetProductName(ProductName);
		
		if (deleteEntity == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This product doesn't exist");
		}
		petShopRepository.deleteById(deleteEntity.getPetProductId());
	}
	
	public PetProductEntity getPetProductByName(String name) {
		PetProductEntity Entity = petShopRepository.findBypetProductName(name);
		
		if (Entity == null) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This product doesn't exist");
		}
		
		return Entity;
	}
	
	public PetProductEntity editProduct(String petProductName,String petProductCategory,double petProductRetailPrice,String petProductInfo,String petProductBrand,
			int inStockAmount) {

		if (petProductName == null)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please Product's name");
		}
		
		PetProductEntity entity = petShopRepository.findBypetProductName(petProductName);
		
		if(entity == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This Product doesn't exist");
		}
		
		if (petProductName == null || petProductName.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please enter product's name");
		}
		else if(petProductCategory == null || petProductCategory.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please enter product's category");
		}
		else if (petProductInfo == null || petProductInfo.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please enter product's information");
		}

		entity.setPetProductName(petProductName);
		entity.setPetProductCategory(petProductCategory);
		entity.setPetProductRetailPrice(petProductRetailPrice);
		entity.setPetProductInfo(petProductInfo);
		entity.setPetProductBrand(petProductBrand);
		entity.setInStockAmount(inStockAmount);
		return petShopRepository.save(entity);
	}
	
	public List<PetProductEntity> getProducts(){
		return petShopRepository.findAll();
	}
	
	public PetProductEntity getProductByName(String productName){
		
		if (productName == null || productName.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please input product's name");
		}
		
		PetProductEntity Entity = petShopRepository.findBypetProductName(productName);
		
		if(Entity == null)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This product's name doesn't exist");
		}
		
		return Entity;
	}
	
	public List<PetProductEntity> getProductByCategory(String Category){
		
		if (Category == null || Category.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please input category");
		}
		
		PetProductEntity checkCategoryEntity = petShopRepository.findBypetProductName(Category);
		
		if(checkCategoryEntity == null)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This category doesn't exist");
		}

		List<PetProductEntity> entity = petShopRepository.findBypetProductSubCategory(Category);
		return entity;

		
	}
	
	
	
	
}
