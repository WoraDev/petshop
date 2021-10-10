package com.plusitsolution.petshop.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.plusitsolution.petshop.entity.PetProductCategoryEntity;
import com.plusitsolution.petshop.entity.PetProductEntity;

@Repository
public interface PetProductCategoryRepo extends ElasticsearchRepository<PetProductCategoryEntity, String>{
	public List<PetProductCategoryEntity> findAll();
	public PetProductCategoryEntity findBypetProductMainCategoryStartsWith(String petProductMainCategory);
	public PetProductCategoryEntity findBypetProductMainCategory(String petProductMainCategory);
	public PetProductCategoryEntity deleteBypetProductCategoryId(String petProductCategoryId);
}
