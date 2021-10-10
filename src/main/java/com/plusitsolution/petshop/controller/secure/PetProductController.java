package com.plusitsolution.petshop.controller.secure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plusitsolution.petshop.entity.PetProductEntity;
import com.plusitsolution.petshop.service.PetShopServices;

@RestController 
public class PetProductController {
	
	@Autowired
	private PetShopServices petShopServices;
		
	@PostMapping("/newProduct")
	public PetProductEntity addPetProduct (@RequestParam("petProductName") String petProductName
			,@RequestParam(value ="petProductCategory") String petProductCategory
			,@RequestParam(value ="petProductPrice") double petProductPrice
			,@RequestParam(value ="petProductInfo") String petProductInfo
			,@RequestParam(value ="petProductBrand") String petProductBrand
			,@RequestParam(value ="inStockAmount") int inStockAmount){
		return petShopServices.addProduct(petProductName,
				petProductCategory,
				petProductPrice,
				petProductInfo,
				petProductBrand,
				inStockAmount);
	}
	
	@PostMapping("/editProduct")
	public PetProductEntity editProduct(@RequestParam("petProductName") String petProductName
			,@RequestParam(value ="petProductCategory") String petProductCategory
			,@RequestParam(value ="petProductPrice") double petProductPrice
			,@RequestParam(value ="petProductInfo") String petProductInfo
			,@RequestParam(value ="petProductBrand") String petProductBrand
			,@RequestParam(value ="intStockAmount") int inStockAmount){
		return petShopServices.editProduct(petProductName,
				petProductCategory,
				petProductPrice,
				petProductInfo,
				petProductBrand,
				inStockAmount);
	}
	
	@DeleteMapping("/product")
	public void deletePetProduct (@RequestParam("petProductName") String petProductName) {
		petShopServices.deleteProduct(petProductName);
	}
	
	@GetMapping("/Products")
	public List<PetProductEntity> getProducts(){
		return petShopServices.getProducts();
	}
	
	@GetMapping("/productByName")
	public PetProductEntity getProductByName(@RequestParam("petProductName") String petProductName){
		return petShopServices.getProductByName(petProductName);
	}
	
	@GetMapping("/ProductByCategory")
	public List<PetProductEntity> getProductByCategory(@RequestParam("petProductCategory")String petProductCategory){
		
		return petShopServices.getProductByCategory(petProductCategory);
	}
}
