package com.spring.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.template.model.User;
import com.spring.template.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/", "home"}, method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listAll(Model model){
		model.addAttribute("users", userService.getAll());
		return "users";
	}
	
	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute User user){
		userService.addUser(user);
		return "redirect:/success.html";
	}
	
	@RequestMapping(value = "success", method = RequestMethod.GET)
	public String success(){
		return "success";
	}
}
