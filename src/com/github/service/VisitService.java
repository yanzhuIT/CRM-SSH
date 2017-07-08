package com.github.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.github.dao.VisitDao;
import com.github.entity.Visit;


@Transactional
public class VisitService {
	
	// inject DAO layer's object
	private VisitDao visitDao;

	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}

	public void addVisit(Visit visit) {
		visitDao.addVisit(visit);
		
	}

	public List<Visit> list() {
		
		return visitDao.list();
	}
	

}
