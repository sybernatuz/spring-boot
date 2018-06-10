package com.syb.spring.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syb.spring.entities.PageConfiguration;
import com.syb.spring.entities.ResponseHolder;
import com.syb.spring.services.SeoService;
import com.syb.spring.services.UserService;

@Controller
@RequestMapping("/user/{userId}")
public class ProfileController {

	private static final String VIEW_NAME = "user";
	
	@Autowired
	private UserService userService;
	@Autowired
	private SeoService seoService;
	@Autowired
	private PageConfiguration profilePageConfiguration;

	@GetMapping
	public String handleRequest(@PathVariable Map<String, String> requestVariables, HttpServletRequest request, Model model) {
		ResponseHolder responseHolder = new ResponseHolder(requestVariables);
		userService.getById(model, responseHolder);
		seoService.process(model, responseHolder, request, profilePageConfiguration);
		return VIEW_NAME;
	}
}
