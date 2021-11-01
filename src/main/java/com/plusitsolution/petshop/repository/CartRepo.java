package com.plusitsolution.petshop.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.plusitsolution.petshop.entity.CartEntity;
import com.plusitsolution.petshop.entity.PetProductEntity;



@Repository
public interface CartRepo extends ElasticsearchRepository<CartEntity, String>{
	public List<CartEntity> findAll();
	public CartEntity findByCustomerId(String customerId);
}
