package com.syb.spring.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.syb.spring.entities.PageConfiguration;
import com.syb.spring.entities.ResponseHolder;

@Service
public class SeoService {

	public void process(Model model, ResponseHolder responseHolder, HttpServletRequest request, PageConfiguration pageConfiguration) {
		model.addAttribute("canonical", getCanonical(request));
		model.addAttribute("title", pageConfiguration.getName());
	}
	
	private String getCanonical(HttpServletRequest request) {
		return request.getRequestURL().toString();
	}
}
