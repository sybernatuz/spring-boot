package com.syb.spring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syb.spring.entities.PageConfiguration;
import com.syb.spring.entities.ResponseHolder;
import com.syb.spring.services.SeoService;

@Controller
@RequestMapping("/error")
public class AppErrorController implements ErrorController{
	
	private static final String ERROR_PATH = "/error";
	private static final String VIEW_NAME = "error";
	
	@Autowired
	private SeoService seoService;
	@Autowired
	private PageConfiguration errorPageConfiguration;

	@GetMapping
	public String handleRequest(ModelMap model, HttpServletRequest request) {
		ResponseHolder responseHolder = new ResponseHolder();
		seoService.process(model, responseHolder, request, errorPageConfiguration);
		return VIEW_NAME;
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
}
