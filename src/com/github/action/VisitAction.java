package com.github.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.github.entity.Customer;
import com.github.entity.User;
import com.github.entity.Visit;
import com.github.service.CustomerService;
import com.github.service.UserService;
import com.github.service.VisitService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class VisitAction extends ActionSupport implements ModelDriven<Visit> {

	private Visit visit = new Visit();

	public Visit getModel() {
		return visit;
	}

	// inject service layer's object
	private VisitService visitService;

	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}

	// inject customerService object to use its method to query all customers

	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	// inject userService object to use its method to query all users
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String toAddPage() {

		// query all users
		List<User> listUser = userService.findAll();

		// query all customers
		List<Customer> listCustomer = customerService.findAll();

		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listCustomer", listCustomer);
		request.setAttribute("listUser", listUser);

		return "toAddPage";

	}

	public String addVisit() {

		visitService.addVisit(visit);
		return "addVisit";
	}
	
	// list all visiting record
	public String list(){
		
		List<Visit> list = visitService.list();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}

}
