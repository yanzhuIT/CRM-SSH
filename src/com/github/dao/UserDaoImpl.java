package com.github.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.github.entity.User;
import com.sun.org.apache.regexp.internal.recompile;

public class UserDaoImpl implements UserDao {

	public HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	public User userLogin(User user) {
		// query user for login by 'username' and 'password'-----hql: for class
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) hibernateTemplate.find("from User where username=? and password=?",
				user.getUsername(), user.getPassword());
		// return list.get(0) would occur error if no if..else because list
		// could be null
		if (list != null && list.size() != 0) {
			return list.get(0);
		}
		return null;
	}

	public List<User> findAll() {
		return (List<User>) this.getHibernateTemplate().find("from User");
	}
}
