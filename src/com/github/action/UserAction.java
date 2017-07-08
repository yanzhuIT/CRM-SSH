package com.github.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.github.entity.User;
import com.github.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private UserService userService;

	// strut2-----attribute-driven encapsulation
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() {

		User user = new User();
		user.setPassword(password);
		user.setUsername(username);

		// invoke userService, and then invoke userDao to query if current user
		// is in the database
		User userExist = userService.login(user);
		if (userExist != null) {

			// keep login status by session
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("user", userExist);

			return "loginSuccess";
		} else {// fail
			return "login";
		}
	}
	
	
	

}
