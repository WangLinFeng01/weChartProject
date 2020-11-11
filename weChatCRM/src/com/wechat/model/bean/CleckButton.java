package com.wechat.model.bean;

public class CleckButton extends AbstractButton{
	private String type="click";
	private String key;
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}

	public CleckButton(String name, String key) {
		super(name);
		this.key = key;
	}
	
	
	
}
