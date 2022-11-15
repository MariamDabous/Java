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
   
}
