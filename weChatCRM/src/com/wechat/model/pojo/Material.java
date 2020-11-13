package com.wechat.model.pojo;

public class Material {
	
	private int id;
	private String theme_name;
	private String imgurl;
	public int getid() {
		return id;
	}
	public Material() {
		super();
	}
	public void setId(int id) {
		this.id = id;
	}
	public void settheme_name(String theme_name) {
		this.theme_name = theme_name;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public Material(String theme_name, String imgurl) {
		super();
		this.theme_name = theme_name;
		this.imgurl = imgurl;
	}
	public Material(int id, String theme_name, String imgurl) {
		super();
		this.id = id;
		this.theme_name = theme_name;
		this.imgurl = imgurl;
	}
	
	public String getTheme_name() {
		return theme_name;
	}
	public void setTheme_name(String theme_name) {
		this.theme_name = theme_name;
	}
	public int getId() {
		return id;
	}
	public String getImgurl() {
		return imgurl;
	}
	@Override
	public String toString() {
		return "Material [id=" + id + ", theme_name=" + theme_name + ", imgurl=" + imgurl + "]";
	}
	
}
