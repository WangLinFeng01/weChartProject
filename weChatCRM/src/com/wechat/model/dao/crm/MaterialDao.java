package com.wechat.model.dao.crm;

import java.util.List;

import com.wechat.model.pojo.Material;

public interface MaterialDao {

	//往meterial表中存入数据
	public void add(Material material) ;

	//多条查询
	public List<Material> querylistBean(Material meterial);
	
	//多条删除
	public void delectImgUrl(Integer id);
}
