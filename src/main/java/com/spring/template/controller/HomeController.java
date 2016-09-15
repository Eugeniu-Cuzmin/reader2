package com.spring.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.template.model.User;
import com.spring.template.service.SecurityService;
import com.spring.template.service.UserService;
import com.spring.template.validator.UserValidator;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = { "/", "home" }, method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("userForm", new User());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("userForm") User userForm,
			BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		userService.save(userForm);

		securityService.autologin(userForm.getUsername(),
				userForm.getPasswordConfirm());
		return "redirect:/success";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error",
					"Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message",
					"You have been logged out successfully.");

		return "login";
	}

	// @RequestMapping(value = "/users", method = RequestMethod.GET)
	// public String listAll(Model model){
	// model.addAttribute("users", userService.getAll());
	// return "users";
	// }
	//

	@RequestMapping(value = {"/", "/success"}, method = RequestMethod.GET)
	public String success() {
		return "success";
	}
}
