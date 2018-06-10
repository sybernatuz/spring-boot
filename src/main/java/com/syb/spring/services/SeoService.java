package com.syb.spring.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.syb.spring.dao.SeoRepository;
import com.syb.spring.entities.PageConfiguration;
import com.syb.spring.entities.ResponseHolder;
import com.syb.spring.entities.Seo;

@Service
public class SeoService {
	
	@Autowired
	SeoRepository seoRepository;
	
	public void process(Model model, ResponseHolder responseHolder, HttpServletRequest request, PageConfiguration pageConfiguration) {
		addCanonical(model, request);
		addSeoRepositoryInformations(model, pageConfiguration);
	}
	
	private void addCanonical(Model model, HttpServletRequest request) {
		String canonical = request.getRequestURL().toString();
		String contextPath = request.getContextPath();
		model.addAttribute("canonical", canonical);
		model.addAttribute("contextPath", contextPath);
	}
	
	private void addSeoRepositoryInformations(Model model, PageConfiguration pageConfiguration) {
		Seo seo = seoRepository.findByPageId(pageConfiguration.getId());
		if (seo == null)
			return;
		model.addAttribute("title", seo.getTitle());
		model.addAttribute("description", seo.getDescription());
		model.addAttribute("keywords", seo.getKeywords());
	}
}
