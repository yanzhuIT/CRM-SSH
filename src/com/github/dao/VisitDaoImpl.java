package com.github.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.github.entity.Visit;

public class VisitDaoImpl extends HibernateDaoSupport implements VisitDao {

	public void addVisit(Visit visit) {
		this.getHibernateTemplate().save(visit);
	}


	public List<Visit> list() {
		List<Visit> list = (List<Visit>) this.getHibernateTemplate().find("from Visit");
		return list;
	}

}
