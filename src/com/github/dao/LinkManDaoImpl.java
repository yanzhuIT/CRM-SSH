package com.github.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.internal.ast.HqlASTFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.github.entity.Customer;
import com.github.entity.LinkMan;
import com.mysql.fabric.xmlrpc.base.Array;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

	// add one record
	public void addLinkMan(LinkMan linkMan) {
		this.getHibernateTemplate().save(linkMan);
	}

	@SuppressWarnings("unchecked")
	public List<LinkMan> list() {
		return (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan");
	}

	public LinkMan showById(int linkid) {

		return this.getHibernateTemplate().get(LinkMan.class, linkid);
	}

	// update one linkman
	public void update(LinkMan linkMan) {
		this.getHibernateTemplate().update(linkMan);

	}

	public List<LinkMan> multipleCondition(LinkMan linkMan) {
		// method 1: hql
//		String hql = "from LinkMan where 1=1";
//		List<Object> para = new ArrayList<>();
//		if(linkMan.getCustomer().getCid() != null && linkMan.getCustomer().getCid() > 0){
//			// customer.cid=?
//			hql += " and customer.cid=?";
//			para.add(linkMan.getCustomer().getCid());
//		}
//		
//		if(linkMan.getLkmName() != null && !"".equals(linkMan.getLkmName())){
//			hql += " and lkmName=?";
//			para.add(linkMan.getLkmName());
//		}
//		return (List<LinkMan>) this.getHibernateTemplate().find(hql, para.toArray());
	
	// method 2 : detached criteria
		DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
		if(linkMan.getCustomer().getCid() != null && linkMan.getCustomer().getCid() > 0){
			// caution: "customer.cid"
			criteria.add(Restrictions.eq("customer.cid", linkMan.getCustomer().getCid()));
		}
		
		if(linkMan.getLkmName() != null && !"".equals(linkMan.getLkmName())){
			criteria.add(Restrictions.eq("lkmName", linkMan.getLkmName()));
		}
		
		return (List<LinkMan>) this.getHibernateTemplate().findByCriteria(criteria);
	
	}
	

}
