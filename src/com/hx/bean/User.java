package com.hx.bean;

public class User {
	private String id;
	private String username;
	private String password;
	private String userCount;
	private String newUser;
	private String blogCount;
	private String newBlog;
	private String headerUrl;
	
	public User(){}
	
	public User(String id, String username, String headerUrl) {
		super();
		this.id = id;
		this.username = username;
		this.headerUrl = headerUrl;
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
	public String getUserCount() {
		return userCount;
	}
	public void setUserCount(String userCount) {
		this.userCount = userCount;
	}
	public String getNewUser() {
		return newUser;
	}
	public void setNewUser(String newUser) {
		this.newUser = newUser;
	}
	public String getBlogCount() {
		return blogCount;
	}
	public void setBlogCount(String blogCount) {
		this.blogCount = blogCount;
	}
	public String getNewBlog() {
		return newBlog;
	}
	public void setNewBlog(String newBlog) {
		this.newBlog = newBlog;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHeaderUrl() {
		return headerUrl;
	}
	public void setHeaderUrl(String headerUrl) {
		this.headerUrl = headerUrl;
	}
	
	
}
