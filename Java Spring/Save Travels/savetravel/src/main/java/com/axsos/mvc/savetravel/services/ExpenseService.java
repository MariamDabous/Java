package com.axsos.mvc.savetravel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axsos.mvc.savetravel.models.Expense;
import com.axsos.mvc.savetravel.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenserepository;

	public ExpenseService(ExpenseRepository expenserepository) {
		this.expenserepository = expenserepository;
	}
	public List<Expense> allexpenses(){
		return expenserepository.findAll();
	}
	
	public Expense createExpense(Expense a) {
		return expenserepository.save(a);
	}
	
	
	
}
