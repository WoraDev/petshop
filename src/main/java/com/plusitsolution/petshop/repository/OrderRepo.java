package com.plusitsolution.petshop.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.plusitsolution.petshop.entity.OrderEntity;

@Repository
public interface OrderRepo extends ElasticsearchRepository<OrderEntity, String> {
	public List<OrderEntity> findAll();
	public List<OrderEntity> findAllByCustomerID(String customerID);
	public OrderEntity findByOrderId(String OrderId);
	public OrderEntity deleteByOrderId(String OrderId);
}