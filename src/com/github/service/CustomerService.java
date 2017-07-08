package com.github.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.github.dao.CustomerDao;
import com.github.entity.Customer;
import com.github.entity.CustomerPageBean;
import com.github.entity.Dict;


@Transactional
public class CustomerService {
	private CustomerDao customerDao;

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void add(Customer customer) {
		customerDao.add(customer);
		
	}

	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	public Customer findOne(int cid) {
		
		return customerDao.findOne(cid);
	}

	public void delete(Customer c) {
		customerDao.delete(c);
		
	}

	public void update(Customer customer) {
		customerDao.update(customer);
		
	}

	public CustomerPageBean pagelist(Integer currentPage) {
		
		CustomerPageBean pageBean = new CustomerPageBean();
		
		pageBean.setCurrentPage(currentPage);
		
		int totalCount = customerDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		int pageSize = 3;
		
		int totalPage = 0;
		if(totalCount % pageSize == 0){
			totalPage = totalCount / pageSize;
		}else{
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		// beginning record for every page
		int begin = (currentPage - 1) * pageSize;
		pageBean.setBegin(begin);
		
		List<Customer> list = customerDao.findPage(begin, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	public List<Customer> queryBy(Customer customer) {
		
		return customerDao.queryBy(customer);
	}

	public List<Customer> multipleCondition(Customer customer) {
		
		return customerDao.multipleCondition(customer);
	}


	public List<Dict> findLevel() {
		
		return customerDao.findLevel();
	}
	
	public List countSource(){
		return customerDao.countSource();
	}

}
