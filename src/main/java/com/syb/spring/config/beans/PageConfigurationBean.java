package com.syb.spring.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.syb.spring.entities.PageConfiguration;

@Configuration
public class PageConfigurationBean {

	@Bean
	public PageConfiguration profilePageConfiguration() {
		PageConfiguration pageConfiguration = new PageConfiguration();
		pageConfiguration.setId(3);
		pageConfiguration.setName("Profile");
		return pageConfiguration;
	}
	
	@Bean
	public PageConfiguration homePageConfiguration() {
		PageConfiguration pageConfiguration = new PageConfiguration();
		pageConfiguration.setId(1);
		pageConfiguration.setName("Home");
		return pageConfiguration;
	}
	
	@Bean
	public PageConfiguration errorPageConfiguration() {
		PageConfiguration pageConfiguration = new PageConfiguration();
		pageConfiguration.setId(2);
		pageConfiguration.setName("Error");
		return pageConfiguration;
	}
	
	@Bean
	public PageConfiguration userListPageConfiguration() {
		PageConfiguration pageConfiguration = new PageConfiguration();
		pageConfiguration.setId(4);
		pageConfiguration.setName("User List");
		return pageConfiguration;
	}
}
