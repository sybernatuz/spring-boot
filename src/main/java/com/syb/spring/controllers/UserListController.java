package com.syb.spring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syb.spring.entities.PageConfiguration;
import com.syb.spring.entities.ResponseHolder;
import com.syb.spring.services.SeoService;
import com.syb.spring.services.UserService;

@Controller
@RequestMapping("/users")
public class UserListController {
	
	private static final String VIEW_NAME = "listUser";
	
	@Autowired
	private UserService userService;
	@Autowired
	private SeoService seoService;
	@Autowired
	private PageConfiguration userListPageConfiguration;
	
	@GetMapping
	private String handleRequest(HttpServletRequest request, ModelMap model) {
		ResponseHolder responseHolder = new ResponseHolder();
		userService.getAll(model);
		seoService.process(model, responseHolder, request, userListPageConfiguration);
		return VIEW_NAME;
	}
}
