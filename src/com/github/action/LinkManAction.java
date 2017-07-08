package com.github.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.github.entity.Customer;
import com.github.entity.LinkMan;
import com.github.service.CustomerService;
import com.github.service.LinkManService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

// model-driven to encapsulate class, first to implement a interface
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	// encapsualte class using model-driven to get information from page
	private LinkMan linkMan = new LinkMan();

	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return linkMan;
	}

	// inject using object
	private LinkManService linkManService;

	public LinkManService getLinkManService() {
		return linkManService;
	}

	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}

	// inject CustomerService object to use its method
	private CustomerService customerService;

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public String toAddPage() {
		// query all customer and pass the list to add linkman page
		// invoke CustomerService method
		List<Customer> list = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toAddPage";
	}

	// upload through struts 2 needs file stream and file name
	// file stream should be the same to html-input type="file"-name
	private File upload;
	// file name should be (file stream + "FileName")
	private String uploadFileName;

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String addLinkMan() throws IOException {

		// judge if user want to upload file
		if (upload != null) {
			// create a file in server, "/" equals to "\\"
			File serverFile = new File("C:\\Users\\Peter\\Desktop\\test" + "/" + uploadFileName);
			// uploading
			FileUtils.copyFile(upload, serverFile);
		}

		// cid in add.jsp's select-option cannot be directly encapsulate, but
		// can be into LinkMan.java's customer.
		// original method to encapsulate cid
		/*
		 * String scid = ServletActionContext.getRequest().getParameter("cid");
		 * int cid = Integer.parseInt(scid); Customer customer = new Customer();
		 * customer.setCid(cid); linkMan.setCustomer(customer);
		 */

		// shorthand method to encapsulate cid: in add.jsp using <td
		// colspan="3"><select name="customer.cid">

		linkManService.addLinkMan(linkMan);
		return "addLinkMan";
	}
	
	
	// show list
	public String list(){
		
		List<LinkMan> list = linkManService.list();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}
	
	// to edit page
	public String showById(){
		// using model-driven class
		int linkid = linkMan.getLinkid();
		LinkMan linkman = linkManService.showById(linkid);
		
		// show all the customer to choose one
		List<Customer> customers = customerService.findAll();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("linkman", linkman);
		request.setAttribute("customers", customers);
		return "showById";
	}
	
	// update one linkman
	public String updateLinkMan(){
		linkManService.update(linkMan);
		return "updateLinkMan";
		
	}
	
	
	// to multiple conditions query page
	public String toSelectPage(){
		List<Customer> list = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toSelectPage";
	}
	
	// multiple conditions query 
	public String multipleCondition(){
		
		List<LinkMan> list =  linkManService.multipleCondition(linkMan);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "multipleCondition"; 
	}
}
