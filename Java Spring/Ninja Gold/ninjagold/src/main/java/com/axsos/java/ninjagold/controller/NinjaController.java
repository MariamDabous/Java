package com.axsos.java.ninjagold.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class NinjaController {
	@RequestMapping("/")
    public String index(HttpSession session) { 
		  if (session.getAttribute("gold") == null) {
	            session.setAttribute("gold", 0);
	            ArrayList<String> comments= new ArrayList<String>();
	  		  	session.setAttribute("comm", comments);
	        }
		  
		  
        return "index.jsp";

    }

    @RequestMapping("/process_farm")
    public String farm(HttpSession session) {
        int min = 10;
        int max = 20;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        Integer c = (Integer) session.getAttribute("gold");
        session.setAttribute("gold", random_int+c);
        
        ArrayList<String> com1= (ArrayList<String>) session.getAttribute("comm");
        com1.add("You entered a farm and earned "+ random_int +" gold.");
        System.out.println(random_int);
        System.out.println(session.getAttribute("gold"));
        return "redirect:/";
    }

	
	@RequestMapping("/process_cave")
	public String cave(HttpSession session) {
		int min = 5;
        int max = 10;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        Integer c = (Integer) session.getAttribute("gold");
        session.setAttribute("gold", random_int+c);
        
        ArrayList<String> com1= (ArrayList<String>) session.getAttribute("comm");
        com1.add("You entered a cave and earned "+ random_int +" gold.");    
	    return "redirect:/"; 
	}
	
	@RequestMapping("/process_house")
	public String house(HttpSession session) {
		int min = 2;
        int max = 5;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        Integer c = (Integer) session.getAttribute("gold");
        session.setAttribute("gold", random_int+c);
        
        ArrayList<String> com1= (ArrayList<String>) session.getAttribute("comm");
        com1.add("You entered a house and earned "+ random_int +" gold.");
	    return "redirect:/"; 
	}
	
	@RequestMapping("/process_quest")
	public String quest(HttpSession session) {
		int min = -50;
        int max = 50;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        Integer c = (Integer) session.getAttribute("gold");
        session.setAttribute("gold", random_int+c);
        
        ArrayList<String> com1= (ArrayList<String>) session.getAttribute("comm");
        if (random_int >0){
        	com1.add("You entered a quest and earned "+ random_int +" gold.");
        }
        else if (random_int <0){
        	com1.add("You entered a quest and lost "+ -1*random_int +" gold.");
        }
        
	    return "redirect:/"; 
	}

}
