package com.github.dao;

import java.util.List;

import com.github.entity.Customer;
import com.github.entity.LinkMan;

public interface LinkManDao {

	void addLinkMan(LinkMan linkMan);

	List<LinkMan> list();

	LinkMan showById(int linkid);

	void update(LinkMan linkMan);

	List<LinkMan> multipleCondition(LinkMan linkMan);






}
