package com.github.dao;

import java.util.List;

import com.github.entity.Visit;

public interface VisitDao {

	void addVisit(Visit visit);

	List<Visit> list();

}
