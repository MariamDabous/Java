package com.example.axsos.login.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.axsos.login.models.LoginUser;
import com.example.axsos.login.models.Project;
import com.example.axsos.login.models.User;
import com.example.axsos.login.services.ProjectService;
import com.example.axsos.login.services.UserService;


@Controller
public class UserController {
	
	@Autowired
    private UserService userServ;
	
	@Autowired
	private ProjectService projectService;
	
   
   @GetMapping("/")
   public String index(Model model, HttpSession session) {
   	
   	if (session.getAttribute("userId")!= null){
   		return "redirect:/dashboard";
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
       return "redirect:/dashboard";
     
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
       return "redirect:/dashboard";
   }
   
   @GetMapping ("/dashboard")
   public String home(Model model, HttpSession session){
   	if (session.getAttribute("userId")!= null){
   		Long userId = (Long) session.getAttribute("userId");
   		User currentUser = userServ.findUserById(userId);
   		model.addAttribute("currentUser", currentUser);	
   		return "dashboard.jsp";
   	}
   	return "redirect:/";
   	  		
   }
   
   @GetMapping ("/logout")
   public String logout(HttpSession session){
   	session.invalidate();
   	return "redirect:/";		
   }
   
   /////////////////create project////////////
   @GetMapping("/project/new")
   public String index2(@ModelAttribute("project") Project project, Model model, HttpSession session) {
	   if (session.getAttribute("userId")!= null){
	   		Long userId = (Long) session.getAttribute("userId");
	   		User currentUser = userServ.findUserById(userId);
	   		model.addAttribute("currentUser", currentUser);
	   		return "projectform.jsp";
   }
	   return "redirect:/";
   }
   
//   @PostMapping("/createproject")
//	public String create(@Valid @ModelAttribute("project") Project project, BindingResult result,Model model, HttpSession session ) {
//		if (result.hasErrors()) {
//           return "projectform.jsp";
//       } else {
//    	   Long userId = (Long) session.getAttribute("userId");
//	   	   User currentUser = userServ.findUserById(userId);
////	   	   project.setUser(currentUser);
//	   	   System.out.println("The user is"+currentUser);
//           projectService.createProject(project);
//           System.out.println("The project is"+project);
//           return "redirect:/project/new";
//       }
//	}
   
}
