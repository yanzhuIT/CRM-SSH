package com.github.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.github.dao.CustomerDaoImpl;
import com.github.entity.Customer;
import com.github.entity.CustomerPageBean;
import com.github.entity.Dict;
import com.github.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


// user "model driven" to encapsulate entity
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	
	// user "model driven" to encapsulate entity
	private Customer customer = new Customer();
	// encapsulate form data to entity class
	public Customer getModel() {
		return customer;
	}
	
	// do not want to new objects, so define private variable, and use spring to define relationship to reduce coupling
	private CustomerService customerService;
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	

	// to add page
	public String toAddPage() {
		
		List<Dict> listLevel = customerService.findLevel();
		ServletActionContext.getRequest().setAttribute("listLevel", listLevel);
		return "toAddPage";
	}

	// add customer
	public String add() {
		customerService.add(customer);
		return "add";
	}

	// customer list
	
	// value stack method
	/*private List<Customer> list;
	public List<Customer> getList() {
		return list;
	}
	public void setList(List<Customer> list) {
		this.list = list;
	}*/

	public String list() {
		 List<Customer> list = customerService.findAll();
		 //domain object
		 ServletActionContext.getRequest().setAttribute("list", list);
		
		//list = customerService.findAll();
		// value stack
		return "list";
	}
	
	// delete a customer by cid
	public String delete(){
		int cid = customer.getCid();
		// first query to get the object, then delete
		
		Customer c = customerService.findOne(cid);
		if(c != null){
		customerService.delete(c);
		}
		return "delete";
	}
	
	// to show one customer information what are going to be changed
	public String showCustomer(){
		int cid = customer.getCid();
		Customer c = customerService.findOne(cid);
		ServletActionContext.getRequest().setAttribute("customer", c);
		return "showCustomer";
	}
	
	// edit customer information
	public String update(){
		customerService.update(customer);
		return "update";
		
	}
	
	 
	// use attribute encapsulation
	private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	// multiple page
	public String pagelist(){
		CustomerPageBean pageBean = customerService.pagelist(currentPage);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "pagelist";
	}
	
	// query by condition, if condition is null, get all.
	public String queryBy(){
		if(customer.getCustName() != null && !"".equals(customer.getCustName())){
			List<Customer> list = customerService.queryBy(customer);
			ServletActionContext.getRequest().setAttribute("list", list);
		}else{
			list();
		}
		return "queryBy";
	}
	
	// to multiple conditions query page
	public String toSelectCustomerPage(){
		
		
		return "toSelectCustomerPage";
	}
	
	// multiple conditions query
	public String multipleCondition(){
		
		List<Customer> list = customerService.multipleCondition(customer);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "multipleCondition";
	}
	
	// count customer source
	public String countSource(){
		
	    List list = customerService.countSource();
	    ServletActionContext.getRequest().setAttribute("list", list);
		return "countSource";
	}
	
	// count customer level
		public String countLevel(){
			
			
			return "countLevel";
		}



}
