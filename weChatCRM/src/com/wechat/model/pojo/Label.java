package com.wechat.model.pojo;

public class Label {
	
	private int id;
	private int user_id;
	private String label_name;
	private int label_count;
	public int getid() {
		return id;
	}
	public Label(int id, int user_id, String label_name, int label_count) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.label_name = label_name;
		this.label_count = label_count;
	}
	public void setid(int id) {
		this.id = id;
	}
	public Label() {
		super();
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getLabel_name() {
		return label_name;
	}
	public void setLabel_name(String label_name) {
		this.label_name = label_name;
	}
	public int getLabel_count() {
		return label_count;
	}
	public void setLabel_count(int label_count) {
		this.label_count = label_count;
	}

}
