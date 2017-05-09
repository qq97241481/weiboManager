package com.hx.bean;

public class Comments {
	private String id;
	private String content;
	private String userid;
	private String date;
	private String blogid;
	
	public Comments(String id, String content, String userid, String date,
			String blogid) {
		super();
		this.id = id;
		this.content = content;
		this.userid = userid;
		this.date = date;
		this.blogid = blogid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBlogid() {
		return blogid;
	}
	public void setBlogid(String blogid) {
		this.blogid = blogid;
	}
	
}
