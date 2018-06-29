package com.syb.spring.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.syb.spring.entities.PageConfiguration;
import com.syb.spring.entities.ResponseHolder;
import com.syb.spring.entities.database.User;
import com.syb.spring.enums.AuthorityEnum;
import com.syb.spring.services.SeoService;
import com.syb.spring.services.UserService;

@Controller
@RequestMapping("/user/{username}")
public class ProfileController {

	private static final String VIEW_NAME = "user";
	
	@Autowired
	private UserService userService;
	@Autowired
	private SeoService seoService;
	@Autowired
	private PageConfiguration profilePageConfiguration;

	@GetMapping
	public String handleRequest(@PathVariable Map<String, String> requestVariables, HttpServletRequest request, ModelMap model) {
		ResponseHolder responseHolder = new ResponseHolder(requestVariables);
		userService.getByUsername(model, responseHolder);
		seoService.process(model, responseHolder, request, profilePageConfiguration);
		return VIEW_NAME;
	}
	
	@PostMapping("/edit")
	@PreAuthorize("#user.username == authentication.name")
	public String handleRequest(@Valid @ModelAttribute User user, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("errors", bindingResult);
			redirectAttributes.addFlashAttribute("formUser", user);
		} else {
			userService.edit(user, AuthorityEnum.USER);
		}
		
		return "redirect:/user/" + user.getUsername();
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
