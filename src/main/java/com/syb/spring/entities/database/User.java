package com.syb.spring.entities.database;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity(name = "users")
@EnableAutoConfiguration
public class User implements Serializable {

	private static final long serialVersionUID = 6674709898127511826L;

	@Id
	@PrimaryKeyJoinColumn
	@Column(unique = true, nullable = false)
	@Size(min = 4, max = 100, message = "Please enter username between {min} and {max} characters.")
	private String username;
	private String password;
	@Email
	private String email;
	@Column(name = "phone_number", nullable = true)
	@Pattern(regexp="^([0-9]{10}|{0})$", message = "Please enter phone number with 10 digit.")
	private String phoneNumber;
	private boolean enabled;

	public User() {
		super();
	}

	public User(String username, String password, String email, String phoneNumber, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.enabled = enabled;
	}

	public User(String username, String password, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
