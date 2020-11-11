package com.wechat.model.pojo;

public class Material_user {
	
	private int media_id;
	private int user_id;
	private int material_id;
	private long creatTime;
	private long expirationTime;
	public int getMedia_id() {
		return media_id;
	}
	public void setMedia_id(int media_id) {
		this.media_id = media_id;
	}
	public Material_user(int media_id, int user_id, int material_id, long creatTime, long expirationTime) {
		super();
		this.media_id = media_id;
		this.user_id = user_id;
		this.material_id = material_id;
		this.creatTime = creatTime;
		this.expirationTime = expirationTime;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getMaterial_id() {
		return material_id;
	}
	public void setMaterial_id(int material_id) {
		this.material_id = material_id;
	}
	public long getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(long creatTime) {
		this.creatTime = creatTime;
	}
	public long getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(long expirationTime) {
		this.expirationTime = expirationTime;
	}

}
