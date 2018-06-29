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

@Controller
@RequestMapping("/")
public class HomeController {
	
	private static String VIEW_NAME = "home";
	
	@Autowired
	private SeoService seoService;
	@Autowired
	private PageConfiguration homePageConfiguration;
	
	@GetMapping
	public String handleRequest(HttpServletRequest request, ModelMap model) {
		ResponseHolder responseHolder = new ResponseHolder();
		seoService.process(model, responseHolder, request, homePageConfiguration);
		return VIEW_NAME;
	}
}
