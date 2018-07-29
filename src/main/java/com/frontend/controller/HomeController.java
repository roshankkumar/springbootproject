package com.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.frontend.domain.Users;
import com.frontend.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String homeFn() {
		return "redirect:/index";
	}
	
	@RequestMapping("/index")
	public String homeMain() {
		return "index";
	}
	
	
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String signupGet( Model model) {
		Users user = new Users();
		model.addAttribute("user", user);
		return "signup";
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String signupPost(@ModelAttribute("user") Users user, Model model) {
		if(userService.checkUsernameExists(user.getUsername())) {
			model.addAttribute("emailExists", true);
			return "/index";
		}
		
		if(userService.checkEmailExists(user.getEmail())) {
			model.addAttribute("usernameExists", true);
			return "/index";
		}
		
		/*Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));*/

       userService.save(user);

      
		
		return "redirect:/";
	}
	
		
}
