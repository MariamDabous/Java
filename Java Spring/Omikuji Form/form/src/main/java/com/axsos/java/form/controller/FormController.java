package com.axsos.java.form.controller;

import javax.servlet.http.HttpSession;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@SpringBootApplication
@Controller
public class FormController {
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String submitform(
	    @RequestParam(value="num") Integer number,
	    @RequestParam(value="city")String city1,
	    @RequestParam(value="person") String person1,
	    @RequestParam(value="hoppy")String hoppy1,
	    @RequestParam(value="living") String living1,
	    @RequestParam(value="nice") String nice1,
	    HttpSession session12 ) {
	    session12.setAttribute("num12", number);
	    session12.setAttribute("city12", city1);
	    session12.setAttribute("person", person1);
	    session12.setAttribute("hoppy", hoppy1);
	    session12.setAttribute("living", living1);
	    session12.setAttribute("say", nice1);
	    
	    return "redirect:/result"; 
	}
	
	@RequestMapping("/")
	public String form(){
		
		return "form.jsp";
	}
	
	@RequestMapping("/result")
	public String result(){
		return "result.jsp";
	}
	

}
	

