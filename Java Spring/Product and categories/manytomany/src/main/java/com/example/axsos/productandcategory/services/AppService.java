package com.example.axsos.productandcategory.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.axsos.productandcategory.models.Category;
import com.example.axsos.productandcategory.models.Product;
import com.example.axsos.productandcategory.repositories.CategoryRepository;
import com.example.axsos.productandcategory.repositories.ProductRepository;

@Service
public class AppService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	public AppService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> allProducts() {
		return productRepository.findAll();
	}
	
	public Product findProduct(Long id) {
		return this.productRepository.findById(id).orElse(null);
	}
	
	public Product updateProduct(Product b) {
		return this.productRepository.save(b);
		
	}
	
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public List<Category> allCategorys() {
		return categoryRepository.findAll();
	}
	
	public Category findCategory(Long id) {
		return this.categoryRepository.findById(id).orElse(null);
	}
	
	public Category updateCategory(Category b) {
		return this.categoryRepository.save(b);
		
	}
	
	
	public List<Category> notselected(Product a){
		return categoryRepository.findByProductsNotContains(a);
	}
	
	public List<Product> notselected2(Category a){
		return productRepository.findByCategoriesNotContains(a);
	}
	

}
