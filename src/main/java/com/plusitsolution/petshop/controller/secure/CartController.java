package com.plusitsolution.petshop.controller.secure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plusitsolution.petshop.entity.CartEntity;
import com.plusitsolution.petshop.service.CartService;

@RestController
public class CartController {

	@Autowired
	CartService cartService;
	
	@PostMapping("/cart")
	public CartEntity createCart(@RequestParam("customerID") String customerID) {
		return cartService.addCart(customerID);
		
	}
	
	@PostMapping("/cartItem")
	public CartEntity addCartItem(@RequestParam("customerID") String customerID,
			@RequestParam("productID") String productID,
			@RequestParam("prodcuctInfo") String prodcuctInfo,
			@RequestParam("price") double price,
			@RequestParam("quatity") int amount,
			@RequestParam(value = "productOption", required = false) String productOption) {
		return cartService.addCartItem(customerID,productID,prodcuctInfo,price,amount,productOption);
		
	}
	
	@DeleteMapping("/cartItem")
	public CartEntity removeCartItem(@RequestParam("customerID") String customerID
			,@RequestParam("productID") String productID
			,@RequestParam(value = "productOption", required = false) String productOption) {
		return cartService.removeCartItem(customerID,productID,productOption);
		
	}
	
	@PutMapping("/cartItemQuatity")
	public CartEntity updateItemQuatity(@RequestParam("customerID") String customerID
			,@RequestParam("productID") String productID
			,@RequestParam(value = "productOption", required = false) String productOption
			,@RequestParam("quatity") int amount) {
		return cartService.updateItemQuatity(customerID, productID, productOption, amount);
		
	}
	
	@PutMapping("/clearCart")
	public String clearCart(@RequestParam("customerID") String customerID) {
		cartService.clearCart(customerID);
		return "cart-cleared";
		
	}
	
	@GetMapping("/carts")
	public List<CartEntity> getCarts() {
		return cartService.getCarts();
		
	}
	
	@GetMapping("/cart")
	public CartEntity getCart(@RequestParam("customerID") String customerID) {
		return cartService.getCart(customerID);
		
	}
	
	
	
}
