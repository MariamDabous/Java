package com.axsos.mvc.savetravel.controllers;


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

import com.axsos.mvc.savetravel.models.Expense;
import com.axsos.mvc.savetravel.services.ExpenseService;

@Controller
public class ExpenseController {
	private final ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseService){
        this.expenseService =expenseService;
    }
	
	@GetMapping("/expenses")
    public String newExpense(@ModelAttribute("expense") Expense expense, Model model) {
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
	 
	 @GetMapping("/expenses/edit/{id}")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Expense expense = expenseService.findExpense(id);
	        model.addAttribute("expense", expense);
	        return "edit.jsp";
	    }
	    
	    @PutMapping("/expenses/{id}")
	    public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
	    	if (result.hasErrors()) {
	            return "edit.jsp";
	        } else {
	            expenseService.updateExpense(expense);
	            return "redirect:/expenses";
	        }
	    }
	    
	    @DeleteMapping("/expenses/{id}")
	    public String destroy(@PathVariable("id") Long id) {
	    	expenseService.deleteExpense(id);
	        return "redirect:/expenses";
	    }
	    
	    @GetMapping("/expenses/{id}")
	    public String showExpense(@PathVariable("id") Long id, Model model) {
			model.addAttribute("oneExp", expenseService.findExpense(id));
	        return "oneexpense.jsp";
	    }

	
	

}
