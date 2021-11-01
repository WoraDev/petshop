package com.plusitsolution.petshop.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.plusitsolution.petshop.entity.CategoryEntity;
import com.plusitsolution.petshop.entity.PetProductEntity;

@Repository
public interface PetProductCategoryRepo extends ElasticsearchRepository<CategoryEntity, String>{
	public List<CategoryEntity> findAll();
	public CategoryEntity findBypetProductMainCategoryStartsWith(String petProductMainCategory);
	public CategoryEntity findBypetProductMainCategory(String petProductMainCategory);
	public CategoryEntity deleteBypetProductCategoryId(String petProductCategoryId);
}
