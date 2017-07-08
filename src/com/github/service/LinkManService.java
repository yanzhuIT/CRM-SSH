package com.github.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.github.dao.LinkManDao;
import com.github.entity.Customer;
import com.github.entity.LinkMan;

@Transactional
public class LinkManService {
	// inject using object
	private LinkManDao linkManDao;

	public LinkManDao getLinkManDao() {
		return linkManDao;
	}

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	// add linkman
	public void addLinkMan(LinkMan linkMan) {
		linkManDao.addLinkMan(linkMan);

	}

	public List<LinkMan> list() {

		return linkManDao.list();
	}

	public LinkMan showById(int linkid) {
		
		return linkManDao.showById(linkid);
	}

	public void update(LinkMan linkMan) {
		linkManDao.update(linkMan);
		
	}

	public List<LinkMan> multipleCondition(LinkMan linkMan) {
		return  linkManDao.multipleCondition(linkMan);
	}

}
