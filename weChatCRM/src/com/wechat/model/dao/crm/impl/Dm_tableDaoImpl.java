package com.wechat.model.dao.crm.impl;

import com.wechat.model.dao.crm.Dm_tableDao;
import com.wechat.model.dao.crm.base.BaseDaoImpl;
import com.wechat.model.pojo.Dm_table;

public class Dm_tableDaoImpl extends BaseDaoImpl<Dm_table> implements Dm_tableDao {

	@Override
	public Dm_table queryDm_tableDaobyuserId(int id) {
		String sql="select * from dm_table where user_id=?";
		Object[] obj= {id};
		return queryForBean(sql, obj);
	}

	@Override
	public void addDm_tableDao(Dm_table dm_table) {
		String sql="insert into dm_table values(default,?,?,?,?)";
		Object[] obj= {dm_table.getUser_id(),dm_table.getMedia_id(),dm_table.getCreatTime(),dm_table.getExpirationTime()};
		dml(sql, obj);
		
	}

}
