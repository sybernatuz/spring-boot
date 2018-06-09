package com.syb.spring.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.syb.spring.dao.IUserDao;
import com.syb.spring.entities.User;


@Service
@Transactional
public class UserService {

	@Autowired
	private IUserDao userDao;
	
	public void getAll(Model model) {
		List<User> users = new ArrayList<>();
		for (User user : userDao.findAll())
			users.add(user);
		model.addAttribute("user", users);
	}
	
	public void getById(Model model, Integer id) {
		if (id == null) 
			return;
		model.addAttribute("user", userDao.findById(id));
	}
	
	public void save(User user) {
		userDao.save(user);
	}
	
	public void delete(User user) {
		userDao.delete(user);
	}
}
