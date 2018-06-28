package com.syb.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity(name = "authorities")
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Integer id;
	private String authority;
	@JoinColumn(name = "username", referencedColumnName = "username")
	private String username;

	public Authority() {
		super();
	}

	public Authority(Integer id, String authority, String username) {
		super();
		this.id = id;
		this.authority = authority;
		this.username = username;
	}

	public Authority(String authority, String username) {
		super();
		this.authority = authority;
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
