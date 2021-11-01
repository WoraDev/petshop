package com.plusitsolution.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.plusitsolution.petshop.domain.CartDomain;
import com.plusitsolution.petshop.domain.CartItem;
import com.plusitsolution.petshop.domain.ProductDomain;
import com.plusitsolution.petshop.entity.CartEntity;
import com.plusitsolution.petshop.entity.PetProductEntity;
import com.plusitsolution.petshop.repository.CartRepo;

@Service
public class CartService {
	
	@Autowired
	private CartRepo cartRepo;
	
	public CartEntity addCart(String customerId) {
		CartDomain domain = new CartDomain();
		
		if (customerId == null || customerId.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CustomerID required");
		}
		
		CartEntity cartEntity = cartRepo.findByCustomerId(customerId);
		
		if (cartEntity != null) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This customer's cart already exist");
		}
		domain.setCustomerId(customerId);
		return cartRepo.save(domain.toEntity());
	}
	
	public CartEntity addCartItem(String customerID, String productID, String prodcuctInfo, double price, int amount, String productOption) {
		
		if (customerID == null || customerID.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CustomerID required");
		}
		
		if (productID == null || productID.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ProductID required");
		}
		
		if (prodcuctInfo == null || prodcuctInfo.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ProdcuctInfo required, if none please input - ");
		}
		
		if (price <= 0)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please input valid price value");
		}
		
		if (amount <=0)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unvalid quatity amount");
		}
	
		
		CartEntity cartEntity = cartRepo.findByCustomerId(customerID);
		
		
		if (cartEntity == null) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This customer's cart doesn't exist");
		}
		
		List<CartItem> tempList = cartEntity.getCartItem();
		

		
		if(tempList == null) {
			cartEntity.addCartItem(productID, amount, price, productOption);
			cartEntity.calculateTotalPrice();
			return cartRepo.save(cartEntity);
		}
		
		/*
		 * In case of same item added
		 */
		if (productOption != null)
		{
			for (CartItem cartItem : tempList) {
				if(cartItem.getProductID().equalsIgnoreCase(productID) && cartItem.getProductOption() != null && cartItem.getProductOption().equalsIgnoreCase(productOption) ) {
					if(cartItem.getPrice() != price) {
						throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product Item Price Error. same product but different prize. Current price is {}");
					}
					cartItem.addAmount(amount);
					cartEntity.setCartItem(tempList);
					cartEntity.calculateTotalPrice();
					return cartRepo.save(cartEntity);
				}
			}
			cartEntity.addCartItem(productID, amount, price, productOption);
			cartEntity.setCartItem(tempList);
			cartEntity.calculateTotalPrice();
			return cartRepo.save(cartEntity);
		}
		else
		{
			for (CartItem cartItem : tempList) {
				if(cartItem.getProductID().equalsIgnoreCase(productID) && cartItem.getProductOption() == null) {
					cartItem.addAmount(amount);
					cartEntity.setCartItem(tempList);
					cartEntity.calculateTotalPrice();
					return cartRepo.save(cartEntity);
				}
			}
			
			cartEntity.addCartItem(productID, amount, price, productOption);
			cartEntity.calculateTotalPrice();
			return cartRepo.save(cartEntity);
		}
	}
	
	public CartEntity removeCartItem(String customerID, String productID, String productOption) {
		if (customerID == null || customerID.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CustomerID required");
		}
		
		if (productID == null || productID.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ProductID required");
		}
	
		CartEntity cartEntity = cartRepo.findByCustomerId(customerID);
		
		if (cartEntity == null) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This customer's cart doesn't exist");
		}
		
		List<CartItem> tempList = cartEntity.getCartItem();
	
		if(tempList == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This customer's cart doesn't have any item");
		}
		
		/*
		 * In case of same item added
		 */
		if (productOption != null)
		{
			for (CartItem cartItem : tempList) {
				if(cartItem.getProductID().equalsIgnoreCase(productID) && cartItem.getProductOption() != null && cartItem.getProductOption().equalsIgnoreCase(productOption) ) {
					tempList.remove(cartItem);
					cartEntity.setCartItem(tempList);
					cartEntity.calculateTotalPrice();
					return cartRepo.save(cartEntity);
				}
			}
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This customer's cart doesn't have this item");
		}
		else
		{
			for (CartItem cartItem : tempList) {
				if(cartItem.getProductID().equalsIgnoreCase(productID) && cartItem.getProductOption() == null) {
					tempList.remove(cartItem);
					cartEntity.setCartItem(tempList);
					cartEntity.calculateTotalPrice();
					return cartRepo.save(cartEntity);
				}
			}
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This customer's cart doesn't have this item");
		}
	}


	public CartEntity updateItemQuatity(String customerID, String productID, String productOption, int amount) {
		if (customerID == null || customerID.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CustomerID required");
		}
		
		if (productID == null || productID.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ProductID required");
		}
		
		if (amount <=0)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unvalid quatity amount");
		}
	
		CartEntity cartEntity = cartRepo.findByCustomerId(customerID);
		
		if (cartEntity == null) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This customer's cart doesn't exist");
		}
		
		List<CartItem> tempList = cartEntity.getCartItem();
	
		if(tempList == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This customer's cart doesn't have any item");
		}
		
		/*
		 * In case of same item added
		 */
		if (productOption != null)
		{
			for (CartItem cartItem : tempList) {
				if(cartItem.getProductID().equalsIgnoreCase(productID) && cartItem.getProductOption() != null && cartItem.getProductOption().equalsIgnoreCase(productOption) ) {
					cartItem.setAmount(amount);
					if(amount == 0) {
						cartItem.setAmount(amount);
					}
					cartEntity.setCartItem(tempList);
					cartEntity.calculateTotalPrice();
					return cartRepo.save(cartEntity);
				}
			}
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This customer's cart doesn't have this item");
		}
		else
		{
			for (CartItem cartItem : tempList) {
				if(cartItem.getProductID().equalsIgnoreCase(productID) && cartItem.getProductOption() == null) {
					cartItem.setAmount(amount);
					if(amount == 0) {
						cartItem.setAmount(amount);
					}
					cartEntity.setCartItem(tempList);
					cartEntity.calculateTotalPrice();
					return cartRepo.save(cartEntity);
				}
			}
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This customer's cart doesn't have this item");
		}
	}

	public CartEntity getCart(String customerID) {
		return cartRepo.findByCustomerId(customerID);
	}

	public List<CartEntity> getCarts(){
		return cartRepo.findAll();
	}

	public void clearCart(String customerID) {
		if (customerID == null || customerID.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CustomerID required");
		}
		
		CartEntity cartEntity = cartRepo.findByCustomerId(customerID);
		
		if (cartEntity == null) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This customer's cart doesn't exist");
		}
		cartEntity.clearCartItem();
		cartRepo.save(cartEntity);
	}
	
}
