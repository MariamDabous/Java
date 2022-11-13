package com.example.axsos.productandcategory.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.axsos.productandcategory.models.Category;
import com.example.axsos.productandcategory.models.Product;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	List<Category> findAll();
	
    List<Category> findByProductsNotContains(Product product);

	

}