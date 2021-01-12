package com.wechat.model.pojo;

import java.util.Date;

public class Dm_table {
	private int id;
	private String media_id;
	private int user_id;
	private Date creatTime;
	private Date expirationTime;
	
	@Override
	public String toString() {
		return "Dm_table [id=" + id + ", media_id=" + media_id + ", user_id=" + user_id + ", creatTime=" + creatTime
				+ ", expirationTime=" + expirationTime + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Dm_table(int id, String media_id, int user_id, Date creatTime, Date expirationTime) {
		super();
		this.id = id;
		this.media_id = media_id;
		this.user_id = user_id;
		this.creatTime = creatTime;
		this.expirationTime = expirationTime;
	}
	public Dm_table() {
		super();
	}
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public Dm_table(String media_id, int user_id, Date creatTime, Date expirationTime) {
		super();
		this.media_id = media_id;
		this.user_id = user_id;
		this.creatTime = creatTime;
		this.expirationTime = expirationTime;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	public Date getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}

}
