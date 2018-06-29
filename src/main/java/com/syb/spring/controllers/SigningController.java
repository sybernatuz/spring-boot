package com.syb.spring.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.syb.spring.entities.PageConfiguration;
import com.syb.spring.entities.ResponseHolder;
import com.syb.spring.entities.database.User;
import com.syb.spring.enums.AuthorityEnum;
import com.syb.spring.services.SeoService;
import com.syb.spring.services.UserService;

@Controller
@RequestMapping("/user")
public class SigningController {

	private static final String LOGIN_VIEW_NAME = "login";
	private static final String REGISTER_VIEW_NAME = "register";
	
	@Autowired
	private UserService userService;
	@Autowired
	private SeoService seoService;
	@Autowired
	private PageConfiguration signingPageConfiguration;

	@GetMapping("/login")
	public String handleRequest(@RequestParam Map<String, String> requestVariables, ModelMap model, HttpServletRequest request) {
        ResponseHolder responseHolder = new ResponseHolder(requestVariables, model);
        seoService.process(model, responseHolder, request, signingPageConfiguration);
        return LOGIN_VIEW_NAME;
    }
	
	@GetMapping("/register")
	private String handleRequest(ModelMap model, HttpServletRequest request) {
		ResponseHolder responseHolder = new ResponseHolder();
        seoService.process(model, responseHolder, request, signingPageConfiguration);
		return REGISTER_VIEW_NAME;
	}
	
	@PostMapping("/register")
	private String handleRequest(@ModelAttribute User user) {
		userService.save(user, AuthorityEnum.USER);
		return "redirect:/";
	}
	    
}
