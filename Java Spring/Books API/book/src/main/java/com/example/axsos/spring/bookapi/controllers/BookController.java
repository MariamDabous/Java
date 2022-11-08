package com.example.axsos.spring.bookapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.axsos.spring.bookapi.services.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookservice;
	
	@GetMapping("/api/books/{id}")
	public String index(@PathVariable("id") Long bookid) {
		System.out.println(bookid);
		return "show.jsp";
	}
	
	
	

}
