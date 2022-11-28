package com.example.axsos.login.controllers;



import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.axsos.login.models.LoginUser;
import com.example.axsos.login.models.Team;
import com.example.axsos.login.models.User;
import com.example.axsos.login.services.TeamService;
import com.example.axsos.login.services.UserService;


@Controller
public class UserController {
	
	@Autowired
    private UserService userServ;
	
	@Autowired
	private TeamService teamService;
   
   @GetMapping("/")
   public String index(Model model, HttpSession session) {
   	
   	if (session.getAttribute("userId")!= null){
   		return "redirect:/home";
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
       return "redirect:/home";
     
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
       return "redirect:/home";
   }
   
   @GetMapping ("/home")
   public String home(Model model, HttpSession session){
   	if (session.getAttribute("userId")!= null){
   		Long userId = (Long) session.getAttribute("userId");
   		User currentUser = userServ.findUserById(userId);
   		model.addAttribute("currentUser", currentUser);
   		model.addAttribute("teams", teamService.allTeams() );
   		return "all.jsp";
   	}
   	return "redirect:/";
   	  		
   }
   
   @GetMapping ("/logout")
   public String logout(HttpSession session){
   	session.invalidate();
   	return "redirect:/";		
   }
  //////////////////create///////////////////// 
   @GetMapping("/teams/new")
	public String index2(@ModelAttribute("team") Team team, Model model, HttpSession session ) {
	   if (session.getAttribute("userId")!= null){
	   		Long userId = (Long) session.getAttribute("userId");
	   		User currentUser = userServ.findUserById(userId);
	   		model.addAttribute("currentUser", currentUser);
	   		return "newteam.jsp";
	}
	   	return "redirect:/";
   }
	
	
	@PostMapping("/createteam")
	public String create2(@Valid @ModelAttribute("team") Team team, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
           return "newteam.jsp";
       } else {
    	   Long userId = (Long) session.getAttribute("userId");
	   	   User currentUser = userServ.findUserById(userId);
	   	   team.setCreator(currentUser);
//	   	   System.out.println("The user is"+currentUser);
	   	   teamService.createTeam(team);
           return "redirect:/teams/new";
       }
	}
	
	///////////////////edit/////////////////
	@GetMapping("/teams/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model,HttpSession session) {
		if (session.getAttribute("userId")!= null){  
			Team team = teamService.findTeam(id);
			model.addAttribute("team", team);
			Long userCreatedTeamId =(Long) team.getCreator().getId();
			System.out.println(userCreatedTeamId);
			if ((Long)session.getAttribute("userId")== userCreatedTeamId) {
				return "edit.jsp";
			}
			else{
			return "redirect:/home";
			}
		}
		return "redirect:/";
}

	@PutMapping("/teams/edit/{id}")
	public String update(@Valid @ModelAttribute("team") Team team, BindingResult result,HttpSession session) { 	
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			Long userId = (Long) session.getAttribute("userId");
			User currentUser = userServ.findUserById(userId);
			teamService.updateTeam(team);
			return "redirect:/home";
}
	}
	
	////////////////delete//////////////////////
	@RequestMapping("/delete/{id}")
	public String destroy(@PathVariable("id") Long id,HttpSession session) {
		Team team = teamService.findTeam(id);
		Long userCreatedTeamId =(Long) team.getCreator().getId();
		System.out.println(userCreatedTeamId);
		if ((Long)session.getAttribute("userId")== userCreatedTeamId) {
			teamService.deleteTeam(id);
			return "redirect:/home";
		}
		else{
		return "redirect:/teams/{id}";
		}
		
		
	}
	
	///////////////Show//////////////
	@GetMapping("/teams/{id}")
    public String index3(@PathVariable("id") Long id ,Model model, @ModelAttribute("team") Team team) {
		model.addAttribute("players", userServ.notselected2(team));
		model.addAttribute("teams", teamService.findTeam(id));
        return "one.jsp";
    }
	
	@PostMapping("/addplayer/{id}")
	public String addcategorytoproduct( @PathVariable("id") Long id, @RequestParam("players") Long playerid) {
        	Team team1= teamService.findTeam(id);
        	User player= userServ.findUserById(playerid);
        	List<User> playerteam1= team1.getUsers();
        	playerteam1.add(player);
        	team1.setUsers(playerteam1);
        	teamService.updateTeam(team1);
        	
        	
            return "redirect:/teams/{id}";
        }
}
   

