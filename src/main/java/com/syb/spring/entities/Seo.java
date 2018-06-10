package com.syb.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "seo")
public class Seo {

	@Id
	private Integer id;
	private String title;
	private String description;
	private String keywords;

	@Column(name = "page_id")
	private Integer pageId;

	public Seo(Integer id, String title, String description, String keywords, Integer pageId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.keywords = keywords;
		this.pageId = pageId;
	}

	public Seo() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

}
