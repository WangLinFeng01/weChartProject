package com.wechat.model.pojo;

public class User {
	private int user_id;
	private String user_name;
	private String openid;
	private String headimgurl;
	private String user_label;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public User(int user_id, String user_name, String openid, String headimgurl, String user_label) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.openid = openid;
		this.headimgurl = headimgurl;
		this.user_label = user_label;
	}
	public User( String user_name, String openid, String headimgurl) {
		super();
		this.user_name = user_name;
		this.openid = openid;
		this.headimgurl = headimgurl;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getUser_label() {
		return user_label;
	}
	public void setUser_label(String user_label) {
		this.user_label = user_label;
	}

}
