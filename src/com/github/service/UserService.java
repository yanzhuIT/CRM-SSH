package com.github.service;

import java.awt.image.VolatileImage;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.github.dao.UserDao;
import com.github.entity.User;

@Transactional
public class UserService {

	// use interface variable, but refer property to userDaoImpl in spring file bean.xml
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User login(User user) {
		return userDao.userLogin(user);
	}

	public List<User> findAll() {
		
		return userDao.findAll();
	}


}
