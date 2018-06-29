package com.syb.spring.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.syb.spring.dao.AuthorityRepository;
import com.syb.spring.dao.UserRepositoy;
import com.syb.spring.entities.Authority;
import com.syb.spring.entities.ResponseHolder;
import com.syb.spring.entities.User;
import com.syb.spring.enums.AuthorityEnum;

@Service
@Transactional
public class UserService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepositoy userDao;
	@Autowired
	private AuthorityRepository authorityRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public void getAll(Model model) {
		List<User> users = new ArrayList<>();
		userDao.findAll().forEach(user -> users.add(user));
		model.addAttribute("users", users);
	}

	public void getByUsername(Model model, ResponseHolder responseHolder) {
		String username = (String) responseHolder.getResponse("username");
		model.addAttribute("user", userDao.findByUsername(username));
	}

	public void save(User user, AuthorityEnum authorityEnum) {
		if (user == null)
			return;
		
		user.setEnabled(true);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user = userDao.save(user);
		authorityRepository.save(new Authority(authorityEnum.toString(), user.getUsername()));

		log.info("User ajouté : (username=" + user.getUsername() + ")");
	}
	
	public void edit(User user, AuthorityEnum authorityEnum) {
		userDao.save(user);
	}

	public void delete(User user) {
		if (user == null)
			return;
		userDao.delete(user);
	}
}
