package com.syb.spring.dao;

import org.springframework.data.repository.CrudRepository;

import com.syb.spring.entities.database.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
	
}
