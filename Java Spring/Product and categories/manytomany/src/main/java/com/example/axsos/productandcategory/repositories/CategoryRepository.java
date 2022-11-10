package com.example.axsos.productandcategory.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.axsos.productandcategory.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	List<Category> findAll(); 
}
