package ua.blog.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.blog.entity.User;
import ua.blog.error.SignupValidator;
import ua.blog.serviceimpl.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private SignupValidator signupValidator;

	@Autowired
	private UserServiceImpl userServiceImpl;

	@RequestMapping(value = "/saveUser", method = RequestMethod.GET)
	public String saveUser(Model model) {
		model.addAttribute("users", userServiceImpl.getAllUsers());
		model.addAttribute("user", new User());
		return "saveUser";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser( @ModelAttribute User user, BindingResult result) {
		signupValidator.validate(user, result);
		if (result.hasErrors()) {
			return "saveUser";
		}
		userServiceImpl.saveUser(user);
		return "redirect:/";

	}

	@RequestMapping(value = "/deleteUsers", method = RequestMethod.POST)
	public String deleteUsers(@RequestParam String usernames) {
		userServiceImpl.deleteUserbyName(usernames);
		return "redirect:/saveUser";
	}

	@RequestMapping("/login")
	public String login() {

		return "loginpage";

	}



}
