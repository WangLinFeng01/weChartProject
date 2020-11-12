package com.wechat.model.pojo;

public class Activity_user {
	private int material_id;
	private int parent_id;
	private int user_id;
	public int getmaterial_id() {
		return material_id;
	}
	public Activity_user(int material_id, int parent_id, int user_id, String theme_name) {
		super();
		this.material_id = material_id;
		this.parent_id = parent_id;
		this.user_id = user_id;
		this.theme_name = theme_name;
	}
	public Activity_user() {
		super();
	}
	public void setmaterial_id(int material_id) {
		this.material_id = material_id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	private String theme_name;

}
