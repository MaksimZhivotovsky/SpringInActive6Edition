package com.example.max.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "")
public class LoginController {

	@GetMapping(value = "/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping(value = "/register")
	public String registerPage() {
		return "register";
	}
} 
