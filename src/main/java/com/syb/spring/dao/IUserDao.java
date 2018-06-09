package com.syb.spring.dao;

import org.springframework.data.repository.CrudRepository;

import com.syb.spring.entities.User;


public interface IUserDao extends CrudRepository<User, Integer>{

}
