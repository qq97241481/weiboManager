package com.hx.bean;

public class Message {
	private String fromid;
	private String toid;
	private String content;
	private String createddate;
	private String hasread;
	private String conversationid;
	
	
	public Message(String fromid, String toid, String content,
			String createddate, String hasread, String conversationid) {
		super();
		this.fromid = fromid;
		this.toid = toid;
		this.content = content;
		this.createddate = createddate;
		this.hasread = hasread;
		this.conversationid = conversationid;
	}
	public String getFromid() {
		return fromid;
	}
	public void setFromid(String fromid) {
		this.fromid = fromid;
	}
	public String getToid() {
		return toid;
	}
	public void setToid(String toid) {
		this.toid = toid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateddate() {
		return createddate;
	}
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}
	public String getHasread() {
		return hasread;
	}
	public void setHasread(String hasread) {
		this.hasread = hasread;
	}
	public String getConversationid() {
		return conversationid;
	}
	public void setConversationid(String conversationid) {
		this.conversationid = conversationid;
	}
	
}
