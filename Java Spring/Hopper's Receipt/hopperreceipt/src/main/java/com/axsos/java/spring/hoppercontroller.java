package com.axsos.java.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class hoppercontroller {
	
	// class definition and imports here...
    @RequestMapping("/")
    public String index(Model model) {
        
        String name = "Grace Hopper";
        String itemName = "Copper wire";
        double price = 5.25;
        String description = "Metal strips, also an illustration of nanoseconds.";
        String vendor = "Little Things Corner Store";
    
    	// Your code here! Add values to the view model to be rendered
        model.addAttribute("name", name);
        model.addAttribute("itemname", itemName);
        model.addAttribute("price", price);
        model.addAttribute("desc", description);
        model.addAttribute("vendor", vendor);
        
    
        return "index.jsp";
    }
    //...
    


}
