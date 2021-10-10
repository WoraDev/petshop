package com.plusitsolution.petshop.controller.secure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plusitsolution.petshop.entity.PetProductCategoryEntity;
import com.plusitsolution.petshop.service.PetProductCategoryService;

@RestController 
public class PetProductCategoryController {

	@Autowired
	private PetProductCategoryService petProductCategoryService;
		
	@PostMapping("/newProductMainCategory")
	public PetProductCategoryEntity addPetProductCategory(@RequestParam("petProductMainCategory") String petProductMainCategory
			,@RequestParam(value ="petProductCategory") List<String> petProductSubCategory){
		return petProductCategoryService.addCategory(petProductMainCategory,
				petProductSubCategory);
	}
	
	@DeleteMapping("/productCategory")
	public void deletePetProduct (@RequestParam("petProductMainCategory") String petProductMainCategory) {
		petProductCategoryService.deleteCategory(petProductMainCategory);
	}
	
	@GetMapping("/productCategories")
	public List<PetProductCategoryEntity> getProductCategories(){
		return petProductCategoryService.getProductCategories();
	}
	
	
	@PostMapping("/addProductSubCatergory")
	public String addPetProductSubCategory (@RequestParam("petProductName") String petProductMainCategory,
										  @RequestParam("petProductSubCategory") String petProductSubCategory) {
		petProductCategoryService.addSubCategory(petProductMainCategory,petProductSubCategory);
		return "Sub-Category-Added";
	}
	
	@DeleteMapping("/productSubCategory")
	public String deletePetProductSubCategory (@RequestParam("petProductName") String petProductMainCategory,
											 @RequestParam("petProductSubCategory") String petProductSubCategory) {
		petProductCategoryService.deleteSubCategory(petProductMainCategory,petProductSubCategory);
		return "Sub-Category-Deleted";
	}
	
	

	
}
