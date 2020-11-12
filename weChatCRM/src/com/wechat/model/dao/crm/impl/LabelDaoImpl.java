package com.wechat.model.dao.crm.impl;

import com.wechat.model.dao.crm.LabelDao;
import com.wechat.model.dao.crm.base.BaseDaoImpl;
import com.wechat.model.pojo.Label;

public class LabelDaoImpl extends BaseDaoImpl<Label> implements LabelDao{

	@Override
	public void addLabel(Label label) {
         String sql="insert into label values(default,?,?,?)";
         Object[] obj = {label.getUser_id(),label.getLabel_name(),label.getLabel_count()};
         dml(sql, obj);
	}

}
