package com.axsos.mvc.savetravel.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.mvc.savetravel.models.Expense;
import com.axsos.mvc.savetravel.services.ExpenseService;

@Controller
public class ExpenseController {
	private final ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseService){
        this.expenseService =expenseService;
    }
	
	@GetMapping("/expenses")
    public String newBook(@ModelAttribute("expense") Expense expense, Model model) {
		model.addAttribute("expenses",expenseService.allexpenses());
        return "index.jsp";
    }
	
	 @PostMapping("/expenses")
	    public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result , Model model) {
		 model.addAttribute("expenses",expenseService.allexpenses());  ///we have to put model to show the info in the table when there is an error
		 if (result.hasErrors()) {
	            return "index.jsp";
	        } else {
	            expenseService.createExpense(expense);
	            return "redirect:/expenses";
	        }
	    }

	
	

}
