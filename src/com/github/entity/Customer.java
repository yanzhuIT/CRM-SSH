package com.github.entity;

import java.util.HashSet;
import java.util.Set;

public class Customer {

	private Integer cid;
	private String custName;
//	private String custLevel;
	private String custSource;
	private String custLinkman; // static value, not the same as the LinkMan

	// customer level, using dictionary table, many-to-one
	// we do not need to make a set in Dict, no this requirement
	private Dict dictCustLevel;
	public Dict getDictCustLevel() {
		return dictCustLevel;
	}

	public void setDictCustLevel(Dict dictCustLevel) {
		this.dictCustLevel = dictCustLevel;
	}

	// all linkman(business) one-to-many
	private Set<LinkMan> linkMans = new HashSet<>();

	// customer's visited records, one-to-many
	private Set<Visit> customerVisits = new HashSet<>();

	public Set<Visit> getCustomerVisits() {
		return customerVisits;
	}

	public void setCustomerVisits(Set<Visit> customerVisits) {
		this.customerVisits = customerVisits;
	}

	public Set<LinkMan> getLinkMans() {
		return linkMans;
	}

	public void setLinkMans(Set<LinkMan> linkMans) {
		this.linkMans = linkMans;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

//	public String getCustLevel() {
//		return custLevel;
//	}
//
//	public void setCustLevel(String custLevel) {
//		this.custLevel = custLevel;
//	}

	public String getCustSource() {
		return custSource;
	}

	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}

	public String getCustLinkman() {
		return custLinkman;
	}

	public void setCustLinkman(String custLinkman) {
		this.custLinkman = custLinkman;
	}

}
