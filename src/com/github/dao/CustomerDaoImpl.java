package com.github.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.ExtendsQueueEntry;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.github.entity.Customer;
import com.github.entity.CustomerPageBean;
import com.github.entity.Dict;
import com.mchange.v2.c3p0.QueryConnectionTester;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	// add customer
	/*
	 * public void add(Customer customer) {
	 * this.getHibernateTemplate().save(customer); }
	 */

	/*
	 * @SuppressWarnings("unchecked") public List<Customer> findAll() {
	 * List<Customer> list = (List<Customer>)
	 * this.getHibernateTemplate().find("from Customer"); return list; }
	 */

	// query by "cid"
	public Customer findOne(int cid) {

		return this.getHibernateTemplate().get(Customer.class, cid);
	}

	/*
	 * public void delete(Customer c) { this.getHibernateTemplate().delete(c);
	 * 
	 * }
	 */

	/*
	 * public void update(Customer customer) {
	 * this.getHibernateTemplate().update(customer);
	 * 
	 * }
	 */

	// query total record
	@SuppressWarnings("unchecked")
	public int findCount() {
		// here "Customer" is class name
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Customer");
		if (list != null && list.size() != 0) {
			Long lcount = (Long) list.get(0);
			int count = lcount.intValue();
			return count;
		}
		return 0;
	}

	// get page list from the database
	public List<Customer> findPage(int begin, int pageSize) {
		// first method: use Hibernate original method
		/*
		 * SessionFactory sessionFactory =
		 * this.getHibernateTemplate().getSessionFactory(); Session session =
		 * sessionFactory.getCurrentSession(); Query query =
		 * session.createQuery("from Customer"); query.setFirstResult(begin);
		 * query.setMaxResults(pageSize); List<Customer> list = query.list();
		 */

		// second method:
		// create detached object and its operating class
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	// query by name
	public List<Customer> queryBy(Customer customer) {
		// first method
		// List<Customer> list = (List<Customer>)
		// this.getHibernateTemplate().find("from Customer where custName like
		// ?", "%" + customer.getCustName() + "%");

		// another method
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		criteria.add(Restrictions.like("custName", "%" + customer.getCustName() + "%"));
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);

		return list;
	}

	// query by multiple conditions
	public List<Customer> multipleCondition(Customer customer) {

		/*
		 * // method 1, hibernate template find() // create a hql String hql =
		 * "from Customer where 1=1"; // set a list, if not null or "", then add
		 * the value to the list List<Object> para = new ArrayList<>();
		 * 
		 * if (customer.getCustName() != null &&
		 * !"".equals(customer.getCustName())) { hql += " and custName=?";
		 * para.add(customer.getCustName()); }
		 * 
		 * if (customer.getCustLevel() != null &&
		 * !"".equals(customer.getCustLevel())) { hql += " and custLevel=?";
		 * para.add(customer.getCustLevel()); }
		 * 
		 * if (customer.getCustSource() != null &&
		 * !"".equals(customer.getCustSource())) { hql += " and custSource=?";
		 * para.add(customer.getCustSource()); } // list to array:
		 * para.toArray() // this.getHibernateTemplate().find(hql,
		 * para.toArray()); return (List<Customer>)
		 * this.getHibernateTemplate().find(hql, para.toArray());
		 */

		// use detached object to complete multiple conditions query
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		if (customer.getCustName() != null && !"".equals(customer.getCustName())) {
			criteria.add(Restrictions.eq("custName", customer.getCustName()));
		}

		/*
		 * if (customer.getCustLevel() != null &&
		 * !"".equals(customer.getCustLevel())) {
		 * criteria.add(Restrictions.eq("custLevel", customer.getCustLevel()));
		 * }
		 */

		if (customer.getCustSource() != null && !"".equals(customer.getCustSource())) {
			criteria.add(Restrictions.eq("custLevel", customer.getCustSource()));
		}

		return (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
	}

	public List<Dict> findLevel() {
		return (List<Dict>) this.getHibernateTemplate().find("from Dict");
	}

	// For statistic, it is good to use basic sql, not hibernate
	// "SQLQuery"
	@SuppressWarnings("deprecation")
	public List countSource() {
		// 1. get session
		// this.getHibernateTemplate().getSessionFactory();
		Session session = this.getSessionFactory().getCurrentSession();
		// 2. create SQLQuery
		String sql = "SELECT COUNT(*) AS num, custSource FROM t_customer " + "GROUP BY custSource";
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		// the result has only two columns, so I can use Map here
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		List list = sqlQuery.list(); 
		return list;
	}

}
