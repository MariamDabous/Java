package com.axsos.java.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//1. Annotation
@RestController
public class HelloWorldController {
	public static void main(String[] args) {
        SpringApplication.run(HelloWorldController.class, args);
}
	@RequestMapping("/")
    // 3. Method that maps to the request route above
    public String hello() { // 3
            return "Hello World!";
    }
}
