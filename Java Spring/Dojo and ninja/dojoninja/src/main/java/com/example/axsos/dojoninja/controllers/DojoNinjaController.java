package com.example.axsos.dojoninja.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.axsos.dojoninja.models.Dojo;
import com.example.axsos.dojoninja.models.Ninja;
import com.example.axsos.dojoninja.services.DojoService;
import com.example.axsos.dojoninja.services.NinjaService;
@Controller
public class DojoNinjaController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojoNinjaController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}

	@GetMapping("/dojos/new")
    public String index(@ModelAttribute("dojo") Dojo dojo) {

        return "dojo.jsp";
    }
	
	@PostMapping("/createdojo")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result ) {
		if (result.hasErrors()) {
            return "dojo.jsp";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/dojos/new";
        }
	}
	
	
	@GetMapping("/ninjas/new")
    public String index2(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.alldojos() );
        return "ninja.jsp";
    }
	
	
	@PostMapping("/createninja")
	public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result , Model model) {
		if (result.hasErrors()) {
			model.addAttribute("dojos", dojoService.alldojos()); //عشان يرجع السيليكت, اذا ما حطيناها ما بظهروا اللي داخل السيلكت
            return "ninja.jsp";
        } else {
        	ninjaService.createNinja(ninja);
            return "redirect:/ninjas/new";
        }
		
	}
	
	
	@GetMapping("/dojos/{id}")
    public String showExpense(@PathVariable("id") Long id, Model model) {
		model.addAttribute("onedojo", dojoService.findDojo(id));
        return "allninja.jsp";
    }
	
	
	

}
