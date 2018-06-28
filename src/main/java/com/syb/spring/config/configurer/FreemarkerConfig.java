package com.syb.spring.config.configurer;

import java.util.Arrays;

import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.ext.jsp.TaglibFactory;

public class FreemarkerConfig extends FreeMarkerConfigurer{

	@Override
	public TaglibFactory getTaglibFactory() {
		TaglibFactory tagLibFactory = super.getTaglibFactory();
		tagLibFactory.setClasspathTlds(Arrays.asList("/META-INF/security.tld"));
		return tagLibFactory;
	}
}
