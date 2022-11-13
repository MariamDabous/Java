package com.example.axsos.productandcategory.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.axsos.productandcategory.models.Category;
import com.example.axsos.productandcategory.models.Product;
import com.example.axsos.productandcategory.services.AppService;
@SpringBootApplication
@Controller
public class AppController {
	private final AppService appService;
	public AppController(AppService appService) {
		this.appService=appService;
	}
	
	
	@GetMapping("/")
    public String index(Model model) {
		model.addAttribute("categories", appService.allCategorys());
		model.addAttribute("products", appService.allProducts());
			
        return "index.jsp";
    }
	
	@GetMapping("/products/{id}")
    public String index3(@PathVariable("id") Long id ,Model model, @ModelAttribute("product") Product product) {
		model.addAttribute("categories", appService.notselected(product));
		model.addAttribute("products", appService.findProduct(id));
        return "oneproduct.jsp";
    }
	
	
	
	@PostMapping("/addcategory/{id}")
	public String addcategorytoproduct( @PathVariable("id") Long id, @RequestParam("categories") Long categid) {
        	Product product1= appService.findProduct(id);
        	Category category1= appService.findCategory(categid);
        	List<Category> product1Categories= product1.getCategories();
        	product1Categories.add(category1);
        	product1.setCategories(product1Categories);
        	appService.updateProduct(product1);
        	
        	
            return "redirect:/products/{id}";
        }
	
	
	@GetMapping("/category/{id}")
    public String index4(@PathVariable("id") Long id ,Model model, @ModelAttribute("category") Category category) {
		model.addAttribute("categories", appService.findCategory(id));
		model.addAttribute("products", appService.notselected2(category));
        return "onecategory.jsp";
    }
	
	@PostMapping("/addproduct/{id}")
	public String addproducttocategory( @PathVariable("id") Long id, @RequestParam("products") Long prodid) {
			Category category1= appService.findCategory(id);
		 	Product product1= appService.findProduct(prodid);
        	List<Product> productOncategories= category1.getProducts();
        	productOncategories.add(product1);
        	category1.setProducts(productOncategories);
        	appService.updateCategory(category1);
        	
        	
            return "redirect:/category/{id}";
        }
	
	
	@GetMapping("/categories/new")
	public String index(@ModelAttribute("category") Category category ) {
		
		return "categoryForm.jsp";
	}
	
	@PostMapping("/createcategory")
	public String create(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
            return "categoryForm.jsp";
        } else {
        	appService.createCategory(category);
            return "redirect:/categories/new";
        }
	}
	

	@GetMapping("/products/new")
	public String index2(@ModelAttribute("product") Product product ) {
		
		return "productForm.jsp";
	}
	
	
	@PostMapping("/createproduct")
	public String create2(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
            return "productForm.jsp";
        } else {
        	appService.createProduct(product);
            return "redirect:/products/new";
        }
	}
	

}
