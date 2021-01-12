package com.wechat.model.dao.crm;

import java.util.List;

import com.wechat.model.dao.crm.impl.AdminDaoImpl;
import com.wechat.model.pojo.Admin;

public interface AdminDao {
	
	//获取total
	public int getTotal();
	//添加用户
	public void addAdmin(String admin_name,String password,String email);
	//修改用户
	public void updateAdmin(Admin admin);
	//查询分页多条数据
	public List<Admin> QueryAdmin1(Object[] params);
	//查询数据是否存在
	public List<Admin> QueryAdmin(Object[] params);
	
}
