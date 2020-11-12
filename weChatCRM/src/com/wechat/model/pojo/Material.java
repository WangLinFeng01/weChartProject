package com.wechat.model.pojo;

public class Material {
	
	private int id;
	private int theme_id;
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
	public void setTheme_id(int theme_id) {
		this.theme_id = theme_id;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public Material(int id, int theme_id, String imgurl) {
		super();
		this.id = id;
		this.theme_id = theme_id;
		this.imgurl = imgurl;
	}
	@Override
	public String toString() {
		return "Material [id=" + id + ", theme_id=" + theme_id + ", imgurl=" + imgurl + "]";
	}
	
}
