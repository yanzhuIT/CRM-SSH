package com.github.dao;

import java.util.List;

import com.github.entity.User;

public interface UserDao {

	User userLogin(User user);

	List<User> findAll();

}
