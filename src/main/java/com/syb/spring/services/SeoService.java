package com.syb.spring.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.syb.spring.entities.ResponseHolder;

@Service
public class SeoService {

	public void process(Model model, ResponseHolder responseHolder, HttpServletRequest request) {
		model.addAttribute("canonical", getCanonical(request));
	}
	
	private String getCanonical(HttpServletRequest request) {
		return request.getRequestURL().toString();
	}
}
