package com.github.dao;

import java.util.List;

import com.github.entity.Customer;
import com.github.entity.CustomerPageBean;
import com.github.entity.Dict;

public interface CustomerDao extends BaseDao<Customer>{

	//void add(Customer customer);

	List<Customer> findAll();

	Customer findOne(int cid);

	//void delete(Customer c);

	//void update(Customer customer);

	int findCount();

	List<Customer> findPage(int begin, int pageSize);

	List<Customer> queryBy(Customer customer);

	List<Customer> multipleCondition(Customer customer);

	List<Dict> findLevel();
	
	List countSource();




}
