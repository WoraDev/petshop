package com.plusitsolution.petshop.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.plusitsolution.petshop.entity.CustomerEntity;

@Repository
public interface CustomerRepo extends ElasticsearchRepository<CustomerEntity, String>{
	public List<CustomerEntity> findAll();

}
