package com.plusitsolution.petshop.controller.secure;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plusitsolution.petshop.domain.ProductOptionDomain;
import com.plusitsolution.petshop.entity.PetProductEntity;
import com.plusitsolution.petshop.service.PetShopService;

@RestController 
public class PetProductController {
	
	@Autowired
	private PetShopService petShopServices;
		
	@PostMapping("/product")
	public PetProductEntity addPetProduct (@RequestParam("petProductName") String petProductName
			,@RequestParam(value ="petProductCategory") String petProductSubCategory
			,@RequestParam(value ="petProductPrice") double petProductPrice
			,@RequestParam(value ="petProductInfo") String petProductInfo
			,@RequestParam(value ="petProductBrand") String petProductBrand
			,@RequestParam(value ="inStockAmount") int inStockAmount){
		return petShopServices.addProduct(petProductName,
				petProductSubCategory,
				petProductPrice,
				petProductInfo,
				petProductBrand,
				inStockAmount);
	}
	
	@PutMapping("/product")
	public PetProductEntity editProduct(@RequestParam("petProductName") String petProductName
			,@RequestParam(value ="petProductCategory", required = false) String petProductSubCategory
			,@RequestParam(value ="petProductPrice", required = false) double petProductPrice
			,@RequestParam(value ="petProductInfo", required = false) String petProductInfo
			,@RequestParam(value ="petProductBrand", required = false) String petProductBrand
			,@RequestParam(value ="intStockAmount", required = false) int inStockAmount){
		return petShopServices.editProduct(petProductName,
											petProductSubCategory,
											petProductPrice,
											petProductInfo,
											petProductBrand,
											inStockAmount);
	}
	
	@DeleteMapping("/product")
	public void deletePetProduct (@RequestParam("petProductName") String petProductName) {
		petShopServices.deleteProduct(petProductName);
	}
	
	@GetMapping("/products")
	public List<PetProductEntity> getProducts(){
		return petShopServices.getProducts();
	}
	
	@GetMapping("/product")
	public PetProductEntity getProductByName(@RequestParam("petProductName") String petProductName){
		return petShopServices.getProductByName(petProductName);
	}
	
	@GetMapping("/productByCategory")
	public List<PetProductEntity> getProductByCategory(@RequestParam("petProductCategory")String petProductCategory){
		
		return petShopServices.getProductByCategory(petProductCategory);
	}
	
	@PostMapping("/productOption")
	public PetProductEntity addPetProduct (@RequestParam("petProductName") String petProductName
			,@RequestParam(value ="optionName") String optionName,
			@RequestParam(value ="optionDetail", required = false) String optionDetail,
			@RequestParam(value ="price") double price){
		return petShopServices.addProductOption(petProductName,optionName,optionDetail,price);
	}
	
	@DeleteMapping("/productOption")
	public PetProductEntity removePetProduct (@RequestParam("petProductName") String petProductName
			,@RequestParam(value ="optionName") String optionName){
		return petShopServices.removeProductOption(petProductName,optionName);
	}
}
