package com.github.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.github.entity.Customer;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class pClass;

	public BaseDaoImpl() {
		// get running class which one extends BaseDaoImpl, here is
		// CustomerDaoImpl
		Class clazz = this.getClass();
		// get BaseDaoImpl<Customer>, import java.lang.reflect.Type
		Type type = clazz.getGenericSuperclass();
		ParameterizedType pType = (ParameterizedType) type;
		// get <Customer>
		Type[] types = pType.getActualTypeArguments();
		Class tClass = (Class) types[0];

		pClass = tClass;

	}

	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	// cannot code like T.class
	public T findById(int id) {
		// return (T) this.getHibernateTemplate().get(T.class, id);
		return (T) this.getHibernateTemplate().get(pClass, id);
	}

	public List<T> findAll() {
		// return this.getHibernateTemplate().find("from ", T);
		return (List<T>) this.getHibernateTemplate().find("from " + pClass.getSimpleName());
	}
}
