package com.axsos.java.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
//1. Annotation
@Controller
public class HelloWorldController {
	public static void main(String[] args) {
        SpringApplication.run(HelloWorldController.class, args);
}
	@RequestMapping("/")
    // 3. Method that maps to the request route above
    public String hello() { // 3
            return "Hello World!";
    }
	@RequestMapping("/hi")
	public String index() {
		return "any.jsp";
	}
	
	@RequestMapping("/demo")
	public String index1(Model model) {
        model.addAttribute("dojoName", "Burbank");
        return "demo.jsp";
    }
}
