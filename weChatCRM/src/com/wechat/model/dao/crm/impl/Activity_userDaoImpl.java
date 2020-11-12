package com.wechat.model.dao.crm.impl;

import com.wechat.model.dao.crm.Activity_userDao;
import com.wechat.model.dao.crm.base.BaseDaoImpl;
import com.wechat.model.pojo.Activity_user;

public class Activity_userDaoImpl extends BaseDaoImpl<Activity_user> implements Activity_userDao{

	@Override
	public void addActivity_user(Activity_user activity_user) {
         String sql="insert into activity_user values(?,?,?)";
         Object[] obj= {activity_user.getUser_id(),activity_user.getParent_id(),activity_user.getmaterial_id()};
         dml(sql, obj);
	}

}
