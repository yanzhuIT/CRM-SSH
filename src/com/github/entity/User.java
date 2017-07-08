package com.github.entity;

import java.util.HashSet;
import java.util.Set;

public class User {

	private Integer uid;
	private String username;
	private String password;
	private String address;

	// user's visiting record , one-to-many
	private Set<Visit> userVisits = new HashSet<>();

	public Set<Visit> getUserVisits() {
		return userVisits;
	}

	public void setUserVisits(Set<Visit> userVisits) {
		this.userVisits = userVisits;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
