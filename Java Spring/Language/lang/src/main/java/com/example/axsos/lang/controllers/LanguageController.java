package com.example.axsos.lang.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.axsos.lang.models.Language;
import com.example.axsos.lang.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
    public LanguageController(LanguageService languageService){
        this.languageService =languageService;
    }
	
	@GetMapping("/languages")
    public String newLanguage(@ModelAttribute("language") Language language, Model model) {
		model.addAttribute("languages",languageService.alllanguages());
        return "all.jsp";
    }
	
	 @PostMapping("/createlang")
	    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result , Model model) {
		 model.addAttribute("languages",languageService.alllanguages());  ///we have to put model to show the info in the table when there is an error
		 if (result.hasErrors()) {
	            return "all.jsp";
	        } else {
	            languageService.createLanguage(language);
	            return "redirect:/languages";
	        }
	    }
	 
	 @GetMapping("/languages/edit/{id}")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Language language = languageService.findLanguage(id);
	        model.addAttribute("language", language);
	        return "edit.jsp";
	    }
	    
	    @PutMapping("/editlanguages/{id}")
	    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
	    	if (result.hasErrors()) {
	            return "edit.jsp";
	        } else {
	            languageService.updateLanguage(language);
	            return "redirect:/languages";
	        }
	    }
	    
	    
//	    @DeleteMapping("/languages/{id}")
//	    public String destroy(@PathVariable("id") Long id) {
//	    	languageService.deleteLanguage(id);
//	        return "redirect:/languages";
//	    }
	    
	    @GetMapping("/delete/languages/{id}")
	    public String destroy(@PathVariable("id") Long id) {
	    	languageService.deleteLanguage(id);
	        return "redirect:/languages";
	    }
	    
	    @GetMapping("/languages/{id}")
	    public String showLanguage(@PathVariable("id") Long id, Model model) {
			model.addAttribute("onelang", languageService.findLanguage(id));
	        return "show.jsp";
	    }

	
	

}
