package com.syb.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syb.spring.dao.IUserDao;
import com.syb.spring.entities.User;


@Service
@Transactional
public class UserService {

	@Autowired
	private IUserDao userDao;
	
	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		for (User user : userDao.findAll())
			users.add(user);
		return users;
	}
	
	public Optional<User> getById(Integer id) {
		if (id == null) 
			return null;
		return userDao.findById(id);
	}
	
	public User save(User user) {
		return userDao.save(user);
	}
	
	public void delete(User user) {
		userDao.delete(user);
	}
}
