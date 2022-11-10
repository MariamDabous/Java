package com.example.axsos.productandcategory.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.axsos.productandcategory.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
	List<Product> findAll(); 

}
