package com.syb.spring.dao;

import org.springframework.data.repository.CrudRepository;

import com.syb.spring.entities.Seo;

public interface SeoRepository extends CrudRepository<Seo, Integer>{
	
	public Seo findByPageId(Integer id);
}
