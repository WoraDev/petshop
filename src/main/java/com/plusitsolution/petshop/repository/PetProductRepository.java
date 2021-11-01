package com.plusitsolution.petshop.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import com.plusitsolution.petshop.entity.PetProductEntity;

@Repository
public interface PetProductRepository extends ElasticsearchRepository<PetProductEntity, String> {
	public List<PetProductEntity> findAll();
	public PetProductEntity findBypetProductNameStartsWith(String petProductName);
	public PetProductEntity findBypetProductName(String petProductName);
	public List<PetProductEntity> findBypetProductSubCategory(String petProductSubCategory);
}
