package com.example.max.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.max.model.UserRepo;
import com.example.max.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "")
public class LoginController {
	
	private final UserService userService;

	@GetMapping(value = "/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping(value = "/register")
	public String registerPage(Model model) {
		model.addAttribute("user", new UserRepo());
		return "register";
	}
	
	@PostMapping(value = "/register")
	public String registerUser(UserRepo userRepo,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "register";
		}
		if(!userRepo.getPassword().equals(userRepo.getRepeatPassword())) {
			bindingResult.rejectValue("passord", "пароли не совпадают");
			return "register";
		}
		userService.createUser(userRepo);
		return "redirect:/login";
	}
} 
