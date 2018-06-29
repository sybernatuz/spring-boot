package com.syb.spring.dao;

import org.springframework.data.repository.CrudRepository;

import com.syb.spring.entities.database.User;


public interface UserRepositoy extends CrudRepository<User, Integer>{

	public User findByUsername(String username);
}
