package com.wechat.model.dao.crm.impl;

import java.util.List;

import com.wechat.model.dao.crm.AdminDao;
import com.wechat.model.dao.crm.base.BaseDaoImpl;
import com.wechat.model.pojo.Admin;


public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao{

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addAdmin(String admin_name,String password,String email) {
		String sql ="insert into admin values(default,?,?,?,default,default)";
		Object[] params = {admin_name,password,email};
		dml(sql,params);
	}

	@Override
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Admin> QueryAdmin1(Object[] params) {
		String sql= "select admin_name,password from admin where admin_name=?";
		List<Admin> admin=queryForList(sql,params);
		return admin;
	}


	@Override
	public List<Admin> QueryAdmin(Object[] params) {
		String sql2= "select admin_name,password,email from admin";
		Object[] params1=new Object[] {};
		List<Admin> admin1=queryForList(sql2,params1);
		return admin1;
	}


}
