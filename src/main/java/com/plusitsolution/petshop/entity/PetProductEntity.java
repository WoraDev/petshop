package com.plusitsolution.petshop.entity;



import java.util.HashSet;
import java.util.HashMap;
import com.plusitsolution.petshop.domain.ProductOptionDomain;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document (indexName = "petproduct-index")
public class PetProductEntity {
	
	@Id
	@ReadOnlyProperty
	private String petProductId;
	@Field (type = FieldType.Keyword)
	private String petProductName;
	@Field (type = FieldType.Keyword)
	private String petProductSubCategory;
	private double petProductRetailPrice;
	@Field (type = FieldType.Keyword)
	private String petProductInfo;
	@Field (type = FieldType.Keyword)
	private String petProductBrand;
	private int inStockAmount;
	private HashMap<String ,ProductOptionDomain> productionOption;
	
	public String getPetProductSubCategory() {
		return petProductSubCategory;
	}
	public void setPetProductSubCategory(String petProductSubCategory) {
		this.petProductSubCategory = petProductSubCategory;
	}
	
	public String getPetProductId() {
		return petProductId;
	}
	public void setPetProductId(String petProductId) {
		this.petProductId = petProductId;
	}
	public String getPetProductName() {
		return petProductName;
	}
	public void setPetProductName(String petProductName) {
		this.petProductName = petProductName;
	}

	public double getPetProductRetailPrice() {
		return petProductRetailPrice;
	}
	public void setPetProductRetailPrice(double petProductRetailPrice) {
		this.petProductRetailPrice = petProductRetailPrice;
	}
	public String getPetProductInfo() {
		return petProductInfo;
	}
	public void setPetProductInfo(String petProductInfo) {
		this.petProductInfo = petProductInfo;
	}
	public String getPetProductBrand() {
		return petProductBrand;
	}
	public void setPetProductBrand(String brand) {
		petProductBrand = brand;
	}
	public int getInStockAmount() {
		return inStockAmount;
	}
	public void setInStockAmount(int inStockAmount) {
		this.inStockAmount = inStockAmount;
	}
	public HashMap<String, ProductOptionDomain> getProductionOption() {
		return productionOption;
	}
	public void setProductionOption(HashMap<String, ProductOptionDomain> productionOption) {
		this.productionOption = productionOption;
	}
	public void addProductionOption(String optionName,String OptionDetail,double price) {
		ProductOptionDomain productOption = new ProductOptionDomain();
		productOption.setOptionDetail(OptionDetail);
		productOption.setPrice(price);
		
		if(this.productionOption == null)
		{
			this.productionOption = new HashMap<String, ProductOptionDomain>(); 
			this.productionOption.put(optionName,productOption);
		}
		else
		{
			this.productionOption.put(optionName,productOption);
		}
	}
	public void removeProductionOption(String optionName) {
		this.productionOption.remove(optionName);
	}
	public boolean checkProductionOption(String optionName) {
		if(this.productionOption.containsKey(optionName)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
