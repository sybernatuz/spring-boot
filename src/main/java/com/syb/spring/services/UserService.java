package com.syb.spring.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.syb.spring.dao.UserRepositoy;
import com.syb.spring.entities.ResponseHolder;
import com.syb.spring.entities.User;


@Service
@Transactional
public class UserService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserRepositoy userDao;
	
	public void getAll(Model model) {
		List<User> users = new ArrayList<>();
		try {
			userDao.findAll().forEach(user -> users.add(user));
			model.addAttribute("users", users);
		} catch (NullPointerException e) {
			return;
		}
	}
	
	public void getById(Model model, ResponseHolder responseHolder) {
		String id = (String) responseHolder.getResponse("userId");
		if (id == null || !StringUtils.isNumeric(id)) 
			return;
		model.addAttribute("user", userDao.findById(Integer.parseInt(id)).orElse(null));
	}
	
	public void save(User user) {
		if (user == null)
			return;
		userDao.save(user);
		log.info("User ajouté : (id=" + user.getId());
	}
	
	public void delete(User user) {
		if (user == null)
			return;
		userDao.delete(user);
	}
}
