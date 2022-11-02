package com.java.spring.counter.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CounterController {
	@RequestMapping("/")
	 public String index(HttpSession session){
		 // Here we can use the variable session to store things!
		session.setAttribute("count", 0);
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	 public String index(HttpSession session){
		
		return "counterpage.jsp";
	}

}
