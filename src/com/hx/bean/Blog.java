package com.hx.bean;

public class Blog {
	private String id;
	private String title;
	private String context;
	private String userId;
	private String date;
	private String comment;
	private String userImg;


	public Blog(String id, String title, String context, String userId,
			String date, String comment, String userImg) {
		super();
		this.id = id;
		this.title = title;
		this.context = context;
		this.userId = userId;
		this.date = date;
		this.comment = comment;
		this.userImg = userImg;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}


	public String getUserImg() {
		return userImg;
	}


	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	
	
}
