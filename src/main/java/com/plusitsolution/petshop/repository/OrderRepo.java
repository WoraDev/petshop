package com.plusitsolution.petshop.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.plusitsolution.petshop.entity.OrderEntity;
import com.plusitsolution.petshop.entity.PetProductEntity;

@Repository
public interface OrderRepo extends ElasticsearchRepository<OrderEntity, String> {
	public List<OrderEntity> findAll();
	public PetProductEntity findByOrderIdStartsWith(String OrderId);
	public PetProductEntity findByOrderId(String OrderId);
	public PetProductEntity deleteByOrderId(String OrderId);
}