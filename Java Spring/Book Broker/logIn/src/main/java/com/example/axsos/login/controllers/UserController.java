package com.example.axsos.login.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.axsos.login.models.Book;
import com.example.axsos.login.models.LoginUser;
import com.example.axsos.login.models.User;
import com.example.axsos.login.services.BookService;
import com.example.axsos.login.services.UserService;


@Controller
public class UserController {
	
	@Autowired
    private UserService userServ;
	@Autowired
	private BookService bookService;
   
   @GetMapping("/")
   public String index(Model model, HttpSession session) {
   	
   	if (session.getAttribute("userId")!= null){
   		return "redirect:/books";
   	}
   	
       model.addAttribute("newUser", new User());
       model.addAttribute("newLogin", new LoginUser());
       return "login.jsp";
   }
   
   @PostMapping("/register")
   public String register(@Valid @ModelAttribute("newUser") User newUser, 
           BindingResult result, Model model, HttpSession session) {
       
   	User registeredUser = userServ.register(newUser, result);
       
       if(result.hasErrors()) {
           
           model.addAttribute("newLogin", new LoginUser());
           return "login.jsp";
       }
       session.setAttribute("userId", registeredUser.getId());
       return "redirect:/books";
     
   }
   
   @PostMapping("/login")
   public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
           BindingResult result, Model model, HttpSession session) {
       
   	
        User user = userServ.login(newLogin, result);
   
       if(result.hasErrors()) {
           model.addAttribute("newUser", new User());
           return "login.jsp";
       }
       
       session.setAttribute("userId", user.getId());
       return "redirect:/books";
   }
   
   @GetMapping ("/books")
   public String home(Model model, HttpSession session){
   	if (session.getAttribute("userId")!= null){
   		Long userId = (Long) session.getAttribute("userId");
   		User currentUser = userServ.findUserById(userId);
   		model.addAttribute("currentUser", currentUser);	
   		model.addAttribute("books", bookService.allbooks() );
   		return "all.jsp";
   	}
   	return "redirect:/";
   	  		
   }
   
   @GetMapping ("/logout")
   public String logout(HttpSession session){
   	session.invalidate();
   	return "redirect:/";		
   }
   
   /////////////////////////////////Creaaaaaaaaaaaaate/////////////
   
   @GetMapping("/book/new")
   public String index2(@ModelAttribute("book") Book book, Model model, HttpSession session) {
	   if (session.getAttribute("userId")!= null){
	   		Long userId = (Long) session.getAttribute("userId");
	   		User currentUser = userServ.findUserById(userId);
	   		model.addAttribute("currentUser", currentUser);
	   		return "bookform.jsp";
   }
	   return "redirect:/";
   }
   
   @PostMapping("/createbook")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result,Model model, HttpSession session ) {
		if (result.hasErrors()) {
           return "bookform.jsp";
       } else {
    	   Long userId = (Long) session.getAttribute("userId");
	   	   User currentUser = userServ.findUserById(userId);
	   	   book.setUser(currentUser);
	   	   System.out.println("The user is"+currentUser);
           bookService.createBook(book);
           System.out.println("The book is"+book);
           return "redirect:/book/new";
       }
	}
   
/////////////////////////////////Showwwwwwwwww/////////////
   
   @GetMapping("/books/{id}")
   public String showExpense(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookService.findBook(id));
       return "one.jsp";
   }
//////////////////////Book brokeer///////////////////
   
   @GetMapping ("/bookmarket")
   public String homemarket(Model model, HttpSession session){
   	if (session.getAttribute("userId")!= null){
   		Long userId = (Long) session.getAttribute("userId");
   		User currentUser = userServ.findUserById(userId);
   		model.addAttribute("currentUser", currentUser);	
   		model.addAttribute("books", bookService.allbooks() );
   		model.addAttribute("bookOfcurrentUser", currentUser.getBorrowedBooks());
   		
   		return "bookmarket.jsp";
   	}
   	return "redirect:/";
   	  		
   }
///////////////////////////////Deleteeeeee///////////////////////
  
   @RequestMapping("/delete/{id}")
   public String destroy(@PathVariable("id") Long id) {
   	bookService.deleteBook(id);
       return "redirect:/bookmarket";
   }
   
/////////////////////////Edit update////////////////////////////////
   @GetMapping("/book/edit/{id}")
   public String edit(@PathVariable("id") Long id, Model model,HttpSession session) {
	   if (session.getAttribute("userId")!= null){  
		   Book book = bookService.findBook(id);
		   model.addAttribute("book", book);
       return "edit.jsp";
   }
	   return "redirect:/";
   }
   
   @PutMapping("/editbook/{id}")
   public String update(@Valid @ModelAttribute("book") Book book, BindingResult result,HttpSession session) { 	
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			Long userId = (Long) session.getAttribute("userId");
	   	   	User currentUser = userServ.findUserById(userId);
	   	   	book.setUser(currentUser);
	   	   	bookService.updateBook(book);
	   	   	return "redirect:/bookmarket";
       }
   }
   
  ///////////////////////////borrow//////////////////////
   
   @RequestMapping("/borrow/{id}")
   public String borrow(@PathVariable("id") Long id ,HttpSession session) {
	   Long userId = (Long) session.getAttribute("userId");
  	   User currentUser = userServ.findUserById(userId);
  	   Book borrowedbook = bookService.findBook(id);
  	   borrowedbook.setBorrower(currentUser);
  	   bookService.updateBook(borrowedbook);
       return "redirect:/bookmarket";
   }
	


//////////////return////////////////////
@RequestMapping("/return/{id}")
public String returnbook(@PathVariable("id") Long id ,HttpSession session) {
	   Long userId = (Long) session.getAttribute("userId");
	   User currentUser = userServ.findUserById(userId);
	   Book returnedbook = bookService.findBook(id);
	   returnedbook.setBorrowernull(currentUser);
	   bookService.updateBook(returnedbook);
       return "redirect:/bookmarket";
}
}

