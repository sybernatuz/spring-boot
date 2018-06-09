package com.syb.spring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syb.spring.services.UserService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private static String VIEW_NAME = "/pages/home";
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String handleRequest(HttpServletRequest request, Model model) {
		model.addAttribute("users", userService.getAll());
		return VIEW_NAME;
	}
}
