package com.plusitsolution.petshop.service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.plusitsolution.petshop.domain.ProductDomain;
import com.plusitsolution.petshop.domain.ProductOptionDomain;
import com.plusitsolution.petshop.entity.PetProductEntity;
import com.plusitsolution.petshop.repository.PetProductRepository;


@Service
public class PetShopService {

	
	@Autowired
	private PetProductRepository petShopRepository;
	
	
	public PetProductEntity addProduct(String petProductName,
			String petProductSubCategory,
			double petProductPrice,
			String petProductInfo,
			String petProductBrand,
			int inStockAmount){
		
		
		if (petProductName == null || petProductName.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please input product's name");
		}
		
		if (petProductSubCategory == null || petProductSubCategory.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please input sub-category");
		}
		
		if (petProductPrice <= 0)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please input valid price number");
		}
		
		if (inStockAmount < 0)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please input valid stock amount");
		}
		
		PetProductEntity productEntity = petShopRepository.findBypetProductName(petProductName);
		
		if (productEntity != null) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This product already exist");
		}
		ProductDomain domain = new ProductDomain();
		domain.setPetProductName(petProductName);
		domain.setPetProductSubCategory(petProductSubCategory);
		domain.setPetProductRetailPrice(petProductPrice);
		domain.setPetProductInfo(petProductInfo);
		domain.setPetProductBrand(petProductBrand);
		domain.setInStockAmount(inStockAmount);
//		domain.setProductionOption(productionOption);
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
	
	public PetProductEntity  editProduct(String petProductName
			,String petProductSubCategory
			,double petProductRetailPrice
			,String petProductInfo
			,String petProductBrand
			,int inStockAmount) {

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
		else if (petProductInfo == null || petProductInfo.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please enter product's information");
		}

		entity.setPetProductName(petProductName);
		entity.setPetProductSubCategory(petProductSubCategory);
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

		List<PetProductEntity> entity = petShopRepository.findBypetProductSubCategory(Category);
		return entity;

	}
	
	public PetProductEntity addProductOption(String productName,String optionName,String optionDetail,Double price){
		
		if (productName == null || productName.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please input Product's Name");
		}
		
		if (optionName == null || optionName.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please input Option's Name");
		}
		
		if (optionDetail == null || optionDetail.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please input Option's Detail");
		}
		
		if (price <= 0)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please input valid price number");
		}
		
		PetProductEntity checkEntity = petShopRepository.findBypetProductName(productName);
		
		if(checkEntity == null)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This product doesn't exist");
		}
		
		if(checkEntity.checkProductionOption(optionName))
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This product's option is already exist");
		}
		
		checkEntity.addProductionOption(optionName,optionDetail,price);
		
		return petShopRepository.save(checkEntity);
	}
	
	public PetProductEntity removeProductOption(String productName,String optionName){
		
		if (productName == null || productName.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please input Product's Name");
		}
		
		if (optionName == null || optionName.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please input Option's Name");
		}
		
		PetProductEntity checkEntity = petShopRepository.findBypetProductName(productName);
		
		if(checkEntity == null)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This product doesn't exist");
		}
		
		if(!checkEntity.checkProductionOption(optionName))
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This product's option doesn't exist");
		}
		
		checkEntity.removeProductionOption(optionName);
		
		return petShopRepository.save(checkEntity);
	}
	
	
	
	
}
