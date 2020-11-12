package com.wechat.model.dao.crm;

import com.wechat.model.pojo.Dm_table;
import com.wechat.model.pojo.User;

public interface Dm_tableDao {
	//添加
	public void addDm_tableDao(Dm_table dm_table);
	public Dm_table queryDm_tableDaobyuserId(int id);

}
