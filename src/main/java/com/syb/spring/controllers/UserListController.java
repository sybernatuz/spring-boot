package com.syb.spring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syb.spring.entities.ResponseHolder;
import com.syb.spring.services.SeoService;
import com.syb.spring.services.UserService;

@Controller
@RequestMapping("/users")
public class UserListController {
	
	private static final String VIEW_NAME = "pages/listUser";
	
	@Autowired
	private UserService userService;
	@Autowired
	private SeoService seoService;
	
	@GetMapping
	private String handleRequest(HttpServletRequest request, Model model) {
		ResponseHolder responseHolder = new ResponseHolder(request);
		userService.getAll(model);
		seoService.process(model, responseHolder, request);
		return VIEW_NAME;
	}
}
